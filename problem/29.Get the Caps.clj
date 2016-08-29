; Topics:	strings
; Write a function which takes a string and returns a new string containing only the capital letters.

; (= (__ "HeLlO, WoRlD!") "HLOWRD")
; (= (__ "HeLlO, WoRlD!") "HLOWRD")
; (empty? (__ "nothing"))


(fn [s] (apply str
          (filter
           (fn [c] (let [c (int c)
                         a (int \A)
                         z (int \Z)]
                     (and (>= c a) (<= c z))))
           (map identity s))))


(fn [s]
  (let [cap? (fn [c]
               (let [c (int c)
                     a (int \A)
                     z (int \Z)]
                 (and (>= c a) (<= c z))))]
    (reduce (fn [acc c]
              (if (cap? c) (str acc c) acc))
            "" s)))

(fn [s] (apply str (re-seq #"[A-Z]" s)))
