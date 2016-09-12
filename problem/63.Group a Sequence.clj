; Topics:	core-functions
; Given a function f and a sequence s, write a function which returns a map. The keys should be the values of f applied to each item in s. The value at each key should be a vector of corresponding items in the order they appear in s.

; (= (__ #(> % 5) [1 3 6 8]) {false [1 3], true [6 8]})
; (= (__ #(apply / %) [[1 2] [2 4] [4 6] [3 6]])
  ;  {1/2 [[1 2] [2 4] [3 6]], 2/3 [[4 6]]})
; (= (__ count [[1] [1 2] [3] [1 2 3] [2 3]])
  ;  {1 [[1] [3]], 2 [[1 2] [2 3]], 3 [[1 2 3]]})

; Special Restrictions
; group-by

(fn [f s]
  (reduce
   (fn [acc x]
     (let [k (f x) v (acc k)]
       (if (nil? v)
         (assoc acc k [x])
         (assoc acc k (conj v x)))))
   {}
   s))

(fn [f s]
  (apply merge-with concat (map #(hash-map (f %1) [%1]) s)))
