t = int(input())
while t > 0:
	a, b = input().split()
	c = input().strip()
	if(c.count(' ')): c,d = c.split()
	else : d = input()
	p = min(a, b)
	q = max(a, b)
	print(int(c.replace(q, p)) + int(d.replace(q, p)), end = ' ')
	print(int(c.replace(p, q)) + int(d.replace(p, q)))
	t -= 1