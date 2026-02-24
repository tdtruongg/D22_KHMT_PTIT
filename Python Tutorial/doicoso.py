def testCase():
	b = int(input())
	binaryString = input()
	if b == 2:
		return binaryString
	decimal = int(binaryString, 2)
	if decimal == 0:
		return 0
	if b == 4 or b == 8:
		res = ""
		while decimal > 0:
			res = res + str(decimal % b)
			decimal //= b 
		return res[::-1]
	else:
		return hex(decimal)[2:].upper()

	t = int(intput())
	while t > 0:
		t = t - 1
		print(testCase)