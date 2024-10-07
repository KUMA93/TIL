n=int(input())
board=[list(map(int, input())) for _ in range(n)]
# def Slice(sC, eC, sR, eR):
#     b=board[sC:eC]
#     for i in range(eC-sC):
#         b[i]=b[i][sR:eR]
#     return b
# def Check(T):
#     tmp=T[0][0]
#     for i in range(len(T)):
#         for j in range(len(T)):
#             if tmp!=T[i][j]:
#                 return False
#     return True
def quadTree(x, y, n):
    ch=board[x][y]
    for i in range(x, x+n):
        for j in range(y, y+n):
            if ch!=board[i][j]:
                ch=-1
                break
    if ch==-1:
        n//=2
        print('(', end='')
        quadTree(x, y, n)
        quadTree(x, y+n, n)
        quadTree(x+n, y, n)
        quadTree(x+n, y+n, n)
        print(')', end='')
    elif ch==1:
        print(1, end='')
    else:
        print(0, end='')

quadTree(0, 0, n)