; Topics:	math seqs

; Write a function which multiplies two numbers and returns the result as a sequence of its digits.

(= (__ 1 1) [1])

(= (__ 99 9) [8 9 1])

(= (__ 999 99) [9 8 9 0 1])

; my solution

(fn [x y]
  (->> (* x y)
       str seq
       (map #(- (int %) (int \0)))))

; other solution

#(->> (* %1 %2)
      str seq
      (map str)
      (map (fn [x] (Integer. x))))

(fn [x y]
  (map #(read-string (str %))
       (str (* x y))))

(fn [x y]
  (map #(Integer/parseInt (.toString %))
       (flatten (partition 1 (str (* x y))))))
