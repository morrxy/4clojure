; Topics:	seqs core-functions
; Write a function which behaves like reduce, but returns each intermediate value of the reduction. Your function must accept either two or three arguments, and the return sequence must be lazy.

; (= (take 5 (__ + (range))) [0 1 3 6 10])
; (= (take 5 (__ + (range))) [0 1 3 6 10])
; (= (__ conj [1] [2 3 4]) [[1] [1 2] [1 2 3] [1 2 3 4]])

; Special Restrictions
; reductions

(defn my-redu
  ([f coll]
   (my-redu f (f (first coll) (second coll)) (drop 2 coll)))
  ([f init coll]
   (loop [acc init coll coll]
     (if (empty? coll)
       acc
       (recur (f acc (first coll)) (rest coll))))))

(defn my-redu [f xs]
  (transduce (map identify) f xs))
