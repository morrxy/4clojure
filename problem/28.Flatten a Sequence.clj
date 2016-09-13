; Topics:	seqs core-functions
; Write a function which flattens a sequence.

; (= (__ '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6))
; (= (__ ["a" ["b"] "c"]) '("a" "b" "c"))
; (= (__ '((((:a))))) '(:a))


(fn flt [s]
  (cond
    (nil? s) '()
    (sequential? (first s)) (concat (flt (first s)) (flt (next s)))
    :else (cons (first s) (flt (next s)))))

(fn flt [s]
  (cond
    (nil? s) '()
    (coll? (first s)) (concat (flt (first s)) (flt (next s)))
    :else (cons (first s) (flt (next s)))))


(fn flatten* [x]
  (if (coll? x)
    (mapcat flatten* x)
    [x]))


(fn [s]
  (filter (complement sequential?)
    (tree-seq sequential? seq s)))


(defn flt [s]
  (if (empty? s)
    '()
    (let [[x & xs] s]
      (if (coll? x)
        (concat (flt x) (flt xs))
        (cons x (flt xs))))))
