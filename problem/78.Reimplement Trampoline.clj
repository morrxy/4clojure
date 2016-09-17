; Topics:	core-functions

; Reimplement the function described in "Intro to Trampoline".

(= (letfn [(triple [x] #(sub-two (* 3 x)))
          (sub-two [x] #(stop?(- x 2)))
          (stop? [x] (if (> x 50) x #(triple x)))]
    (__ triple 2))
  82)

(= (letfn [(my-even? [x] (if (zero? x) true #(my-odd? (dec x))))
          (my-odd? [x] (if (zero? x) false #(my-even? (dec x))))]
    (map (partial __ my-even?) (range 6)))
  [true false true false true false])


(fn [f & xs]
  (loop [v (apply f xs)]
    (if (fn? v) (recur (v)) v)))


(fn [f & xs]
  (let [v (apply f xs)]
    (if (fn? v) (recur v ()) v)))


(fn [& as]
  (let [r (apply (first as) (rest as))]
    (if (fn? r) (recur [r]) r)))
