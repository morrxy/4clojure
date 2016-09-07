; Topics:	seqs core-functions
; Write a function which returns a map containing the number of occurences of each distinct item in a sequence.

; (= (__ [1 1 2 3 2 1 1]) {1 4, 2 2, 3 1})
; (= (__ [:b :a :b :a :b]) {:a 2, :b 3})
; (= (__ '([1 2] [1 3] [1 3])) {[1 2] 1, [1 3] 2})

(fn [s]
  (reduce (fn [acc x]
            (if (nil? (acc x))
              (assoc acc x 1)
              (update acc x inc)))
          {} s))


#(reduce (fn [acc x]
           (if-let [v (acc x)]
             (assoc acc x (inc v))
             (assoc acc x 1)))
         {} %)
