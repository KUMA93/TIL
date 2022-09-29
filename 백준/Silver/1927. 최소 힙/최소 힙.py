import sys
import heapq
input=sys.stdin.readline

n=int(input())
hq=[]

for i in range(n):
    tmp=int(input())
    if tmp==0:
        try:
            print(heapq.heappop(hq))
        except:
            print(0)
    else:
        heapq.heappush(hq, tmp)