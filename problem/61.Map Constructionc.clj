; Topics:	core-functions
; Write a function which takes a vector of keys and a vector of values and constructs a map from them.

; (= (__ [:a :b :c] [1 2 3]) {:a 1, :b 2, :c 3})
; (= (__ [1 2 3 4] ["one" "two" "three"]) {1 "one", 2 "two", 3 "three"})
; (= (__ [:foo :bar] ["foo" "bar" "baz"]) {:foo "foo", :bar "bar"})

; Special Restrictions
; zipmap


(fn [ks vs]
  (reduce conj {} (mapv (fn [k v] (assoc {} k v)) ks vs)))

(fn [ks vs]
  (reduce conj {} (map (fn [k v] {k v}) ks vs)))

(fn [ks vs] (into {} (map (fn [x y] {x y}) ks vs)))

(fn [ks vs] (reduce merge (map (fn [x y] {x y}) ks vs)))
