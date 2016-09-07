; Topics:	seqs core-functions

; Write a function which returns a sequence of lists of x items each. Lists of less than x items should not be returned.

; (= (__ 3 (range 9)) '((0 1 2) (3 4 5) (6 7 8)))
; (= (__ 2 (range 8)) '((0 1) (2 3) (4 5) (6 7)))
; (= (__ 3 (range 8)) '((0 1 2) (3 4 5)))

(fn [n s]
  (loop [s s acc '()]
    (if (< (count s) n)
      acc
      (recur (drop n s) (concat acc (list (take n s)))))))
