; Topics:	set-theory

; Write a function which calculates the Cartesian product of two sets.

(= (__ #{"ace" "king" "queen"} #{"♠" "♥" "♦" "♣"})
   #{["ace"   "♠"] ["ace"   "♥"] ["ace"   "♦"] ["ace"   "♣"]
     ["king"  "♠"] ["king"  "♥"] ["king"  "♦"] ["king"  "♣"]
     ["queen" "♠"] ["queen" "♥"] ["queen" "♦"] ["queen" "♣"]})

(= (__ #{1 2 3} #{4 5})
   #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]})

(= 300 (count (__ (into #{} (range 10))
                  (into #{} (range 30)))))

; solution

(fn [s1 s2]
  (set (for [x s1 y s2] [x y])))

(fn [s1 s2]
  (set (mapcat #(map (fn [x] (vector % x)) s2) s1)))
