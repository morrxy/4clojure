; Topics:	math

; Happy numbers are positive integers that follow a particular formula: take each individual digit, square it, and then sum the squares to get a new number. Repeat with the new number and eventually, you might get to a number whose squared sum is 1. This is a happy number. An unhappy number (or sad number) is one that loops endlessly. Write a function that determines if a number is happy or not.

(= (__ 7) true)

(= (__ 986543210) true)

(= (__ 2) false)

(= (__ 3) false)

; solution:

(fn [n]
  (let [v (reduce + (map #(* % %) (for [x (str n)] (- (int x) 48))))]
    (cond
      (= 1 v) true
      (= 4 v) false
      :else (recur v))))


(fn [n]
  (loop [n n seen #{}]
    (let [v (reduce + (map #(* % %) (for [x (str n)] (- (int x) 48))))]
      (cond
        (= 1 v) true
        (seen v) false
        :else (recur v (conj seen v))))))
