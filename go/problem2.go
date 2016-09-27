// Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:

// 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

// By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.

package main

import "fmt"

func main() {
    limit := 4000000
    sum := 0
    for x, y := 1, 2; y <= limit; x, y = y, x+y {
        if y%2 == 0 {
            sum += y
        }
    }
    fmt.Println(sum)
}