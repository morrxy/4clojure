; Topics:	Fibonacci seqs

; Write a function which returns the first X fibonacci numbers.

; (= (__ 3) '(1 1 2))
; (= (__ 6) '(1 1 2 3 5 8))
; (= (__ 8) '(1 1 2 3 5 8 13 21))

(= (#(loop [f [1 1]]
   (if (= % (count f))
     f
     (recur (conj f (+ (last f) (nth f (- (count f) 2))))))) 8) '(1 1 2 3 5 8 13 21))

(= (#(loop [f '(1 1) n %]
   (if (= 2 n)
     (reverse f)
     (recur (conj f (+ (first f) (second f))) (dec n)))) 8) '(1 1 2 3 5 8 13 21))

(= (#(take % (map first (iterate (fn [[i1 i2]] [i2 (+ i1 i2)]) [1 1]))) 8)
   '(1 1 2 3 5 8 13 21))

(= ((fn [n]
  (map first (reductions
    (fn [[a b] _] [b (+ a b)]) [1 1] (range 1 n)))) 6) '(1 1 2 3 5 8))
