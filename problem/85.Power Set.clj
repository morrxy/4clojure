; Topics:	set-theory

; Write a function which generates the power set of a given set. The power set of a set x is the set of all subsets of x, including the empty set and x itself.

(= (__ #{1 :a}) #{#{1 :a} #{:a} #{} #{1}})

(= (__ #{}) #{#{}})

(= (__ #{1 2 3})
   #{#{} #{1} #{2} #{3} #{1 2} #{1 3} #{2 3} #{1 2 3}})

(= (count (__ (into #{} (range 10)))) 1024)


; solution:

(fn [s]
  (loop [len 0 acc #{#{}}]
    (if (>= len (count s))
      acc
      (recur (inc len)
        (into acc (for [x acc y s :when (not (contains? x y))] (conj x y)))))))

(fn f [s]
  (if (empty? s)
    #{#{}}
    (set (concat (map #(conj % (first s)) (f (rest s)))
                 (f (rest s))))))

(fn [s]
  (loop [s s acc #{#{}}]
    (if (empty? s)
      acc
      (recur (rest s)
        (into acc (map #(conj % (first s)) acc))))))
