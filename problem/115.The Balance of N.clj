; Topics:	math

; A balanced number is one whose component digits have the same sum on the left and right halves of the number. Write a function which accepts an integer n, and returns true iff n is balanced.

(= true (__ 11))

(= true (__ 121))

(= false (__ 123))

(= true (__ 0))

(= false (__ 88099))

(= true (__ 89098))

(= true (__ 89089))

(= (take 20 (filter __ (range)))
   [0 1 2 3 4 5 6 7 8 9 11 22 33 44 55 66 77 88 99 101])

; my solution

(fn [n]
  (let [xs (->> n str (map str) (map #(Integer. %)))
        k (Math/floor (/ (count xs) 2))]
    (= (apply + (take k xs)) (apply + (take-last k xs)))))

(fn [n]
  (let [xs (->> n str seq (map int))
        k (Math/floor (/ (count xs) 2))]
    (= (apply + (take k xs)) (apply + (take-last k xs)))))

; other solution

(fn [n]
  (let [s (str n) k (count str)]
    (= (apply + (map int (take (Math/floor (/ k 2)) s)))
       (apply + (map int (drop (Math/ceil (/ k 2)) s))))))
