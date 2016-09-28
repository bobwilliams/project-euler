// The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

// Find the sum of all the primes below two million.

package main

import "fmt"

// https://en.wikipedia.org/wiki/Primality_test
func is_prime(num int) bool {
  if num <= 1 {
    return false
  } else if num <= 3 {
    return true
  } else if (num % 2 == 0) || (num % 3 == 0) {
    return false
  } else {
    for i := 5; i * i <= num; i += 6 {
      if (num % i == 0) || (num % (i + 2) == 0) {
        return false
      }
    }
    return true
  }
}

func main() {
  limit := 2000000
  sum := 0
 
  for i := 2; i <= limit; i++ {
    if is_prime(i) {
      sum += i
    }
  }
  fmt.Println(sum)
}