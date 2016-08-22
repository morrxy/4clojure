; Topics:	seqs core-functions
; Write a function which reverses a sequence.

; (= (__ [1 2 3 4 5]) [5 4 3 2 1])
; (= (__ (sorted-set 5 7 2 7)) '(7 5 2))
; (= (__ [[1 2][3 4][5 6]]) [[5 6][3 4][1 2]])

(= (#(loop [s % r []]
   (if (empty? s)
     r
     (recur (drop-last s) (conj r (last s))))) [1 2 3 4 5]) [5 4 3 2 1])

(= (reduce conj () [1 2 3 4 5]) [5 4 3 2 1])

(= (apply conj () [1 2 3 4 5]) [5 4 3 2 1])
