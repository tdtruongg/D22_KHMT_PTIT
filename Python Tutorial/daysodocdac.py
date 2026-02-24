def is_unique_array(A, N):
   
    freq = {}
    for num in A:
        freq[num] = freq.get(num, 0) + 1
    if any(count > 1 for count in freq.values()):
        return "NO"
    return "YES"

def solve():
    
    T = int(input())
    for _ in range(T):  
        N = int(input())
        A = list(map(int, input().split()))
        print(is_unique_array(A, N))
solve()