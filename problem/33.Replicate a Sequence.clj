; Topics:	seqs
; Write a function which replicates each element of a sequence a variable number of times.

; (= (__ [1 2 3] 2) '(1 1 2 2 3 3))
; (= (__ [1 2 3] 2) '(1 1 2 2 3 3))


(fn [s n] (reduce (fn [acc x] (apply conj acc (take n (repeat x)))) [] s))

(fn [s n] (mapcat (fn [x] (take n (repeat x))) s))

(fn [s n] (mapcat (partial repeat n) s))
