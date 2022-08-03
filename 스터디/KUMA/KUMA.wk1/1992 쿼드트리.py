import sys
sys.stdin=open("input.txt", "rt")

n=int(input())
board=[list(map(int, input())) for _ in range(n)]

def quadTree(x, y, n):
    ch=board[x][y]      #ch가 이후 쿼드트리를 1,2,3,4 분면으로 분할할지, 어떤 수로 출력할지를 결정하는 변수
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


#처음엔 Slice함수로 보드를 자르고 Check함수를 통해 검사를 하려고 했는데 코드가 미관상 아름답지가 못해서 위의 코드로 변경함 
def Slice(sC, eC, sR, eR):
    b=board[sC:eC]
    for i in range(eC-sC):
        b[i]=b[i][sR:eR]
    return b
def Check(T):
    tmp=T[0][0]
    for i in range(len(T)):
        for j in range(len(T)):
            if tmp!=T[i][j]:
                return False
    return True
