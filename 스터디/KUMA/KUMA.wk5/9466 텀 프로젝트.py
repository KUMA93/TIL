import sys
sys.stdin=open("input.txt", "rt")
sys.setrecursionlimit(10**7)
input=sys.stdin.readline

t=int(input())
def findTeam(x):
    global res
    ch[x]=1
    team.append(x)
    now=s[x]
    if ch[now]:
        if now in team:
            res += team[team.index(now):]
        return
    else:
        findTeam(now)

for _ in range(t):
    n=int(input())
    s=[0] + list(map(int, input().split()))
    ch=[1] + [0]*n
    res=[]
    for i in range(1, n+1):
        if not ch[i]:
            team=[]
            findTeam(i)
    print(n-len(res))