;;;;;;;;;;;; Part 1 ;;;;;;;;;;;;;;;;

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
    do (setq start (+ start n))
  )
  
  (setq lst (subseq l end (length l)))

  (if (not (null lst))
      (setq result (append result (list lst)))
  )
  
  result
)
