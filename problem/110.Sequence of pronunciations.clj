; Topics:	seqs

; Write a function that returns a lazy sequence of "pronunciations" of a sequence of numbers. A pronunciation of each element in the sequence consists of the number of repeating identical numbers and the number itself. For example, [1 1] is pronounced as [2 1] ("two ones"), which in turn is pronounced as [1 2 1 1] ("one two, one one").

; Your function should accept an initial sequence of numbers, and return an infinite lazy sequence of pronunciations, each element being a pronunciation of the previous element.

(= [[1 1] [2 1] [1 2 1 1]] (take 3 (__ [1])))

(= [3 1 2 4] (first (__ [1 1 1 4 4])))

(= [1 1 1 3 2 1 3 2 1 1] (nth (__ [1]) 6))

(= 338 (count (nth (__ [3 2]) 15)))

; my solution

(fn [xs]
  (letfn [(pronunciation [xs]
                         (->> xs
                              (partition-by identity)
                              (mapcat #(-> [(count %) (first %)]))))]
    (rest (iterate pronunciation xs))))

(fn [xs]
  (letfn [(pronunciation [xs]
                         (->> xs
                              (partition-by identity)
                              (mapcat (juxt count first))))]
    (rest (iterate pronunciation xs))))

(fn p [xs]
  (lazy-seq
    (let [r (mapcat #(list (count %) (first %)) (partition-by identity xs))]
      (cons r (p r)))))
