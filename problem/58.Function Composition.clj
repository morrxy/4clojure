; Topics:	higher-order-functions core-functions

; Write a function which allows you to create function compositions. The parameter list should take a variable number of functions, and create a function that applies them from right-to-left.

; Special Restrictions
; comp

; (= [3 2 1] ((__ rest reverse) [1 2 3 4]))
; (= 5 ((__ (partial + 3) second) [1 2 3 4]))
; (= true ((__ zero? #(mod % 8) +) 3 5 7 9))
; (= "HELLO" ((__ #(.toUpperCase %) #(apply str %) take) 5 "hello world"))

(fn [& fs]
  (let [[f1 & fr] (reverse fs)]
    (fn [& s]
      (reduce (fn [acc f] (f acc))
              (apply f1 s)
              fr))))


(fn [& xs]
  (fn [& ys]
    (let [xs (reverse xs)]
      (reduce (fn [acc x] (x acc))
              (apply (first xs) ys)
              (rest xs)))))


(fn [& fs]
  (fn [& xs]
    (first (reduce #(vector (apply %2 %1))
                   xs
                   (reverse fs)))))
