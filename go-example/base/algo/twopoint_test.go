package main

import (
	"fmt"
	"testing"
)

func Test(t *testing.T) {
	var target = 11
	var arr = [...]int{1, 3, 6, 8, 9}
	var end = len(arr) - 1
	var start = 0
	for start < end {
		if arr[start]+arr[end] > target {
			end--
		}
		if arr[start]+arr[end] < target {
			start++
		}
		if arr[start]+arr[end] == target {
			break
		}
	}
	fmt.Println(start, end)
}

func Test_zczc(t *testing.T) {
	var s = "adfalngllngajlj"
	var target = "lngj"
	i := 0
	j := 0
	for i < len(s) && j < len(target) {
		if s[i] == target[j] {
			j++
		}
		i++
	}
	fmt.Println(j == len(target))
}

func Test_min(t *testing.T) {
	var arr = []int{2, 5, 1, 3}
	var min = arr[0]
	var max = 0
	for _, v := range arr {
		if min > v {
			min = v
		} else if v-min > max {
			max = v - min
		}
	}
	fmt.Println(max, min)
}
