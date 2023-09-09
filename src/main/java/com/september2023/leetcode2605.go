package september2023

import (
	"fmt"
	"sort"
)

// 最小的1，最小的2，拼接
// 有重复的小取重复的小
func minNumber(nums1 []int, nums2 []int) int {
	sort.Ints(nums1)
	sort.Ints(nums2)
	m := make(map[int]interface{})
	for _, v := range nums1 {
		m[v] = 0
	}
	for _, v := range nums2 {
		if m[v] != nil {
			return v
		}
	}
	var i = 0
	var j = 0
	var a = 0
	var flagA = false
	var flagB = false
	for i < len(nums1) || j < len(nums2) {
		if j == len(nums2) || nums1[i] < nums2[j] {
			if !flagA {
				if a == 0 {
					a = nums1[i]
					flagA = true
				} else {
					return a*10 + nums1[i]
				}
			}
			i++
		} else if i == len(nums1) || nums1[i] > nums2[j] {
			if !flagB {
				if a == 0 {
					a = nums2[j]
					flagB = true
				} else {
					return a*10 + nums2[j]
				}
			}
			j++
		}
	}
	return 0
}

func main() {
	fmt.Println(minNumber([]int{3}, []int{5,1,2}))
}