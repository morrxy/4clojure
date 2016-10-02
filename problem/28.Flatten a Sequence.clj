; Topics:	seqs core-functions
; Write a function which flattens a sequence.

(= (__ '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6))

(= (__ ["a" ["b"] "c"]) '("a" "b" "c"))

(= (__ '((((:a))))) '(:a))

; solution

(fn f [[h & t]]
  (cond
    (nil? h) ()
    (sequential? h) (concat (f h) (f t))
    true (cons h (f t))))

(fn f [xs]
  (mapcat #(if (sequential? %) (f %) [%]) xs))

(fn [s]
  (filter (complement sequential?)
    (tree-seq sequential? seq s)))


(fn flatten* [x]
  (if (coll? x)
    (mapcat flatten* x)
    [x]))
