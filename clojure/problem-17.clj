; If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

; If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?


; NOTE: Do not count spaces or hyphens. 
; For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters.
; The use of "and" when writing out numbers is in compliance with British usage.

; I could have made this a bit more performant by not putting a SPACE or HYPHEN in the words but choose to do so as a more generic number to wording function.

;; define our words

(def one-to-teens ["" "one" "two" "three" "four" "five" "six" "seven" "eight" "nine" "ten" "eleven" "twelve" "thirteen" "fourteen" "fifteen" "sixteen" "seventeen" "eighteen" "nineteen"])
(def tens ["twenty" "thirty" "fourty" "fifty" "sixty" "seventy" "eighty" "ninety"])
(def hundred "hundred")
(def thousand "thousand")
(def and "and")


(defn num-to-thousandths [num]
  ; given a number, returns its thousandth in written form
  (if (>= num 1000)
    (str (nth one-to-teens (quot num 1000)) " " thousand)))

(defn num-to-hundredths [num]
  ; given a number, returns its hundredth in written form
  (if (>= num 100)
    (str (nth one-to-teens (quot num 100)) " " hundred)))

(defn num-to-ones-tens [num]
  ; given a number, returns its <= 99 written form
  (if (< num 20)
    (nth one-to-teens num)
    (if (zero? (mod num 10))
      (nth tens (- (/ num 10) 2))
      (if (< num 100)
        (str (nth tens (- (quot num 10) 2)) "-" (nth one-to-teens (mod num 10)))))))


(num-to-thousandth 1000)
(num-to-hundredth 120)
(num-to-tenth 30)




;; go from highest down to lowest



(def first20 ["one" "two" "three" "four" "five"
              "six" "seven" "eight" "nine" "ten"
              "eleven" "twelve" "thirteen" "fourteen" "fifteen"
              "sixteen" "seventeen" "eighteen" "nineteen"])
(def decas ["" "ten" "twenty" "thirty" "forty" "fifty" "sixty" "seventy" "eighty" "ninety"])
(def h "hundred")
(def t "thousand")
(def a "and")

(defn word-length [n]
  (cond (= n 1000) (+ (count t) (count (nth first20 1)))
        (< n 100)
        (let [q (quot n 10) m (mod n 10)
              d (count (nth decas q))]
          (if (zero? m) d
              (if (< q 2) (count (nth first20 (dec (+ m (* 10 q)))))
                  (+ d (count (nth first20 (dec m)))))))
        (< n 1000)
        (let [q (quot n 100) m (mod n 100)]
          (if (zero? m) (+ (word-length q) (count h))
              (+ (count a) (count h) (word-length q) (word-length m))))))

(reduce + (map word-length (range 1 1001)))
