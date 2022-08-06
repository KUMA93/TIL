import sys
import heapq
input=sys.stdin.readline

n, k=map(int, input().split())
jewel=[]
bag=[]
for i in range(n): # 보석 m, v 받기
    heapq.heappush(jewel, list(map(int, input().split())))
for i in range(k): # 가방 무게 받기
    bag.append(int(input()))
bag.sort()
res=0
cand=[]
for b in bag:
    while jewel and b>=jewel[0][0]:
        w, v= heapq.heappop(jewel)
        heapq.heappush(cand, -v)

    if cand:
        res-=heapq.heappop(cand)

print(res)