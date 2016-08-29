; Topics:	seqs core-functions
; Write a function which creates a list of all integers in a given range.

; (= (__ 1 4) '(1 2 3))
; (= (__ -2 2) '(-2 -1 0 1))
; (= (__ -2 2) '(-2 -1 0 1))

(fn [start end]
  (loop [start start acc []]
    (if (>= start end)
      acc
      (recur (inc start) (conj acc start)))))

(fn [start end]
  (take (- end start) (iterate inc start)))
