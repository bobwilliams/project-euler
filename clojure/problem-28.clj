; Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:

; 21 22 23 24 25
; 20  7  8  9 10
; 19  6  1  2 11
; 18  5  4  3 12
; 17 16 15 14 13

; It can be verified that the sum of the numbers on the diagonals is 101.

; What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?


; so, had some fun figuring this one out.
; my solution was no where as elgant as the one below which came from the comments found in: http://clojure.roboloco.net/?p=289
; in fact, so impressed with the one I came across that I replaced mine.
; mad props to Jules

(defn euler-28 []
  (let [w 1001 
        r (map #(repeat 4 (+ % %)) (rest (range)))]
    (->> (flatten (cons 1 r))
         (reductions +)
         (take (dec (* 2 w)))
         (reduce +))))
