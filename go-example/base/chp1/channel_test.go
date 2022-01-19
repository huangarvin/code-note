package main_test

import (
	"fmt"
	"reflect"
	"testing"
)

func Test_channel(t *testing.T) {
	c1 := make(chan interface{}, 10)

	c1 <- nil
	c1 <- new(interface{})
	fmt.Println(<-c1)
	i := <-c1
	of := reflect.TypeOf(i)
	fmt.Println(of.Size()) // size 8
	fmt.Println()

	c2 := make(chan struct{}, 10)
	c2 <- struct{}{}
	of2 := reflect.TypeOf(<-c2)
	fmt.Println(of2.Size()) // size 0
	//c2 <- nil  error
}

func Test_channel2(t *testing.T) {
	c1 := make(chan struct{}, 10)
	c1 <- struct{}{}
	fmt.Println(<-c1)
	close(c1)
	i, ok := <-c1
	fmt.Println(ok, i)
	<-c1
	<-c1
}
