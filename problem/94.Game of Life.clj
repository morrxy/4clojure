; Topics:	game

; The game of life is a cellular automaton devised by mathematician John Conway.

; The 'board' consists of both live (#) and dead ( ) cells. Each cell interacts with its eight neighbours (horizontal, vertical, diagonal), and its next state is dependent on the following rules:

; 1) Any live cell with fewer than two live neighbours dies, as if caused by under-population.
; 2) Any live cell with two or three live neighbours lives on to the next generation.
; 3) Any live cell with more than three live neighbours dies, as if by overcrowding.
; 4) Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

; Write a function that accepts a board, and returns a board representing the next generation of cells.

(= (__ ["      "
        " ##   "
        " ##   "
        "   ## "
        "   ## "
        "      "])
   ["      "
    " ##   "
    " #    "
    "    # "
    "   ## "
    "      "])

(= (__ ["     "
        "     "
        " ### "
        "     "
        "     "])
   ["     "
    "  #  "
    "  #  "
    "  #  "
    "     "])

(= (__ ["      "
        "      "
        "  ### "
        " ###  "
        "      "
        "      "])
   ["      "
    "   #  "
    " #  # "
    " #  # "
    "  #   "
    "      "])

"  ### "

; my solution

(fn [b]
  (letfn [(board-info [b]
                      (vec (flatten (map-indexed
                                     (fn [x line]
                                       (vec (map-indexed
                                             (fn [y v] (hash-map :val v :point [x y])) line)))
                                     b))))

          (neighbour-points [p]
                            (let [[x y] p]
                              (set [[(dec x) (dec y)] [(dec x) y] [(dec x) (inc y)]
                                    [x (dec y)] [x (inc y)]
                                    [(inc x) (dec y)] [(inc x) y] [(inc x) (inc y)]])))

          (neighbour-vals [point bd]
                          (let [point-list (neighbour-points point)]
                            (map :val (filter #(contains? point-list (:point %)) bd))))

          (new-val [v vals]
                   (let [n (count (filter #(= \# %) vals))]
                     (cond
                       (and (= \# v) (< n 2)) \space
                       (and (= \# v) (>= n 2) (<= n 3)) \#
                       (and (= \# v) (> n 3)) \space
                       (and (= \space v) (= n 3)) \#
                       :else \space)))]

    (let [bd (board-info b)]
      (->> bd
           (map (fn [x] (assoc x :nvals (neighbour-vals (:point x) bd))))
           (map (fn [x] (new-val (:val x) (:nvals x))))
           (partition (count (first b)))
           (mapv #(apply str %))))))


; other solution

(fn [board]
  (let [w (count (first board))
        h (count board)
        live? (fn [[x y]] (and (>= x 0) (< x w) (>= y 0) (< y h) (= \# (get-in board [y x]))))
        neighbors (fn [[x y]]
          (count (filter live? [[(dec x) y] [(inc x) y] [x (dec y)] [x (inc y)] [(inc x) (inc y)] [(dec x) (dec y)] [(inc x) (dec y)] [(dec x) (inc y)]])))
        should-live? (fn [xy]
          (cond
            (< (neighbors xy) 2) false
            (= 2 (neighbors xy)) (live? xy)
            (= 3 (neighbors xy)) true
            true false))]
    (map (fn [y]
      (apply str (map (fn [x]
        (if (should-live? [x y]) "#" " ")) (range w)))) (range h))))
