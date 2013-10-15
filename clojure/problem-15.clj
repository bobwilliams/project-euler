; Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, 
; there are exactly 6 routes to the bottom right corner.

; How many such routes are there through a 20×20 grid?

; I several approaches with factorials which had horrible performance, luckily I was finally clued into Pascal's Triangle 
; I cannot claim complete originaly for this one :)
; http://mishadoff.github.io/blog/clojure-euler-problem-015/

(def size 20)

(defn pascal-triangle [lst]
  (let [size (count lst)]
    (for [i (range (inc size))]
      (if (or (= 0 i) (= size i)) 1
        (+ (nth lst (dec i)) (nth lst i))))))

(let [n size 
      d (inc (* n 2))]
  (nth (last (take d (iterate pascal-triangle [1]))) n))
