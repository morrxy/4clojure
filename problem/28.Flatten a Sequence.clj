; Topics:	seqs core-functions
; Write a function which flattens a sequence.

; (= (__ '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6))
; (= (__ ["a" ["b"] "c"]) '("a" "b" "c"))
; (= (__ '((((:a))))) '(:a))

; wrong
(defn flt [s]
  (let [acc [] s s]
    (cond
      (nil? s) acc
      (not (seq? (first s))) (conj acc (first s) (flt (next s)))
      :else (conj acc (flt (first s) (flt (next s)))))))
