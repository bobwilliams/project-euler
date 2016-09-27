// A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

// Find the largest palindrome made from the product of two 3-digit numbers.

package main

import "fmt"

func is_palindrome(num int) bool {
  rev, tmp := 0, num
  for ; tmp > 0; {
    rev = (rev * 10) + (tmp % 10)
    tmp = tmp / 10
  }
  return num == rev
}

func main(){
  max, p := 0, 0

  for i := 1; i < 100; i++ {
    for j := 1; j < 100; j++ {
      p = i * j
      if is_palindrome(p) {
        max = p
      }
    }
  }

  fmt.Println(max)
}