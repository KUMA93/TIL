import sys
sys.stdin=open("input.txt", "rt")
from collections import deque

def Set(x, y, size):
    dis=[[0]*n for _ in range(n)]
    visit=[[0]*n for _ in range(n)]
    visit[x][y]=1
    tmp=[]
    dq = deque()
    dq.append((x, y))
    while dq:
        now=dq.popleft()
        for i in range(4):
            nX=now[0]+dx[i]
            nY=now[1]+dy[i]
            if 0<=nX<n and 0<=nY<n and visit[nX][nY]==0:
                #값이 size보다 작거나 같으면 이동 가능
                #이동하고 visit배열에 표시, 거리정보를 dis배열에 갱신, 다음번 while문에서 now의 좌표로 대입될 nX, nY dq에 추가
                if board[nX][nY]<=size:
                    visit[nX][nY]=1
                    dis[nX][nY]=dis[now[0]][now[1]]+1
                    dq.append((nX,nY))
                    #값이 size보다 작으면 먹기 가능, 우선순위를 설정할 tmp배열에 위치정보, 거리정보를 추가
                    if 0<board[nX][nY]<size:
                        tmp.append((nX, nY, dis[nX][nY]))
    if tmp:
        tmp.sort(key=lambda x: (x[2], x[0], x[1])) #람다함수를 통해 먹을 수 있는 생선들의 우선순위를 설정
        return tmp[0]
    else:
        return False
n=int(input())
board=[]
dx=[-1,1,0,0]
dy=[0,0,-1,1] #상하좌우
size=2
cnt=0
Sum=0
for i in range(n):
    tmp=list(map(int, input().split()))
    for j in range(n):
        if tmp[j]==9:
            bX, bY=i, j
        '''
        처음엔 이곳에 ableTomove, ableToeat 배열을 만들어 이동, 먹기 가능한 좌표를 갱신하고 아래 while문에서 size가 커질때마다
        갱신해주는 방식으로 코드를 짰었는데 배열이 지나치게 많아지고 Set함수에서 경로 탐색을 하는 과정에 넣는게 오히려 효율적이라는
        생각이 들어 아기상어의 좌표만 저장하게됐음
        if tmp[j]<=size:
            ableTomove[i][j]=1
            if 0<tmp[j]<size:
            ableToeat[i][j]=1
        '''
    board.append(tmp)
while True:
    shark=Set(bX, bY, size)
    if not shark:   #더 이상 먹을것이 없는 상태일 때 어미상어에게 도움요청
        break
    #nX, nY, dist로 거리를 합산하고 아기상어의 위치를 갱신한다
    nX, nY, dist=shark
    Sum+=dist
    board[bX][bY], board[nX][nY]=0, 9
    bX, bY=nX, nY
    #cnt가 사이즈에 도달하면 cnt초기화, size 1상승
    cnt+=1
    if cnt==size:
        size+=1
        cnt=0
print(Sum)