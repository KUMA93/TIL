import sys
import heapq
input=sys.stdin.readline

n=int(input())
card=[]
for i in range(n):
    card.append(int(input()))
heapq.heapify(card)
sum=0
if n==1:
    print(0)
    exit(0)
while len(card)>1:
    x=heapq.heappop(card)
    y=heapq.heappop(card)
    heapq.heappush(card, x+y)
    sum+=x+y
    if len(card) == 1:
        print(sum)
        break
