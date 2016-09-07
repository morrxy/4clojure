; Topics:	seqs

; Write a function which takes a sequence consisting of items with different types and splits them up into a set of homogeneous sub-sequences. The internal order of each sub-sequence should be maintained, but the sub-sequences themselves can be returned in any order (this is why 'set' is used in the test cases).

; (= (set (__ [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]})
; (= (set (__ [:a "foo"  "bar" :b])) #{[:a :b] ["foo" "bar"]})
; (= (set (__ [[1 2] :a [3 4] 5 6 :b])) #{[[1 2] [3 4]] [:a :b] [5 6]})

(defn f1 [s]
  (->> s
       (reduce (fn [acc x] (update acc (type x) conj x)) {})
       (map #(nth % 1))
       (map reverse)))

(defn f1 [s]
  (->> s
       (reduce (fn [acc x] ) [])
       (map #(nth % 1))
       (map reverse)))

(fn [s]
  (->> s
       (reduce (fn [acc x] (update acc (type x) conj x)) {})
       (map #(nth % 1))
       (map reverse)))

#(->> %
      (reduce (fn [acc x] (update acc (type x) conj x)) {})
      (map (fn [x] (nth x 1)))
      (map reverse))

(= (set (f1 [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]})

(= (set (f1 [:a "foo"  "bar" :b])) #{[:a :b] ["foo" "bar"]})

(= (set (f1 [[1 2] :a [3 4] 5 6 :b])) #{[[1 2] [3 4]] [:a :b] [5 6]})
