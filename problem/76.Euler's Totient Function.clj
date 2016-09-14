; Two numbers are coprime if their greatest common divisor equals 1. Euler's totient function f(x) is defined as the number of positive integers less than x which are coprime to x. The special case f(1) equals 1. Write a function which calculates Euler's totient function.

; (= (__ 1) 1)
; (= (__ 10) (count '(1 3 7 9)) 4)
; (= (__ 40) 16)
; (= (__ 99) 60)


(fn [n]
  (let [gcd (fn [x y] (if (zero? y) x (recur y (rem x y))))]
    (count
     (filter #(= 1 %)
      (map #((partial gcd n) %) (range n))))))


(fn [n]
  (let [gcd (fn [x y] (if (zero? y) x (recur y (rem x y))))]
    (count (filter
            #(= 1 ((partial gcd n) %))
            (range n)))))


(fn [n]
  (letfn [(gcd [x y] (if (zero? y) x (recur y (rem x y))))]
    (count
     (filter #(= 1 %)
             (map #((partial gcd n) %) (range n))))))


(fn [x]
  (letfn
    [(gcd [y] (apply max (filter #(= 0 (mod x %) (mod y %)) (range 1 (+ 1 (max (/ x 2) (/ y 2)))))))]
    (count
      (filter
        #(= 1 (gcd %))
        (range x)))))
