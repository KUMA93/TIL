import sys
input=sys.stdin.readline

t=int(input())
for i in range(t):
    n=int(input()) #1<=n<=100
    P=[]
    P[0:11]=[0, 1, 1, 1, 2, 2, 3, 4, 5, 7, 9]
    '''
    # 규칙성  
    3 + 7  = 8
    4 + 8  = 9
    5 + 9  = 10
    6 + 10 = 11
    '''
    for i in range(11, n+1):
        P.append(P[i-1]+P[i-5])
    print(P[n])