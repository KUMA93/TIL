import sys
input=sys.stdin.readline

n, b = map(int, input().split())
mat = [list(map(int, input().split())) for _ in range(n)]

def mulMatrix(x, y):
    res = [[0] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            for k in range(n):
                res[i][j] += x[i][k] * y[k][j]
            res[i][j] %= 1000
    return res

def squareMatrix(b):
    if b==1:
        return mat
    if b%2==0:
        tmp=squareMatrix(b//2)
        return mulMatrix(tmp, tmp)
    else:
        tmp=squareMatrix(b-1)
        return mulMatrix(tmp, mat)

res=squareMatrix(b)
for x in res:
    for y in x:
        print(y % 1000, end=' ')
    print()
# 예외까지 다 처리했는데 문제는 4중 반복문이라 시간 초과, 분할 정복으로 해결해야한다
# tmp=[[0]*n for _ in range(n)]
# if b==1:
#     res=A
# if b>1:
#     for i in range(n):
#         for j in range(n):
#             for k in range(n):
#                 tmp[i][j] += A[i][k] * A[k][j]
# if b==2:
#     res=tmp
# if b>2:
#     for x in range(b-2):
#         for i in range(n):
#             for j in range(n):
#                 for k in range(n):
#                     res[i][j]+=tmp[i][k]*A[k][j]
#         tmp=res
#         res=[[0]*n for _ in range(n)]
#
# for x in tmp:
#     for y in x:
#         y%=1000
#         print(y, end=' ')
#     print()
