; Topics:	seqs

; Write a function which flattens any nested combination of sequential things (lists, vectors, etc.), but maintains the lowest level sequential items. The result should be a sequence of sequences with only one level of nesting.

(= (__ [["Do"] ["Nothing"]])
   [["Do"] ["Nothing"]])

(= (__ [[[[:a :b]]] [[:c :d]] [:e :f]])
   [[:a :b] [:c :d] [:e :f]])

(= (__ '((1 2)((3 4)((((5 6)))))))
   '((1 2)(3 4)(5 6)))

; my solution

(fn f2 [s]
  (mapcat (fn [x]
            (cond
              (not (sequential? x)) [x]
              (and (sequential? x) (not (sequential? (first x)))) [x]
              :else (f2 x)))
          s))

; other solution

(fn [s]
  (filter #(and (sequential? %) (not (sequential? (first %))))
          (tree-seq sequential? seq s)))

(de f [xs]
  (if (every? sequential? xs) (mapcat f xs) [xs]))

(fn [s]
  (if (every? sequential? xs)
    (mapcat f xs)
    [xs]))

(fn [x]
  (let [b #(every? sequential? %)]
    (filter (complement b)
    (tree-seq b seq x))))

(defn f [z]
  (let [l (apply concat (map #(if (every? coll? %) % [%]) z))]
    (if (= z l)
      z
      (recur l))))
