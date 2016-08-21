; Write a function which returns the second to last element from a sequence.

; (= (__ (list 1 2 3 4 5)) 4)
; (= (__ ["a" "b" "c"]) "b")
; (= (__ [[1 2] [3 4]]) [1 2])

(= (#(loop [[f & r] %]
   (if (= 1 (count r))
     f
     (recur r))) (list 1 2 3 4 5)) 4)
