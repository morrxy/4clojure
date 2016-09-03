; Topics:	seqs
; Write a function which reverses the interleave process into x number of subsequences.

; (= (__ [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6)))
; (= (__ (range 9) 3) '((0 3 6) (1 4 7) (2 5 8)))
; (= (__ (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9)))

#(reduce (fn [acc x] (conj acc (->> %1 (drop x) (partition 1 %2) (flatten))))
         [] (range %2))

#(apply map list (partition %2 %1))

#(->> %1
   (iterate rest)
   (take %2)
   (map (partial take-nth %2)))

(fn [s x]
  (reduce (partial map conj)
          (repeat x [])
          (partition x s)))

(fn [l n]
  (map #(map second (second %))
       (group-by first
                 (map-indexed (fn [i e] [(mod i n) e]) l))))
