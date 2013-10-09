; The following iterative sequence is defined for the set of positive integers:

; n → n/2 (n is even)
; n → 3n + 1 (n is odd)

; Using the rule above and starting with 13, we generate the following sequence:

; 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
; It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. 
; Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

; Which starting number, under one million, produces the longest chain?

; NOTE: Once the chain starts the terms are allowed to go above one million.

(defn collatz [n]
  (cons n
        (lazy-seq
         (if (> n 1)
           (if (even? n)
                (collatz (/ n 2))
                (collatz (+ (* 3 n) 1)))))))

(defn greatest-count [a b]
  (let [a-count (count a)
        b-count (count b)]
    (if (> a-count b-count)
      a
      b)))

(let [limit 1000000]
  (first (reduce #(greatest-count %1 %2) (map #(collatz %) (range limit 1 -1)))))