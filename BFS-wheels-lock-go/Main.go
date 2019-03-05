package main

type Password struct {
	password [4]int
	step int
}

func ConvertString(origin string) (result [4]int) {
	for index, n := range origin{
		result[index] = int(n)
	}
	return
}
func GetOneStep(password []int) (result [][]int) {
	var backup = make([]int, 4)
	copy(backup, password)
	for i := 0; i < 4; i++ {
		password[i] = (password[i] + 1) % 10
		var tempPlus = make([]int, 4)
		copy(tempPlus, password)
		password[i] = (password[i] + 10 - 2) % 10
		var tempMinus = make([]int, 4)
		copy(tempMinus, password)
		result = append(result, tempPlus, tempMinus)
		copy(password, backup)
	}
	return
}
func checkEquals(self [4]int, target [4]int) bool {
	for index, s := range self {
		if s != target[index] {
			return false
		}
	}
	return true
}
func checkContains(self [4]int, list [][4]int) bool{
	for _, target := range list {
		if checkEquals(self, target) {
			return true
		}
	}
	return false
}
func openLock(deadends []string, target string) int {
	var deadendsI [][4]int;
	targetI := ConvertString(target)
	for _, d := range deadends {
		deadendsI = append(deadendsI, ConvertString(d))
	}
	var oneStepPassword [][4]int
	var usedPassword [][4]int
	start := Password {
		[4]int {0, 0, 0, 0},
		0,
	}
	if checkContains(start.password, deadendsI) {
		
	}

}
