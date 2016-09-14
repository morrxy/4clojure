; Topics:	game

; A tic-tac-toe board is represented by a two dimensional vector. X is represented by :x, O is represented by :o, and empty is represented by :e. A player wins by placing three Xs or three Os in a horizontal, vertical, or diagonal row. Write a function which analyzes a tic-tac-toe board and returns :x if X has won, :o if O has won, and nil if neither player has won.

(= nil (__ [[:e :e :e]
            [:e :e :e]
            [:e :e :e]]))

(= nil (__ [[:e :e :e]
            [:e :e :e]
            [:e :e :e]]))

(= :x (__ [[:x :e :o]
           [:x :e :e]
           [:x :e :o]]))

(= :o (__ [[:e :x :e]
           [:o :o :o]
           [:x :e :x]]))

(= :x (__ [[:x :e :e]
           [:o :x :e]
           [:o :e :x]]))

(= :o (__ [[:x :e :o]
           [:x :o :e]
           [:o :e :x]]))

(= nil (__ [[:x :o :x]
            [:x :o :x]
            [:o :x :o]]))

(fn [v]
  (let [all [(first v) (second v) (last v)
             [(first (first v)) (first (second v)) (first (last v))]
             [(second (first v)) (second (second v)) (second (last v))]
             [(last (first v)) (last (second v)) (last (last v))]
             [(first (first v)) (second (second v)) (last (last v))]
             [(last (first v)) (second (second v)) (first (last v))]]]
    (if (some #(= [:x :x :x] %) all)
      :x
      (if (some #(= [:o :o :o] %) all)
        :o
        nil))))


(fn [[[a b c]
      [d e f]
      [h i j] :as board]]
  (let [test-line (fn [line] (reduce #(when (= %1 %2) %1) line))
        lines (concat board (apply map vector board) [[a e j] [c e h]])
        scored-lines (map test-line lines)]
    (some #{:x :o} scored-lines)))


(let
  [check (fn [& sets]
           (first (filter #(not (nil? %))
                          (map
                           (fn [ss]
                             (let [r (first (filter #(or (= % #{:x}) (= % #{:o})) ss))]
                               (if r (first r) nil)))
                           sets))))]
  (fn ttt [board]
    (check
     (map set board)
     (map set (apply map list board))
     (list (set (map #(nth (nth board %) %) (range 3))))
     (list (set (map #(nth (nth board %) (- 2 %)) (range 3)))))))
