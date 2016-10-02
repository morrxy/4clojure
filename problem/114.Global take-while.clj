; Topics:	seqs higher-order-functions

; take-while is great for filtering sequences, but it limited: you can only examine a single item of the sequence at a time. What if you need to keep track of some state as you go over the sequence?

; Write a function which accepts an integer n, a predicate p, and a sequence. It should return a lazy sequence of items in the list up to, but not including, the nth item that satisfies the predicate.

(= [2 3 5 7 11 13]
   (__ 4 #(= 2 (mod % 3))
         [2 3 5 7 11 13 17 19 23]))

(= ["this" "is" "a" "sentence"]
   (__ 3 #(some #{\i} %)
         ["this" "is" "a" "sentence" "i" "wrote"]))

(= ["this" "is"]
   (__ 1 #{"a"}
         ["this" "is" "a" "sentence" "i" "wrote"]))

; my solution

(fn f [n p [h & t]]
  (cond
    (zero? n) ()
    (nil? h) ()
    (not (p h)) (cons h (f n p t))
    (> n 1) (cons h (f (dec n) p t))
    true ()))

; other solution

(fn twn [n p s]
  (let [[x y] (split-with (complement p) s)]
    (lazy-cat x (when (> n 1) (cons (first y) (twn (dec n) p (rest y)))))))

(fn _ [n p [s & s2]]
    (let [n2 (if (p s) (dec n) n)]
      (if (zero? n2) '() (lazy-seq (cons s (_ n2 p s2))))))
