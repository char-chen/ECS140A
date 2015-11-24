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

