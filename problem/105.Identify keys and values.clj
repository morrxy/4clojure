; Topics:	maps seqs

; Given an input sequence of keywords and numbers, create a map such that each key in the map is a keyword, and the value is a sequence of all the numbers (if any) between it and the next keyword in the sequence.

(= {} (__ []))

(= {:a [1]} (__ [:a 1]))

(= {:a [1], :b [2]} (__ [:a 1, :b 2]))

(= {:a [1 2 3], :b [], :c [4]} (__ [:a 1 2 3 :b :c 4]))

; my solution

(fn [s]
  (if (empty? s)
    {}
    (loop [k (first s) m {k []}  r (rest s)]
      (let [f (first r)]
        (cond
          (empty? r) m
          (keyword? f) (recur f (assoc m f []) (rest r))
          :else (recur k (assoc m k (conj (k m) f)) (rest r)))))))

; other solution

#(loop[result {}, k (first %), v [], remaining (rest %)]
   (if-let [newVal (first remaining)]
     (if
       (keyword? newVal) (recur (assoc result k v) newVal [] (rest remaining))
       (recur result k (conj v newVal) (rest remaining)))
     (if (nil? k) result
       (assoc result k v))))

(fn [xs]
  (let [r (partition-by keyword? xs)]
    (merge
      (zipmap
        (map last (take-nth 2 r))
        (take-nth 2 (rest r)))
      (zipmap
        (flatten (map drop-last (take-nth 2 r)))
        (repeat [])))))

(fn mf [s]
  (if (seq s)
    (merge {(first s) (take-while (complement keyword?) (rest s))}
           (mf (drop-while (complement keyword?) (rest s))))
    {}))
