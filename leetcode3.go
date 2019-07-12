//remove element

func removeElement(nums []int, val int) int {
    var newLength int =0
	var i int
	for i=0;i<len(nums);i++{
		if nums[i]!=val{
			nums[newLength]=nums[i]
			newLength++
		}
	}
	return newLength
}
