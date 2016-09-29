; Topics:	math

; Write a function which calculates the least common multiple. Your function should accept a variable number of positive integers or ratios.

(== (__ 2 3) 6)

(== (__ 5 3 7) 105)

(== (__ 1/3 2/5) 2)

(== (__ 3/4 1/6) 3/2)

(== (__ 7 5/7 2 3/5) 210)

; my solution

(fn [& xs]
  (let [x (apply max xs)]
    (loop [n 2]
      (let [r (* n x)]
        (if (every? #(zero? (mod r %)) xs)
          r
          (recur (inc n)))))))

; other solution

(fn [& x]
     (let
       [gcd (fn gcd [a b] (if (= 0 b) a (gcd b (mod a b))))
        lcm (fn lcm [a b] (/ (* a b) (gcd a b)))]
     (reduce lcm x)))

(fn [& xs]
  (/ (apply * xs)
    (reduce #(if (zero? %2) % (recur %2 (mod % %2))) xs)))
