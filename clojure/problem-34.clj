; 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.

; Find the sum of all numbers which are equal to the sum of the factorial of their digits.

; Note: as 1! = 1 and 2! = 2 are not sums they are not included.

(defn factorial [n] (reduce *' (range 1 (inc n))))

; gotta be an easier way to take a number and apply operations to it's digits
(defn fac-sum [n]
  (->> (str n)
       (seq)
       (map str)
       (map read-string)
       (map factorial)
       (reduce +)))

(->> 
  (for [a (range 10 1000000)
       :when (= (fac-sum a) a)]
       a)
  (reduce +))
