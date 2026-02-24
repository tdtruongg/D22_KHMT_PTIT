#def: tạo ra một function(Hàm) tái sử dụng nhiều lần
ex: 
	def myfunction():

#Kèm mệnh đề trong câu lệnh
ex: 
	price = 100
	txt = f"The price is {price} dollars"
		print(txt)

#Muốn chèn thêm dấu ngoặc kép vào trong câu thì sử dụng thêm \\
ex:
	txt = "We are the so pro billard \"Hang CN\" from VN" 

#lặp qua các chữ cái trong từ " "
ex:
	for x in "truongdeptrai":
		print(x)

# kiểm tra độ dài chuỗi len()

#kiểm tra xem kí tự " " có xuất hiện trong chuỗi không
ex:
	out = "Truongmam best sutte"
	print("sutte" in out)

	if "sutte" in out:
	print("Yes, 'free' is present")

#Loại bỏ bất kỳ khoảng trắng nào từ đầu hoặc cuối
ex:
	a = "  Truongmam deptrai proplayer"
	print(a.strip())

#Thay thế bằng một chuỗi khác (thay đổi từ trong câu)
ex:	
	a = "Ok em, uh"
	print(a.replace("O", "A"))
	# -> Ak em, uh

#Split: phân tách, chia chuỗi thành các chuỗi con nếu tìm được dấu thể hiện phân cách
ex: 
	a = "Truongmam, codeptrai ko?"
	print(a.split(","))
	# -> ['Truongmam' , 'codeptrai ko?']

#đánh giá bất kỳ giá trị nào, trả về True hoặc False
#bool()
#Hầu như các giá trị chuỗi, hoặc số đều là đúng trừ chuỗi trống hoặc số 0
ex: 
	print(bool("Hello"))
	print(bool(15))

#Toán tử:
	x // y: chia lấy phần nguyên
	x ** y: lũy thừa
	x % y: chia lấy dư

#Danh sách trong Python: được sắp xếp và CÓ thể thay đổi. Cho phép các thành viên trùng lặp.
	#Danh sách được tạo ra bằng dấu hoặc vuông
	ex:
		thislist = ["apple", "banana", "cherry"]
		print(thislist)
	#Chèn "dưa hấu" làm mục thứ ba:
	ex:	
		thislist = ["apple", "banana", "cherry"]
 		thislist.insert(2, "watermelon")
		print(thislist)
	#Dùng .append() để thêm phần tử vào cuối chuỗi
	
	#Gộp 2 danh sách: .extend()
	thislist = ["apple", "banana", "cherry"]
	tropical = ["mango", "pineapple", "papaya"]
	thislist.extend(tropical)
	print(thislist)

	#Xóa bỏ, lấy ra phần tử trong danh sách:
		.remove()
		.pop()
		del thislist
		clear()
	#lặp qua các phần tử trong ds
		range()
		ex: #for i in range(...)
	#Sắp xếp theo thứ tự bảng chữ cái
		#sort
	#Sắp xếp theo thứ tự giảm dần
		#reverse = True
		ex: thislist.sort(reverse = True)
	#Sắp xếp trả về kiểu cho trước
		ex: #Sắp xếp ds với số gần 50	
			def myfunc(n):
  				return abs(n - 50)

			thislist = [100, 50, 65, 82, 23]
			thislist.sort(key = myfunc)
			print(thislist)
	#Sắp xếp chữ hoa chữ thường có thể ảnh hưởng đến kq
	#nên sử dụng thêm str.low
		ex: 
			thislist = ["banana", "Orange", "Kiwi", "cherry"]
			thislist.sort(key = str.lower)
			print(thislist)

	#copy danh sách
		.copy()
		ex1: thislist = ["a", "b", "c", "d"]
			mylist = thislist.copy()
			print(mylist)

		:
		ex2: thislist = ["apple", "banana", "cherry"]
			mylist = thislist[:]
			print(mylist)


#Tuple trong python: được sắp xếp và KO thể thay đổi. Cho phép các thành viên trùng lặp.
	#Tuples được sử dụng để lưu trữ nhiều mục trong một biến duy nhất.

	ex: thistuple = ("apple", "banana", "cherry")
		print(thistuple)

	#Các mục Tuple được sắp xếp, không thể thay đổi và cho phép các giá trị trùng lặp.
	#Tuple một mục, hãy nhớ dấu phẩy:
		thistuple = ("apple",)
		print(type(thistuple))

	#Tuple không dùng .copy() được mà ta dùng list()

	#Sử dụng dấu * để gán phần còn lại của danh sách được gọi là *...
		ex:
			fruits = ("apple", "banana", "cherry", "strawberry")
			(green, yellow, *red) = fruits

			print(green)
			print(yellow)
			print(red)

			#-> apple banana ['cherry', 'strawberry']

	#For trong Tuple
		ex: 
			thistuple = ("..", "..")
			for i in range(thistuple)
			print(thistuple[i])
	#Unpacking (Giải nén)
		ex: 
			fruits = ("apple", "banana", "cherry")

			(green, yellow, red) = fruits

			print(green)
			print(yellow)
			print(red)

#Set trong Python: không có thứ tự, không thể thay đổi* và chưa được lập chỉ mục. Không có thành viên trùng lặp.
	#Khai báo
		ex: 
			thisset = {"gao", "lua", "thoc"}
			print(thisset)

	#Sử dụng hàm set() để tạo nên một tập hợp
		ex: 
			thisset = set(("gao", "lua", "thoc"))
			print(thisset)

	#Lặp các phần tử trong Set
		ex: 
			for x in thisset:
				print(x)

	#Thêm phần tử vào Set
		ex: 
			thisset = {"gao", "lua", "ngo"}

			thisset.add("khoai")

			print(thisset)

	#Gộp 2 tập hợp	
		ex: 
			thisset1 = {"", "", ""}
			thisset2 = {"", "", ""}

			thisset1.update(thisset2)
			print(thisset1)

	#Xóa phần tử
		ex: 
			remove()
			discard() 
				#Nếu mục cần xóa ko tồn tại thì ko gây ra lỗi
			pop() 
				#Xóa 1 mục nhưng sẽ xóa ngẫu nhiên
				#Giá trị trả về của phương thức pop() là giá trị bị xóa bỏ
			clear()
				#Làm trống thư mục
			del 
				#xóa hoàn toàn thư mục 
	
	#Nối 2 tập hợp
		ex: 
			union() & update() #Nối tất cả các phần tử trong tập hợp hoặc có thể dùng toán tử |

				set1 = {"a", "b", "c"}
				set2 = {1, 2, 3}

				set3 = set1.union(set2)	                   

			intersection() #chỉ giữ các bản sao hoặc toán tử &
				
				set1 = {"apple", "banana", "cherry"}
				set2 = {"google", "microsoft", "apple"}

				set3 = set1.intersection(set2)

			difference() #giữ các item trong bộ đầu tiên mà không có trong các bộ khác hoặc toán tử -
				
				set1 = {"apple", "banana", "cherry"}
				set2 = {"google", "microsoft", "apple"}

				set3 = set1.difference(set2)


			symmetric_difference() #giữ tất cả các mục NGOẠI TRỪ các phần tử giống nhau hoặc toán tử ^

				set1 = {"apple", "banana", "cherry"}
				set2 = {"google", "microsoft", "apple"}

				set3 = set1.symmetric_difference(set2)

#Dictionary trong Python: được đặt hàng ** và có thể thay đổi. Không có thành viên trùng lặp.
	
	#Khai báo
	thisdict = {
		"brand" : "Ford",
		"model" : "Mustang",
		"year" : 1964
	}

	print(thisdict)

	#Các mục trùng lặp sẽ ghi đè lên nhau, cái sau ghi lên trước
		ex:
			thisdict = {
				"year" : 2003,
				"year" : 2024
			}
		print(thisdict) #(2024)

	#Lấy các khóa
		ex: 
			x = thisdict["model"]
			#or
			x = thisdict.get("model")
			#or
			x = thisdict.key()

	#Thêm các khóa
		ex: 
			car = {
			"brand": "Ford",
			"model": "Mustang",
			"year": 1964
			}
			x = car.keys()
			print(x) #before the change
			car["color"] = "white"
			print(x)

	#Lấy các giá trị
		ex:	
			x = thisdict.values()

	#Lấy các cặp giá trị
		ex:
			x = thisdict.items()

	#Đổi giá trị của khóa
		ex:
			thislist.update({"year" : 2024})

	#Xóa
		ex: 
			thisdict.pop("model")
			thisdict.popitem() #xóa trường key - value từ dưới lên
			del thisdict["model"]
			thisdict.clear()

	#Vòng lặp trong Dict
		ex: 
			for x in thisdict:
				print(thisdict[x])

			for x in thisdict.values():
				print(x)

			for x in thisdict.keys():
				print(x)

			for x, y in thisdict.items():
				print(x, y)


	#Copy
		ex:
			x = thisdict.copy()
			#or
			x = dict(thisdict)

	#Từ điển lồng nhau
		ex:
			child1 = {
			  "name" : "Emil",
			  "year" : 2004
			}
			child2 = {
			  "name" : "Tobias",
			  "year" : 2007
			}
			child3 = {
			  "name" : "Linus",
			  "year" : 2011
			}

			myfamily = {
			  "child1" : child1,
			  "child2" : child2,
			  "child3" : child3
			}
	#Truy cập
		ex: 	
			print(myfamily["child2"]["name"])

	#Lặp các phần tử trong từ điển
		ex:
			for x, obj in myfamily.items():
		  		print(x)
		  	for y in obj:
		    	print(y + ':', obj[y])

#Để tránh bị lỗi khi so sánh 
		ex: 
			a = 4 
			b = 13

			if b > a:
				pass

#Vòng lặp while trong Python
	ex:
		i = 1
		while i < 6:
			print(i)
			i += 1
	#NOTE: else cũng có thể dùng trong while

#Tạo hàm trong Python
	ex:	
		def my_fuction():

	#Nếu không biết có bao nhiêu đối số được truyền vào hàm thì thêm *
		ex:
			def myfunction(*game):
				print("game nay la san pham thu" + game[2])
			myfunction("", "", "","")

	#Nếu muốn tự truyền nội dung đối số cho hàm thì dùng **
		ex:
			def myfunction(**girl):
				print("em gai di bar cung t7 la " + girl["lname"])
			myfunction(fname = "Alisa", lname = "Tam Tit")

	#Nếu đối số trống nó sẽ in ra trong " "
		ex:
			def my_function(country = "Norway"):
  				print("I am from " + country)

			my_function("Sweden")
			my_function("India")
			my_function()
			my_function("Brazil")

	