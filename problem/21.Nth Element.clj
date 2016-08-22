; Topics:	seqs core-functions

; Write a function which returns the Nth element from a sequence.

; (= (__ '(4 5 6 7) 2) 6)
; (= (__ '(4 5 6 7) 2) 6)
; (= (__ [1 2 3 4] 1) 2)
; (= (__ [1 2 3 4] 1) 2)

(= (#(loop [s %1 n 0]
  (if (= n %2)
    (first s)
    (recur (rest s) (inc n)))) [1 2 3 4] 1) 2)
