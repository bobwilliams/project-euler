// A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

// a2 + b2 = c2
// For example, 32 + 42 = 9 + 16 = 25 = 52.

// There exists exactly one Pythagorean triplet for which a + b + c = 1000.
// Find the product abc.

package main

import "fmt"

func is_pythagorean_triplet(a, b, c int) bool {
  if a < b && b < c && ((a * a) + (b * b)) == (c * c) {
    return true
  } else {
    return false
  }
}

func main() {
  limit := 1000

  for a := 1; a <= limit; a++ {
    for b := 1; b <= limit - a ; b++ {
      for c := 1; c <= limit - b; c++ {
        if is_pythagorean_triplet(a, b, c) && (a + b + c) == limit {
          fmt.Println(a * b * c)
        }
      }
    }
  }
}