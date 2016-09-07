; Topics:	seqs
; Given a vector of integers, find the longest consecutive sub-sequence of increasing numbers. If two sub-sequences have the same length, use the one that occurs first. An increasing sub-sequence must have a length of 2 or greater to qualify.

; (= (__ [1 0 1 2 3 0 4 5]) [0 1 2 3])
; (= (__ [5 6 1 3 2 7]) [5 6])
; (= (__ [2 3 3 4 5]) [3 4 5])
; (= (__ [7 6 5 4]) [])


(fn [s]
  (->> s
       (reduce (fn [acc x]
                 (let [prev (last (last acc))]
                   (if (or (nil? prev) (<= x prev))
                     (conj acc [x])
                     (conj (vec (drop-last acc)) (conj (last acc) x)))))
               [])
       (filter #(> (count %) 1))
       (group-by count)
       (into (sorted-map))
       (last)
       (last)
       (first)
       ((fn [x] (if (nil? x) [] x)))))

(fn [s]
  (->> s
       (reduce (fn [acc x]
                 (let [prev (peek (peek acc))]
                   (if (or (nil? prev) (<= x prev))
                     (conj acc [x])
                     (conj (pop acc) (conj (peek acc) x)))))
               [])
       (filter #(> (count %) 1))
       (group-by count)
       (into (sorted-map))
       (last)
       (last)
       (first)
       ((fn [x] (if (nil? x) [] x)))))

(fn longest-incr-subseq [xs]
  (->> (range (count xs) 1 -1)
       (mapcat #(partition % 1 xs))
       (filter #(->> (apply sorted-set %)
                     seq (= %)))
       first vec))

(fn [xs]
  (let [seqs (reduce (fn [{:keys [all want]} i]
                       (let [cur (peek all)
                             prev (pop all)]
                         {:all (if (= i want)
                                 (conj prev (conj cur i))
                                 (conj all [i]))
                          :want (inc i)}))
                     {:all [[]] :want nil}
                     xs)]
    (apply max-key count
      (remove #(= 1 (count %))
              (:all seqs)))))



(mapcat #(partition % 1 [2 3 3 4 5]) '(5 4 3 2))

(filter #(->> (apply sorted-set %) seq (= %)) (list (list 2 3 3 4 5) (list 2 3 3 4) (list 3 3 4 5) (list 2 3 3) (list 3 3 4) (list 3 4 5) (list 2 3) (list 3 3) (list 3 4) (list 4 5)))

(defn f2 [x] (->> (apply sorted-set x) seq (= x)))

(seq (apply sorted-set [2 6 5]))
