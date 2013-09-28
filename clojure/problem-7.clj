; By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

; What is the 10001st prime number?

(def limit 10001)

(defn prime? [n]
  (cond
    (< n 2) false
    (< n 4) true
    :else (not= 0 (reduce *' (map #(mod n %) (range 2 (+ 1 (Math/sqrt n))))))))

(nth (filter prime? (range)) (dec limit))