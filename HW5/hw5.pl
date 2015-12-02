/* Part 1 */ 
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

/* Part 2 */
%all_length
all_length([],0). %base case for 0. 
all_length([H|T], Len):- 
  atom(H), 
  all_length(T, LenT), 
  Len is LenT + 1. 
    
all_length([[H|TH] | T], Len):- 
  all_length([H|TH], LenT), 
  all_length(T, LenT1), 
  Len is LenT + LenT1. 
    
%equal_a_b 
equal_a_b(L):- 
  equal_help(L,0,0). 

equal_help([], Acount, Acount). 

equal_help([H|T], Acount, Bcount):- 
  H = a -> (HA is Acount + 1, equal_help(T, HA, Bcount)); 
  H = b -> (HB is Bcount + 1, equal_help(T, Acount, HB)); 
  equal_help(T, Acount, Bcount). 

%swap_prefix_suffix
swap_prefix_suffix(K, L, S):- %K is is the middle position. L is what has been appended. S - swap
  append3(Prefix, K, Suffix, L), 
  append3(Suffix, K, Prefix, S). 
    
append3(L1, L2, L3, L):- 
  append(L1, LL, L), 
  append(L2,L3,LL).

%palin 
my_reverse([],[]). 
my_reverse([H|T], LR) :-
    my_reverse(T, TR),
    append(TR, [H], LR). 
    
palin(A):- 
    my_reverse(A, AT), 
    A = AT. 
%good 
good([0]). 
good([1|T]):- 
    append(X, Y, T), 
    good(X), 
    good(Y).
    
