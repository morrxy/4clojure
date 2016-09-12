; Topics:	seqs core-functions

; Write a function which removes the duplicates from a sequence. Order of the items must be maintained.

; Special Restrictions
; distinct

; (= (__ [1 2 1 3 1 2 4]) [1 2 3 4])
; (= (__ [:a :a :b :b :c :c]) [:a :b :c])
; (= (__ '([2 4] [1 2] [1 3] [1 3])) '([2 4] [1 2] [1 3]))
; (= (__ (range 50)) (range 50))


#(reduce
  (fn [acc x]
    (if-let [found (some (fn [y] (= y x)) acc)]
      acc
      (conj acc x)))
  [] %)

#(sort-by (fn [i] (.indexOf % i)) (map first (group-by identity %)))

(fn [s]
  (reduce #(if ((set %1) %2) %1 (conj %1 %2))
          [] s))
