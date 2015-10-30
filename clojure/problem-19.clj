; You are given the following information, but you may prefer to do some research for yourself.

; 1 Jan 1900 was a Monday.
; Thirty days has September, April, June and November.
; All the rest have thirty-one,
; Saving February alone,
; Which has twenty-eight, rain or shine.
; And on leap years, twenty-nine.
; A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.

; How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?

(def years (range 1901 2001))
(def months (range 1 13))

(defn day-of-the-week [month day year]
  "https://en.wikipedia.org/wiki/Determination_of_the_day_of_the_week#Gauss.27s_algorithm"
  (let [d day
        m (+ 1 (mod (- month 3) 12))
        Y (if (> m 10) (- year 1) year)
        y (mod Y 100)
        c (/ (- Y (mod Y 100)) 100) ]
        (int (mod (- (+ d (int (Math/floor (- (* 2.6 m) 0.2))) y (/ y 4) (/ c 4)) (* 2 c)) 7))))

(count 
  (flatten
    (for [year years]
      (filter #(= % 0) (map #(day-of-the-week 0 % year) months)))))
