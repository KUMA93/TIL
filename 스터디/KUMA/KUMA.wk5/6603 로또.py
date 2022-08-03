import sys
sys.stdin=open("input.txt", "rt")
input=sys.stdin.readline

def DFS(Lv, s):
    if Lv==6:
        for x in case:
            print(x, end=' ')
        print()
        return
    else:
        for i in range(s, size):
            if ch[i]==0:
                ch[i]=1
                case[Lv]=arr[i]
                DFS(Lv+1, i+1)
                ch[i]=0

while True:
    arr=list(map(int, input().split()))
    if arr[0]!=0:
        size=arr[0]
        arr=arr[1:]
    else:
        exit(0)

    ch=[0]*(max(arr)+1)
    case=[0]*6

    DFS(0, 0)
    print()