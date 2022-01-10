package main

import "fmt"

func main() {
	var maps = make(map[string]string, 8)
	var i = 1
	maps["111"] = "2"
	change(&maps, &i)
	fmt.Println(maps)
}

func change(maps *map[string]string, int2 *int) {
	var maps1 = make(map[string]string, 8)
	maps = &maps1
	s := 2
	int2 = &s
}
