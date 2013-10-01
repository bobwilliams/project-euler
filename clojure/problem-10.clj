; The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

; Find the sum of all the primes below two million.

(def limit 2000000)

(defn square [n]
  (* n n))

(defn primes [end]
	"Uses a sieve to generate primes; not the set is not sorted"
  (let [sieve (transient (set (cons 2 (range 3 end 2))))]
    (loop [s sieve
           f 3]
      (cond (> (square f) end) (persistent! s)
            :else (recur (reduce disj! s (range (square f) end f)) (inc f))))))

(reduce + (primes limit))