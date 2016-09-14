; Given a string of comma separated integers, write a function which returns a new comma separated string that only contains the numbers which are perfect squares.

; (= (__ "4,5,6,7,8,9") "4,9")
; (= (__ "15,16,25,36,37") "16,25,36")

(fn [s]
  (->> s
       (#(clojure.string/split % #","))
       (map read-string)
       (filter #(let [root (Math/sqrt %)] (== root (int root))))
       (clojure.string/join ",")))


(fn [s]
  (->> s
       (#(clojure.string/split % #","))
       (map read-string)
       (filter #(zero? (rem (Math/sqrt %) 1)))
       (clojure.string/join ",")))


(fn [s]
  (->> s
       (#(read-string (str "[" % "]")))
       (filter #(zero? (rem (Math/sqrt %) 1)))
       (clojure.string/join ",")))


(fn [s] (clojure.string/join ","
  (filter #(= 0.0 (mod (Math/sqrt %) 1))
    (read-string (str "[" s "]")))))
