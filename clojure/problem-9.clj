; A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

; a^2 + b^2 = c^2
; For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.

; There exists exactly one Pythagorean triplet for which a + b + c = 1000.
; Find the product abc.

(def sum 1000)

(defn square [n]
  (* n n))

(defn pythagorean-triplet? [a b c]
  (true? (and (= (< a b) (< b c))
     (= (+ (square a) (square b)) (square c)))))

(first (for [a (range 1 sum) 
             b (range a (- sum a))
             :let [c (- sum a b)]
             :when (pythagorean-triplet? a b c)]
         (* a b c)))