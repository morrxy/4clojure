; Topics:	seqs core-functions
; Given a side-effect free function f and an initial value x write a function which returns an infinite lazy sequence of x, (f x), (f (f x)), (f (f (f x))), etc.

(= (take 5 (__ #(* 2 %) 1)) [1 2 4 8 16])

(= (take 100 (__ inc 0)) (take 100 (range)))

(= (take 9 (__ #(inc (mod % 3)) 1)) (take 9 (cycle [1 2 3])))

; Special Restrictions
; iterate


; solutions:

(fn it [f v]
  (lazy-seq
   (cons v (it f (f v)))))
