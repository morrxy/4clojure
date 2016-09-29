; Topics:	seqs core-functions
; Write a function which behaves like reduce, but returns each intermediate value of the reduction. Your function must accept either two or three arguments, and the return sequence must be lazy.

(= (take 5 (__ + (range))) [0 1 3 6 10])

(= (__ conj [1] [2 3 4]) [[1] [1 2] [1 2 3] [1 2 3 4]])

(= (last (__ * 2 [3 4 5])) (reduce * 2 [3 4 5]) 120)

; Special Restrictions
; reductions

; solution:

; wrong, not lazy
(defn f1
  ([f coll]
   (f1 f (f (first coll) (second coll)) (drop 2 coll)))
  ([f init coll]
   (loop [acc [init] coll coll]
     (if (empty? coll)
       acc
       (recur (conj acc (f (last acc) (first coll)))
         (rest coll))))))

; wrong, lazy, not end for finite coll
(defn f4
  ([f coll]
   (f4 f (first coll) (rest coll)))
  ([f init coll]
   (lazy-seq (cons init (f4 f (f init (first coll)) (next coll))))))

; wrong, lazy, not process last item
(defn f5
  ([f coll]
   (f5 f (first coll) (rest coll)))
  ([f init coll]
   (lazy-seq
    (when-let [ss (seq coll)]
      (cons init (f5 f (f init (first coll)) (next coll)))))))


(defn my-reductions
  ([f coll]
   (cond
     (empty? coll) (cons (f) nil)
     (and (first coll) (not (second coll))) (cons (first coll) nil)
     :else (cons (first coll) (my-reductions f (f (first coll) (second coll)) (drop 2 coll)))))
  ([f acc coll]
   (lazy-seq
    (if (empty? coll)
      (cons acc nil)
      (cons acc (my-reductions f (f acc (first coll)) (rest coll)))))))
