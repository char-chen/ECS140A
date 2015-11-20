;;;;;;;;;;;;;; Part 1 ;;;;;;;;;;;;;;;;;;

(defun all-length(listy)
  (cond	
    ((null listy) 0)
    ((atom listy) 1)
    (t (+ (all-length (car listy))
      (all-length (cdr listy)))))
)

(defun range(listy)
	(setq x (apply 'min listy))
	(setq y (apply 'max listy))
	(list x y)
)

(defun before (a b mylist)
	(cond ((null mylist) nil)
	((and (null a) (equal (car mylist) b)) (list (car mylist)))
	((null a) (cons (car mylist) (before nil b (cdr mylist))))
	((equal (car mylist) a) (cons (car mylist) (before nil b (cdr mylist))))
	(t (before a b (cdr mylist))))
)

; Split-if function   
(defun split-if(func mylist)
  (list (split-false func mylist) (split-true func mylist))
)

; split-if want to check if the function is TRUE
(defun split-true(func mylist)
  (cond ((null mylist) nil)
	  ((funcall func (car mylist)) (cons (car mylist) (split-true func (cdr mylist))))
	  (t (split-true func (cdr mylist))))
)

(defun split-false(func mylist)
  (cond ((null mylist) nil)
	  ((not (funcall func (car mylist))) (cons (car mylist) (split-false func (cdr mylist))))
	  (t (split-false func (cdr mylist))))
)

(defun group(l n)
  (setq x (floor (/ (list-length l) n)))
  (setq start 0)
  (setq end 0)
  (setq result '())
   
  (loop for i from 1 to x
    do (setq end (+ start n))
    do (setq result (append result (list (subseq l start end))))
    do (setq start (+ start n)))
  
  (if (not (null (subseq l end (length l))))
      (setq result (append result (list (subseq l end (length l))))))
  
  result
)

(defun mostn(f l)
  (setq m (reduce #'max (mapcar f l)))
  (setq result '())
  
  (loop for i in l
    do (if (= m (funcall f i)) 
        (setq result (append result (list i)))))

  (setq result (append (list result) (list m)))
)

;;;;;;;;;;;;;; Part 2 ;;;;;;;;;;;;;;;;;;

(defun match(l1 l2)
  (cond
    ((or (null l1) (null l2)) (equal l1 l2))
    ((equal (car l1) '?) (match (cdr l1) (cdr l2)))
    ((and (equal (car l1) '!) (match (cdr l1) (cdr l2)))T)
    ((equal (car l1) '!) (match l1 (cdr l2)))
    (T(and (equal (car l1) (car l2)) (match (cdr l1) (cdr l2))))
  )
)

;;;;;;;;;;;;;; Part 3 ;;;;;;;;;;;;;;;;;;

(defun match-var (l1 l2)
  (cond
	  ((or (null l1) (null l2)) (equal l1 l2))
	  ((and (atom (car l1)) (atom (car l2))) (and (equal (car l1) (car l2)) (match-var (cdr l1) (cdr l2))))
	  ((equal (caar l1) '?) (set (cadar l1) (car l2)) (match-var (cdr l1) (cdr l2)))
	  ((and (listp (car l1)) (equal (caar l1) '!)
	  (cond
          ((not (boundp (cadar l1))) (set (cadar l1) (list(car l2))))
          ((listp (eval(cadar l1))) (set (cadar l1) (append (eval (cadar l1)) (list(car l2)))))
          ((set (cadar l1) (list(car l2))))
	  )
    
    (match-var (cdr l1) (cdr l2)))) 
	  
    ((equal (caar l1) '!)   
      (cond
        ((not (boundp (cadar l1))) (set (cadar l1) (list(car l2)))) 
        ;((listp (eval (cadar l1))))
      )
      (match-var l1 (cdr l2))
    )
  )
)
