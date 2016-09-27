// The prime factors of 13195 are 5, 7, 13 and 29.

// What is the largest prime factor of the number 600851475143 ?

package main

import (
  "fmt"
  "math"
)

func is_factor(n, d int64) bool {
  if(d == 0) {
    return false
  } else {
    return n % d == 0
  }
}

func main() {
  var limit int64 = 600851475143
  var q, n, d int64 = int64(math.Sqrt(float64(limit))), limit, 2

  for  ; n >= d ; {
    if (d > q) || (n == d) {
      fmt.Println(n)
      break
    } else if is_factor(n, d) {
      n = n / d
    } else {
      d++
    }
  }
}