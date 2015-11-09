

(defun all-length(listy)
	(cond
		((null listy) 0)
                ((atom listy) 1)
	         
                (t (+ (all-length (car listy))
                      (all-length (cdr listy))))))


