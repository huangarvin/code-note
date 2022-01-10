package cgo

import "fmt"

func funcComplier(s string) string {
	fmt.Println(s)
	return s
}
