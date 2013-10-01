; The prime factors of 13195 are 5, 7, 13 and 29.
; What is the largest prime factor of the number 600851475143 ?

; http://www.wikihow.com/Check-if-a-Number-Is-Prime
; The Murderous Method
; ((n²)+17)/12 = x.5


; 1st attempt...horribly inefficient for large numbers

; (def limit 600851475143)
; (defn factor? [n d] 
;   (if (zero? d)
;     false
;     (zero? (mod n d))))
; (defn factors [n]
;   (filter #(factor? n %) (range 1 (+ n 1))))
; (defn prime? [n]
;   (= 2 (count (factors n))))

; (take-last 1 (filter #(prime? %) (range limit)))


; 2nd attempt...much better computationally and I admit I got a few ideas from others


(def limit 600851475143)

(defn factor? [n d] 
	(if (zero? d)
		false
		(zero? (mod n d))))

(defn lpf [n]
	(let [q (long (clojure.Math/sqrt n))]			    ; quadratic limit
    	(loop [n n
        	   d 2]
      		(cond
       			(> d q) n                           ; num itself must be prime
       			(= n d) n                           ; n must be prime
       			(factor? n d) (recur (/ n d) d)     ; factor d out of n
       			true          (recur n (inc d)))))) ; else try again with bigger d

(lpf limit)