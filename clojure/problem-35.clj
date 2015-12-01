; The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.

; There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.

; How many circular primes are there below one million?


; original ... very poorly performing but keeping it around

(defn prime? [n]
  (cond
    (< n 2) false
    (< n 4) true
    :else (not= 0 (reduce *' (map #(mod n %) (range 2 (+ 1 (Math/sqrt n))))))))

(defn all-circular-primes? [coll]
  (= (count coll) (count (filter prime? coll) )))

(defn num-to-list [i]
  (map {\0 0 \1 1 \2 2 \3 3 \4 4 \5 5 \6 6 \7 7 \8 8 \9 9} (str i))) 

(defn list-to-num [coll]
  (biginteger (reduce str coll)))

(let [upper-bound 1000000]
  (count
    (distinct
      (flatten
        (filter all-circular-primes? 
          (for [nums (filter prime? (range upper-bound))]
            (let [length (count (str nums))
                  digits (cycle (num-to-list nums))]
              (for [i (range length)]
                (list-to-num (take length (drop i digits)))))))))))





; after some more research and refactoring for performance

(defn square [n]
  (* n n))

(defn primes [end]
  "Uses a sieve to generate primes; not the set is not sorted"
  (let [sieve (transient (set (cons 2 (range 3 end 2))))]
    (loop [s sieve
           f 3]
      (cond (> (square f) end) (persistent! s)
            :else (recur (reduce disj! s (range (square f) end f)) (inc f))))))

(defn cycle-str [s]
  (apply str (concat (rest s) [(first s)])))

(defn circular-prime? [n]
  (every? prime?
          (map #(Integer/parseInt %)
               (take (count (str n)) (iterate cycle-str (str n))))))

(let [upper-bound 1000000]
  (count (filter circular-prime? (primes upper-bound))))
