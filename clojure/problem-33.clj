; The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.

; We shall consider fractions like, 30/50 = 3/5, to be trivial examples.

; There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two digits in the numerator and denominator.

; If the product of these four fractions is given in its lowest common terms, find the value of the denominator.

; I just couldn't understand what this problem was asking; so I found bibi’s nice solution from clojure-euler (http://clojure-euler.wikispaces.com/Problem+033):

(defn non-trivial?[n d]
  (let [x (quot n 10)
        y (rem n 10)
        u (quot d 10)
        v (rem d 10)]
    (cond
     (zero? v) false
     (and (= y u) (= (/ x v) (/ n d))) true
     :else false)))
 
(defn euler-33-bibi []
  (let [fracs (for [n (range 10 99)
                    d (range (inc n) 100)
                    :when (non-trivial? n d)]
                (/ n d))]
    (.denominator (reduce * fracs))))