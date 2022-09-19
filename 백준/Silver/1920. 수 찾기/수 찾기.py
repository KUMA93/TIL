import sys
input = sys.stdin.readline

n = int(input())
lst = list(map(int, input().split()))
a = dict()
for i in range(n):
    try:
        a[lst[i]]+=1
    except:
        a[lst[i]]=1
m = int(input())
b = list(map(int, input().split()))

for x in b:
    try:
        if a[x]>0:
            print(1)
    except:
        print(0)