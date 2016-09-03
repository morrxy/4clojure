; Topics:	seqs
; Write a function which drops every Nth item from a sequence.

; (= (__ [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])
; (= (__ [:a :b :c :d :e :f] 2) [:a :c :e])
; (= (__ [1 2 3 4 5 6] 4) [1 2 3 5 6])

#(->> %1
      (partition-all %2)
      (map (fn [x] (take (dec %2) x)))
      (flatten))

#(apply concat (partition-all (dec %2) %2 %1))
