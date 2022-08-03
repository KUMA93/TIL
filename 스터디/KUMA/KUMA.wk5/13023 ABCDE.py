import sys
sys.stdin=open("input.txt", "rt")
input=sys.stdin.readline

n, m=map(int, input().split())
relation=[[] for _ in range(n)]
ch=[0]*n
for i in range(m):
    a, b=map(int, input().split())
    relation[a].append(b)
    relation[b].append(a)

def findCycle(Lv, idx):
    if Lv==4:
        print(1)
        exit(0)
    for i in relation[idx]:
        if not ch[i]:
            ch[i]=1
            findCycle(Lv+1, i)
            ch[i]=0

for i in range(n):
    ch[i]=1
    findCycle(0, i)
    ch[i]=0
print(0)