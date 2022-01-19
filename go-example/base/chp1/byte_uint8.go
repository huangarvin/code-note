package main

import (
	"fmt"
	"time"
)

func main() {
	var c1 chan interface{} = nil
	fmt.Println()
	go func() {
		fmt.Println("go channel")
		c1 <- new(interface{})
		fmt.Println("go channel end")
	}()
	time.Sleep(time.Second * 10)
}
