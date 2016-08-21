; Write a function which returns the last element in a sequence.

; (= (__ [1 2 3 4 5]) 5)

(= (#(loop [[f & r] %]
   (if (= 0 (count r))
     f
     (recur r))) [1 2 3 4 5]) 5)

(= ((fn [c]
      (if (next c)
        (recur (next c))
        (first c))) [1 2 3 4 5]) 5)
