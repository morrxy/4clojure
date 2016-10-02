; Topics:	math

; A balanced prime is a prime number which is also the mean of the primes directly before and after it in the sequence of valid primes. Create a function which takes an integer n, and returns true iff it is a balanced prime.

(= false (__ 4))

(= true (__ 563))

(= 1103 (nth (filter __ (range)) 15))

; my solution

(fn [n]
  (letfn [(prime? [n] (every? #(not= 0 (rem n %)) (range 2 n)))
          (prev-prime [n] (if (prime? (dec n)) (dec n) (recur (dec n))))
          (next-prime [n] (if (prime? (inc n)) (inc n) (recur (inc n))))]
    (and
     (> n 3)
     (prime? n)
     (= n (/ (+ (next-prime n) (prev-prime n)) 2)))))

; other solution

(fn [x]
  (let [p? (fn [n] (not-any? zero? (map #(mod n %) (range 2 n))))
        a (first (filter p? (iterate dec (dec x))))
        b (first (filter p? (iterate inc (inc x))))]
    (and
     (> x 3)
     (p? x)
     (= x (/ (+ a b) 2)))))
