; Topics:	set-theory

; Write a function which returns the symmetric difference of two sets. The symmetric difference is the set of items belonging to one but not both of the two sets.

(= (__ #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7})

(= (__ #{:a :b :c} #{}) #{:a :b :c})

(= (__ #{} #{4 5 6}) #{4 5 6})

(= (__ #{[1 2] [2 3]} #{[2 3] [3 4]}) #{[1 2] [3 4]})


; solution:

(fn [s1 s2]
  (into (clojure.set/difference s1 s2) (clojure.set/difference s2 s1)))

(fn [s1 s2]
  (into (apply disj s1 s2) (apply disj s2 s1)))

(fn [s1 s2]
  (clojure.set/union (apply disj s1 s2) (apply disj s2 s1)))

(fn [s1 s2]
  (clojure.set/union
   (clojure.set/select #(not (contains? s2 %)) s1)
   (clojure.set/select #(not (contains? s1 %)) s2)))
