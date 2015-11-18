A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. 
If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. 

The lexicographic permutations of 0, 1 and 2 are:

012   021   102   120   201   210

What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?


; http://rosettacode.org/wiki/Permutations#Clojure

(defn- iter-perm [v]
  (let [len (count v)
  j (loop [i (- len 2)]
       (cond (= i -1) nil
       (< (v i) (v (inc i))) i
       :else (recur (dec i))))]
    (when j
      (let [vj (v j)
      l (loop [i (dec len)]
    (if (< vj (v i)) i (recur (dec i))))]
  (loop [v (assoc v j (v l) l vj), k (inc j), l (dec len)]
    (if (< k l)
      (recur (assoc v k (v l) l (v k)) (inc k) (dec l))
      v))))))
 
(defn- vec-lex-permutations [v]
  (when v (cons v (lazy-seq (vec-lex-permutations (iter-perm v))))))
 
(defn lex-permutations
  "Fast lexicographic permutation generator for a sequence of numbers"
  [c]
  (lazy-seq
   (let [vec-sorted (vec (sort c))]
     (if (zero? (count vec-sorted))
       (list [])
       (vec-lex-permutations vec-sorted)))))
 
(defn permutations
  "All the permutations of items, lexicographic by index"
  [items]
  (let [v (vec items)]
    (map #(map v %) (lex-permutations (range (count v))))))
 
(first (drop 999999 (permutations (range 10)))) 