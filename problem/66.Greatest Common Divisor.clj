; Given two integers, write a function which returns the greatest common divisor.

; (= (__ 2 4) 2)
; (= (__ 10 5) 5)
; (= (__ 5 7) 1)
; (= (__ 1023 858) 33)

(fn [x y]
  (loop [x x y y r (rem x y)]
    (if (= 0 r)
      y
      (recur y r (rem y r)))))

(fn [x y]
  (if (= 0 y)
    x
    (recur y (rem x y))))

(fn [x y]
  (if (= 0 y)
    x
    (recur y (mod x y))))

(fn [x y]
  (apply max
    (filter #(= 0 (mod x %) (mod y %))
            (range 1 (+ 1 (max (/ x 2) (/ y 2)))))))
