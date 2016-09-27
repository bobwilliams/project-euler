// 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

// What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

package main

import "fmt"

func gcd(a, b int) int {
  if b == 0 {
    return a
  } else {
    return gcd(b, a % b)
  }
}

func main() {
  lcm := 1

  for i := 2; i <= 20; i++ {
      lcm *= i / gcd(i, lcm)
  }

  fmt.Println(lcm)
}