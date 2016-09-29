; Topics:	seqs combinatorics

; Given a sequence S consisting of n elements generate all k-combinations of S, i. e. generate all possible sets consisting of k distinct elements taken from S. The number of k-combinations for a sequence is equal to the binomial coefficient.

(= (__ 1 #{4 5 6}) #{#{4} #{5} #{6}})

(= (__ 10 #{4 5 6}) #{})

(= (__ 2 #{0 1 2}) #{#{0 1} #{0 2} #{1 2}})

(= (__ 3 #{0 1 2 3 4}) #{#{0 1 2} #{0 1 3} #{0 1 4} #{0 2 3} #{0 2 4}
                         #{0 3 4} #{1 2 3} #{1 2 4} #{1 3 4} #{2 3 4}})

(= (__ 4 #{[1 2 3] :a "abc" "efg"}) #{#{[1 2 3] :a "abc" "efg"}})

(= (__ 2 #{[1 2 3] :a "abc" "efg"}) #{#{[1 2 3] :a} #{[1 2 3] "abc"} #{[1 2 3] "efg"}
                                    #{:a "abc"} #{:a "efg"} #{"abc" "efg"}})

; my solution

(fn [n s]
  (let [all (fn c1 [n s]
              (cond
                (zero? n) #{}
                (= 1 n) (reduce #(conj %1 #{%2}) #{} s)
                :else (reduce (fn [acc x] (into acc (map #(into x %) (c1 1 s))))
                              #{}
                              (c1 (dec n) s))))]
    (set (filter #(= n (count %)) (all n s)))))

; other solution

;an iterative solution
#(cond
   (> %1 (count %2)) #{}
   (= %1 (count %2)) #{%2} 
   :else (loop [result #{#{}} round 0]
           (if (= round %1) result
             (recur (apply conj #{}
                      (for [x result y %2 :when (not (contains? x y))]
                        (conj x y)))
               (inc round)))))

;a recursive solution
(fn kCombination[k S]
  (cond
    (= k 0) #{}
    (= k 1) (apply conj #{} (for [item S] #{item}))
    (= k (count S)) #{S}
    (> k (count S)) #{}
    :else (apply conj #{}
            (for [x (kCombination (dec k) S) y S :when (not (contains? x y))]
              (conj x y)))))
