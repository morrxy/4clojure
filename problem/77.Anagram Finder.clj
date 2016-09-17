; Write a function which finds all the anagrams in a vector of words. A word x is an anagram of word y if all the letters in x can be rearranged in a different order to form y. Your function should return a set of sets, where each sub-set is a group of words which are anagrams of each other. Each sub-set should have at least two words. Words without any anagrams should not be included in the result.

(= (__ ["meat" "mat" "team" "mate" "eat"])
   #{#{"meat" "team" "mate"}})

(= (__ ["veer" "lake" "item" "kale" "mite" "ever"])
   #{#{"veer" "ever"} #{"lake" "kale"} #{"mite" "item"}})


(fn [s]
  (->> s
       (group-by #(sort (seq %)))
       vals
       (filter #(> (count %) 1))
       (map set)
       set))


(fn [s]
  (->> s
       (group-by sort)
       vals
       (filter #(> (count %) 1))
       (map set)
       set))


(fn [s]
  (let [xf (comp (filter #(> (count %) 1)) (map set))]
    (->> s
         (group-by #(sort (seq %)))
         vals
         (into #{} xf))))


(fn [w]
  (->> w
       (group-by sort)
       vals
       (filter #(> (count %) 1))
       (map #(apply hash-set %))
       (apply hash-set)))


(fn [words]
  (set
   (filter #(< 1 (count %))
           (map (fn [word]
                  (set
                   (filter #(= (group-by identity word) (group-by identity %))
                           words)))
                words))))
