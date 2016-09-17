; Topics:	set-theory

; Write a function which generates the transitive closure of a binary relation. The relation will be represented as a set of 2 item vectors.

(let [divides #{[8 4] [9 3] [4 2] [27 9]}]
  (= (__ divides) #{[4 2] [8 4] [8 2] [9 3] [27 9] [27 3]}))

(let [more-legs
      #{["cat" "man"] ["man" "snake"] ["spider" "cat"]}]
  (= (__ more-legs)
     #{["cat" "man"] ["cat" "snake"] ["man" "snake"]
       ["spider" "cat"] ["spider" "man"] ["spider" "snake"]}))

(let [progeny
      #{["father" "son"] ["uncle" "cousin"] ["son" "grandson"]}]
  (= (__ progeny)
     #{["father" "son"] ["father" "grandson"]
       ["uncle" "cousin"] ["son" "grandson"]}))


(fn [s]
  (let [f (fn [x s]
            (loop [from (second x) acc #{x}]
              (let [node (first (filter #(= from (first %)) s))]
                (if node
                  (recur (second node) (conj acc [(first x) (second node)]))
                  acc))))]
    (reduce #(into %1 (f %2 s)) #{} s)))


#(loop [s %]
   (let [n (into s (for [[a b] s [c d] s :when (= b c)] [a d]))]
     (if (= n s) n (recur n))))


(fn [xs]
  (let [m (apply merge (map #(apply hash-map %) xs))
        r (set
           (concat xs
                   (filter #(last %)
                           (map #(list (first %) (m (last %)))
                                xs))))]
    (if (= xs r) r (recur r))))
