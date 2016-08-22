; Topics:	seqs core-functions

; Write a function which returns the total number of elements in a sequence.

; (= (__ '(1 2 3 3 1)) 5)
; (= (__ "Hello World") 11)
; (= (__ [[1 2] [3 4] [5 6]]) 3)
; (= (__ '(13)) 1)
; (= (__ '(:a :b :c)) 3)

(= (#(loop [s % c 0]
   (if-not (first s)
     c
     (recur (rest s) (inc c)))) '(:a :b :c)) 3)


(= (reduce (fn [c _] (inc c))
           0 '(:a :b :c))
   3)
