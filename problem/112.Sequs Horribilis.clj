; Topics:	seqs

; Create a function which takes an integer and a nested collection of integers as arguments. Analyze the elements of the input collection and return a sequence which maintains the nested structure, and which includes all elements starting from the head whose sum is less than or equal to the input integer.

(=  (__ 10 [1 2 [3 [4 5] 6] 7])
   '(1 2 (3 (4))))

(=  (__ 30 [1 2 [3 [4 [5 [6 [7 8]] 9]] 10] 11])
   '(1 2 (3 (4 (5 (6 (7)))))))

(=  (__ 9 (range))
   '(0 1 2 3))

(=  (__ 1 [[[[[1]]]]])
   '(((((1))))))

(=  (__ 0 [1 2 [3 [4 5] 6] 7])
   '())

(=  (__ 0 [0 0 [0 [0]]])
   '(0 0 (0 (0))))

(=  (__ 1 [-10 [1 [2 3 [4 5 [6 7 [8]]]]]])
   '(-10 (1 (2 3 (4)))))

; my solution

(fn f [n xs]
  (loop [result [] sum 0 x (first xs) xs (rest xs)]
    (cond
      (nil? x) result
      (sequential? x) (conj result (f (- n sum) x))
      (> (+ sum x) n) result
      true (recur (conj result x) (+ sum x) (first xs) (rest xs)))))

; other solution

(fn f [n [h & t]]
  (cond
    (nil? h) []
    (sequential? h) [(f n h)]
    (> h n) []
    true (concat [h] (f (- n h) t))))

(fn horrible [x node]
  (if-let [h (first node)]
    (cond
      (coll? h) (if-let [t (horrible x h)] (list t))
      (<= h x) (cons h (horrible (- x h) (rest node)))
      :else '())))



(fn f [n [h & t]]
  (cond
    (nil? h) ()
    (sequential? h) (list (f n h))
    (> h n) ()
    true (cons h (f (- n h) t))))
