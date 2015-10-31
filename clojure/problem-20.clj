; n! means n × (n − 1) × ... × 3 × 2 × 1

; For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
; and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

; Find the sum of the digits in the number 100!

; took awhile to find/figure out the *' (note the tick mark) to avoid stack overflow
(defn factorial [n] (reduce *' (range 1 (inc n))))

; taken from my problem 16
(defn apply-fn-to-digits [x n]
  (apply x (map #(- (int %) 48) (seq (str n)))))

(apply-fn-to-digits + (factorial 100))