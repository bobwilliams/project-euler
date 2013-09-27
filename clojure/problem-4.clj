; A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
; Find the largest palindrome made from the product of two 3-digit numbers.

(defn palindrome-number? [num]
  (let [numstr (str num)
        mid    (/ (count numstr) 2)
        str1   (subs numstr 0 mid)
        str2   (clojure.string/reverse (subs numstr mid))]
    (= str1 str2)))

(let [start 100
      end 999]
  (for [x (range start end)
        :let [y (* x x)]
        :when (palindrome-number? y)]
    y))