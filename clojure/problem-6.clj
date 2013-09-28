; The sum of the squares of the first ten natural numbers is,
; 1^2 + 2^2 + ... + 102 = 385

; The square of the sum of the first ten natural numbers is,
; (1 + 2 + ... + 10)^2 = 55^2 = 3025

; Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.

; Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.

(defn square [n]
  (* n n))

(defn sum-of-squares [n]
  (reduce + (map #(square %) (range 1 (+ n 1)))))

(defn square-of-sums [n]
  (square (reduce + (range 1 (+ n 1)))))

(let [x 100]
  (- (square-of-sums x) (sum-of-squares x)))