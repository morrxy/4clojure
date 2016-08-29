; Topics:	seqs

; Write a function which packs consecutive duplicates into sub-lists.

; (= (__ [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3)))
; (= (__ [:a :a :b :b :c]) '((:a :a) (:b :b) (:c)))
; (= (__ [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4])))

#(partition-by identity %)

#(loop [acc [] s %]
   (cond
     (nil? s) acc
     (= (first s) (last (last acc)))
     (recur (conj (drop-last acc) (conj (last acc) (first s))) (next s))
     :else (recur (conj acc [(first s)]) (next s))))



#(loop [acc [] s %]
   (if (empty? s)
     acc
     (recur
       (conj acc (take-while (fn [x] (= (first s) x)) s))
       (drop-while (fn [x] (= (first s) x)) s))))
