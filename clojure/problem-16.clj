; 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

; What is the sum of the digits of the number 2^1000?


(defn apply-fn-to-digits [x n]
  (apply x (map #(- (int %) 48) (seq (str n)))))

(defn powers-of-2 []
  (iterate (partial *' 2) 1))

(let [limit 1000]
  (apply-fn-to-digits + (last (take (+ 1 limit)(powers-of-2)))))