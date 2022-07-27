n, m=map(int, input().split())
board=[list(input()) for _ in range(n)]
res=2147000000
for i in range(n-7):
    for j in range(m-7):
        for k in range(2):
            state = board[i][j]
            cnt=0
            if state=='W':
                if k==0:
                    state='W'
                else:
                    state='B'
                    cnt+=1
            else:
                if k==0:
                    state='W'
                    cnt+=1
                else:
                    state='B'
            for x in range(8):
                for y in range(8):
                    if x==0 and y==0:
                        continue
                    elif state=='W':
                        if board[i+x][j+y]==state:
                            cnt+=1
                            state='B'
                        else:
                            state='B'
                    elif state=='B':
                        if board[i+x][j+y]==state:
                            cnt+=1
                            state='W'
                        else:
                            state='W'
                if state=='W':
                    state='B'
                else:
                    state='W'
            res=min(res, cnt)
print(res)