; Write a function which returns a personalized greeting.

; (= (__ "Dave") "Hello, Dave!")
; (= (__ "Jenn") "Hello, Jenn!")

(= (#(str "Hello, " % "!") "Jenn") "Hello, Jenn!")
