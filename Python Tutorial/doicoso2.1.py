so=[10,11,12,13,14,15]
chu=['A','B','C','D','E','F']
def cd(s,m):
    sum=0
    cs=1
    for i in range(len(s)-1,-1,-1):
        sum=sum+cs*int(s[i])
        cs*=2
    if m==4 :
        if sum==10: print('A',end='')
        elif sum==11: print('B',end='')
        elif sum==12: print('C',end='')
        elif sum==13: print('D',end='')
        elif sum==14: print('E',end='')
        elif sum==15: print('F',end='')
        else : print(sum,end='')
    else : print(sum,end='')
t=int(input())
while t>0:
    n=int(input())
    s=input()
    if n==2:
        print(s)
    else:
        x=-1
        if n==4 : x=2
        elif n==8: x=3
        else : x=4
        if len(s)%x==0: them=0
        else : them=x-(len(s)%x)
        while them>0:
            s="0"+s
            them-=1
        for i in range(0,len(s),x):
            cd(s[i:i+x],x)
        print()
    t-=1