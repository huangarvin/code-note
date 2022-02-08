package main

import (
	"fmt"
	"testing"
)

func Test_char(t *testing.T) {
	var c = "tree"
	for i := range c {
		if i > 0 && c[i-1] == c[i] {

		}
	}
}

func Test_sort(t *testing.T) {
	var nums = []int{2, 0, 2, 1, 1, 0}
	j := len(nums) - 1
	i := 0
	h := i
	for i < len(nums)-1 {
		if h >= j {
			break
		}
		if nums[j] == 2 {
			j--
			continue
		}
		if nums[i] == 0 {
			i++
			h = i
			continue
		}
		if nums[i] == 2 {
			nums[i] = nums[j]
			nums[j] = 2
			continue
		}
		h++
		nums[h], nums[i] = nums[i], nums[h]
	}

	fmt.Println(nums)
}

func Test_generateSquares(t *testing.T) {
	var n = 1000
	squares := make([]int, 0)
	square := 1
	var diff = 3
	for square <= n {
		squares = append(squares, square)
		square += diff
		diff += 2
	}
	fmt.Println(squares)
}
