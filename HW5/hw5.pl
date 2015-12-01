/*******************************************/
/**    Your solution goes in this file    **/ 
/*******************************************/

/*starting in part 1*/ 
%a 

fc_course(Cl) :- 
    course(Cl, _, Units), 
    (Units=3; Units=4). 
    
%b 
prereq_110(C) :-
    course(C, P, What),
    member(ecs110, P). 
    
%c 
ecs140a_students(Name) :- 
    student(Name, Class), 
    member(ecs140a, Class). 
    
%d
instructor_names(Name) :-
  instructor(Name, _),
  teach_john(Name).

teach_john(Name) :-
  student(john, S_courses),
  instructor(Name, I_courses),
  member(Courses, I_courses), 
  member(Courses, S_courses),
  !.

%e
students(Name) :-
  student(Name, _),
  student_jim(Name).

student_jim(Name) :-
  instructor(jim, I_courses),
  student(Name, S_courses),
  member(Courses, I_courses),
  member(Courses, S_courses),
  !.

%f
allprereq(Courses, Prereq) :-
  findall(CC, (course(CC, _, _), prereq(Courses, CC)), Prereq).

prereq(Courses, Prereq) :-
  course(Courses, List, _),
  member(Prereq, List);
  course(Courses, List, _),
  member(X, List),
  prereq(X, Prereq).
