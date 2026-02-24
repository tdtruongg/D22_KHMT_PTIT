# Ex1:

# data1 = [-10, -21, -4, -45, -66, 93, 11, -4, -6, 12, 11, 4]
#
# positive_count = sum(1 for num in data1 if num > 0)
# negative_count = sum(1 for num in data1 if num < 0)
#
# print(f"Số lượng số dương: {positive_count}")
# print((f"Số lượng số âm: {negative_count}"))


# # Ex2:
# from collections import  Counter
#
# data2 = [4, 6, 4, 3, 3, 4, 3, 4, 3, 8]
# k = 3
#
# ds_dem = Counter(data2)
#
# num_count = [num for num, count in ds_dem.items() if count > k]
#
# print("Số phần tử có tần suất xuất hiện lớn hơn", k, ":", num_count)

# # Ex3:
#
# data3 = [4, 5, 6, 7, 3, 9, 11, 2, 10]
#
# num_max = [max(data3[i], data3[i+1]) for i in range(len(data3)-1)]
#
# print("Các số thỏa mãn đề ra là", num_max)

# # Ex4:
# from itertools import permutations
#
# data4 = [1, 2, 3]
# k = 2
# l = 3
# ghepcap_num1 = list(permutations((data4), k))
# ghepcap_num2 = list(permutations((data4), l))
#
# print("Số cặp số thỏa mãn đề bài là:", ghepcap_num1, ghepcap_num2)

# # Ex5:
#
# data5_list1 = [[4, 3, 5, ], [1, 2, 3], [3, 7, 4]]
# data5_list2 = [[1, 3], [9, 3, 5, 7], [8]]
#
# kq = []
#
# for i in range(len(data5_list1)):
#     new_row = data5_list1[i] + data5_list2[i]
#     kq.append((new_row))
#
# print(kq)

# # Ex6:
#
#
# result = []
#
# for i in range(2000, 3201):
#     if(i % 7 == 0 and i % 5 == 1):
#         result.append(str(i)) #chuyển số thành chuỗi để nối vào trong danh sách
#
# print(",".join(result))

# # Ex7:
#
# result = []
#
# for i in range(1000, 3001):
#     if(i % 2 == 0):
#         result.append(str(i))
#
# print(",".join(result))

# Ex8:











