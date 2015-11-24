; Euler discovered the remarkable quadratic formula:

; n² + n + 41

; It turns out that the formula will produce 40 primes for the consecutive values n = 0 to 39. 
; However, when n = 40, 402 + 40 + 41 = 40(40 + 1) + 41 is divisible by 41, and certainly when n = 41, 41² + 41 + 41 is clearly divisible by 41.

; The incredible formula  n² − 79n + 1601 was discovered, which produces 80 primes for the consecutive values n = 0 to 79. The product of the coefficients, −79 and 1601, is −126479.

; Considering quadratics of the form:

; n² + an + b, where |a| < 1000 and |b| < 1000

; where |n| is the modulus/absolute value of n
; e.g. |11| = 11 and |−4| = 4
; Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum number of primes for consecutive values of n, starting with n = 0.


(defn quadratic [n a b]
  (+ (* n n) (* a n) b))

(defn prime? [n]
  (cond
    (< n 2) false
    (< n 4) true
    :else (not= 0 (reduce *' (map #(mod n %) (range 2 (+ 1 (Math/sqrt n))))))))

(defn find-max [coll]
  (reduce #(if (> (nth %1 2) (nth %2 2)) %1 %2) coll))

(let [values (for [a (range -1000 1000)
                   b (range -1000 1000)]
              [a b (count (take-while prime? (map #(quadratic % a b) (range))))])
     [a b _] (find-max values)]
  (* a b))
  