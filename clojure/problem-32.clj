; We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; 
; for example, the 5-digit number, 15234, is 1 through 5 pandigital.

; The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.

; Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.

; HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.


(def pandigital-string "123456789")

(defn pandigital? [n]
  (= pandigital-string (reduce str (sort (seq n)))))

(reduce + 
  (distinct 
    (for [a (range 2 5000)
          b   (range a (/ 9999 a))
          :let [p (* a b)]
          :when (pandigital? (str a b p))]
          p)))