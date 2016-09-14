; Topics:	seqs

; Write a function which packs consecutive duplicates into sub-lists.

; (= (__ [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3)))
; (= (__ [:a :a :b :b :c]) '((:a :a) (:b :b) (:c)))
; (= (__ [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4])))

#(partition-by identity %)


#(loop [acc [] s %]
   (if (empty? s)
     acc
     (recur
       (conj acc (take-while (fn [x] (= (first s) x)) s))
       (drop-while (fn [x] (= (first s) x)) s))))


; use vector as acc
(fn [s]
  (loop [acc [] s s]
    (cond
      (empty? s) acc
      (= (first s) (last (last acc)))
      (recur
        (conj (vec (drop-last acc)) (conj (last acc) (first s)))
        (rest s))
      :else (recur (conj acc [(first s)]) (rest s)))))


; use vector as acc
; and use peek and pop
(fn [s]
  (loop [acc [] s s]
    (cond
      (empty? s) acc
      (= (first s) (peek (peek acc)))
      (recur
        (conj (pop acc) (conj (peek acc) (first s)))
        (rest s))
      :else (recur (conj acc [(first s)]) (rest s)))))


; use list as acc
; and use peek and pop
(fn [s]
  (reverse
   (loop [acc () s s]
     (cond
       (empty? s) acc
       (= (first s) (first (first acc)))
       (recur
         (conj (pop acc) (conj (peek acc) (first s)))
         (rest s))
       :else (recur (conj acc (list (first s))) (rest s))))))
