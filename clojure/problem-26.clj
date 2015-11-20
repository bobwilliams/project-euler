; A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:

; 1/2 =   0.5
; 1/3 =   0.(3)
; 1/4 =   0.25
; 1/5 =   0.2
; 1/6 =   0.1(6)
; 1/7 =   0.(142857)
; 1/8 =   0.125
; 1/9 =   0.(1)
; 1/10  =   0.1
; Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.

; Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.


; http://mathworld.wolfram.com/DecimalExpansion.html
; big help ^

; http://rosettacode.org/wiki/Modular_exponentiation#Clojure
(defn powerMod "modular exponentiation" [b e m]
  (defn m* [p q] (mod (* p q) m))
  (loop [b b 
         e e
         x 1]
    (if (zero? e) x
      (if (even? e) (recur (m* b b) (/ e 2) x)
        (recur (m* b b) (quot e 2) (m* b x))))))

(defn order [n]
  (first 
    (filter #(= 1 (powerMod 10 % n))
      (iterate inc 1))))

(defn period [n]
  (cond (= 1 n) 0
    (zero? (rem n 2)) (period (/ n 2))
    (zero? (rem n 5)) (period (/ n 5))
    :else (order n)))

(let [nums (range 1 1001)
      periods (map period nums)]
  ((zipmap periods nums) (apply max periods)))
