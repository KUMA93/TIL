import sys
input = sys.stdin.readline

n = int(input())
computers = [[]*(n+1) for _ in range(n+1)]
ch = [0]*(n+1)
cnt = 0

for _ in range(int(input())):
    main, rel = map(int, input().split())
    computers[main].append(rel)
    computers[rel].append(main)

def dfs(start):
    global cnt
    ch[start] = 1
    for i in computers[start]:
        if ch[i]==0:
            dfs(i)
            cnt+=1

dfs(1)
print(cnt)