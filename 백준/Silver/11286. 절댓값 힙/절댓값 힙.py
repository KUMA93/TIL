import sys
import heapq
input=sys.stdin.readline

n=int(input())
hq=[]

for i in range(n):
    tmp=int(input())
    if tmp==0:
        try:
            print(heapq.heappop(hq)[1])
        except:
            print(0)
    else:
        heapq.heappush(hq, (abs(tmp), tmp))