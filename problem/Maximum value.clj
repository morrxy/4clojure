; Topics:	core-functions
; Write a function which takes a variable number of parameters and returns the maximum value.

; (= (__ 1 8 3 4) 8)
; (= (__ 30 20) 30)
; (= (__ 45 67 11) 67)

(fn [f & n] (reduce (fn [acc x] (if (< acc x) x acc)) f n))

(fn [& xs] (reduce #(if (< %1 %2) %2 %1) xs))
