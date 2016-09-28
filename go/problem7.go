// By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

// What is the 10001st prime number?

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
  limit := 10001

  for i, cnt := 2, 0; cnt <= limit; i++ {
    if is_prime(i) {
      cnt++
      if cnt == limit {
        fmt.Println(i)
      }
    }
  }
}