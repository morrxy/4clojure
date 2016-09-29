; Topics:	trees

; Let us define a binary tree as "symmetric" if the left half of the tree is the mirror image of the right half of the tree. Write a predicate to determine whether or not a given binary tree is symmetric. (see To Tree, or not to Tree for a reminder on the tree representation we're using).

(= (__ '(:a (:b nil nil) (:b nil nil))) true)

(= (__ '(:a (:b nil nil) nil)) false)

(= (__ '(:a (:b nil nil) (:c nil nil))) false)

(= (__ [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
          [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil]])
   true)

(= (__ [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
          [2 [3 nil [4 [5 nil nil] [6 nil nil]]] nil]])
   false)

(= (__ [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
          [2 [3 nil [4 [6 nil nil] nil]] nil]])
   false)

; my solution

(fn [root]
  (= (filter #(not (sequential? %))
             (tree-seq sequential? seq (second root)))
     (filter #(not (sequential? %))
             (tree-seq sequential? #(cons (first %) (reverse (rest %))) (nth root 2 nil)))))


; other solution

(fn [t]
  (= (map first (tree-seq sequential? next t))
     (map first (tree-seq sequential? (comp reverse next) t))))

(fn [[_ L R]]
  (letfn
    [(flip [[v l r]]
           (list v
                 (if (coll? r) (flip r) r)
                 (if (coll? l) (flip l) l)))]
    (= L (flip R))))


#(let [t (fn t [[v l r]]
           [v (if r (t r)) (if l (t l))])
       [_ l r] %]
    (= l (t r)))
