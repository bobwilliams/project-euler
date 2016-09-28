// The sum of the squares of the first ten natural numbers is,
// 1^2 + 2^2 + ... + 102 = 385

// The square of the sum of the first ten natural numbers is,
// (1 + 2 + ... + 10)^2 = 55^2 = 3025

// Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.

// Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.

package main

import "fmt"

func sum_of_squares(num int) int {
  sum := 0

  for i := 1; i <= num; i++ {
    sum += i * i
  }

  return sum
}

func square_of_sums(num int) int {
  sum := 0

  for i := 1; i <= num; i++ {
    sum += i
  } 

  return sum * sum
}

func main() {
  limit := 100
  sumSquares := sum_of_squares(limit)
  squareSums := square_of_sums(limit)

  fmt.Println(squareSums - sumSquares)
}