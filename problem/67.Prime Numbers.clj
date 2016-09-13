; Topics:	primes
; Write a function which returns the first x number of prime numbers.

; (= (__ 2) [2 3])
; (= (__ 5) [2 3 5 7 11])
; (= (last (__ 100)) 541)

(fn [n]
  (take n
        (filter (fn [x]
                  (->> x
                       (range 2)
                       (map #(rem x %))
                       (some zero?)
                       not))
                (drop 2 (range)))))
