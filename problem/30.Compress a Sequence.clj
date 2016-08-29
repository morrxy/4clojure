; Topics:	seqs
; Write a function which removes consecutive duplicates from a sequence.

; (= (apply str (__ "Leeeeeerrroyyy")) "Leroy")
; (= (apply str (__ "Leeeeeerrroyyy")) "Leroy")
; (= (__ [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))

#(first ((fn [s]
           (reduce
            (fn [acc x]
              (let [s1 (first acc)
                    p (second acc)]
                (if (= x p)
                  [s1 p]
                  [(conj s1 x) x])))
            [[(first s)] (first s)]
            s)) %))

#(map first (partition-by identity %))

#(loop [acc [] s %]
   (cond
     (nil? s) acc
     (= (first s) (last acc)) (recur acc (next s))
     :else (recur (conj acc (first s)) (next s))))

(fn [x] (->> (map list x (rest x))
     (remove #(= (first %1) (second %1)))
     (map second)
     (cons (first x))))
