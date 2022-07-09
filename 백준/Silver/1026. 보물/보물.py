import sys
input=sys.stdin.readline

n=int(input())
A=list(map(int, input().split()))
B=list(map(int, input().split()))
A.sort(reverse=True)
B.sort()
def makeS(A, B, n):
    S=0
    for i in range(n):
        S+=A[i]*B[i]
    return S
print(makeS(A, B, n))