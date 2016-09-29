; Topics:	numbers

; Given a pair of numbers, the start and end point, find a path between the two using only three possible operations:
; double
; halve (odd numbers cannot be halved)
; add 2

; Find the shortest path through the "maze". Because there are multiple shortest paths, you must return the length of the shortest path, not the path itself.

(= 1 (__ 1 1))  ; 1

(= 3 (__ 3 12)) ; 3 6 12

(= 3 (__ 3 12)) ; 3 6 12

(= 3 (__ 5 9))  ; 5 7 9

(= 9 (__ 9 2))  ; 9 18 20 10 12 6 8 4 2

(= 5 (__ 9 12)) ; 9 11 22 24 12

; my solution
