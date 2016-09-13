; Topics:	sorting

; Write a function that splits a sentence up into a sorted list of words. Capitalization should not affect sort order and punctuation should be ignored.

; (= (__  "Have a nice day.")
  ;  ["a" "day" "Have" "nice"])

; (= (__  "Clojure is a fun language!")
  ;  ["a" "Clojure" "fun" "is" "language"])

; (= (__  "Fools fall for foolish follies.")
  ;  ["fall" "follies" "foolish" "Fools" "for"])

(fn [str]
  (->> str
       (re-seq #"\w+")
       (sort-by clojure.string/lower-case)))

(fn [x]
  (sort-by
   #(.toLowerCase %)
   (.split (.replaceAll x "[^a-zA-Z ]" "") " ")))
