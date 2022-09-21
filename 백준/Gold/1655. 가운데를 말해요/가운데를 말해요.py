import sys
import heapq
input=sys.stdin.readline

leftHeap=[]
rightHeap=[]
n=int(input())

for i in range(n):
    num=int(input())

    if len(leftHeap)==len(rightHeap):
        heapq.heappush(leftHeap, -num)
    else:
        heapq.heappush(rightHeap, num)

    if rightHeap and rightHeap[0] < -leftHeap[0]:
        leftMax=heapq.heappop(leftHeap)
        rightMin=heapq.heappop(rightHeap)

        heapq.heappush(leftHeap, -rightMin)
        heapq.heappush(rightHeap, -leftMax)

    print(-leftHeap[0])

# 1                   1
# 1 5                 1
# 1 2 5               2
# 1 2 5 10            2
# -99 1 2 5 10        2
# -99 1 2 5 7 10      2
# -99 1 2 5 5 7 10    5