import sys
import heapq
input=sys.stdin.readline

t=int(input())
for _ in range(t):
    k=int(input())
    visited=[0]*k
    minHeap, maxHeap = [], []
    for i in range(k):
        cmd, num = input().split()
        if cmd=='I':
            heapq.heappush(minHeap, (int(num), i))
            heapq.heappush(maxHeap, (-int(num), i))
        elif cmd=='D':
            if num=='1':
                while maxHeap:
                    if visited[maxHeap[0][1]]==1:
                        heapq.heappop(maxHeap)
                    else:
                        break
                if maxHeap:
                    visited[maxHeap[0][1]]=1
                    heapq.heappop(maxHeap)
            elif num=='-1':
                while minHeap:
                    if visited[minHeap[0][1]]==1:
                        heapq.heappop(minHeap)
                    else:
                        break
                if minHeap:
                    visited[minHeap[0][1]]=1
                    heapq.heappop(minHeap)
    while maxHeap:
        if visited[maxHeap[0][1]] == 1:
            heapq.heappop(maxHeap)
        else:
            break
    while minHeap:
        if visited[minHeap[0][1]] == 1:
            heapq.heappop(minHeap)
        else:
            break
    if minHeap and maxHeap:
        print(-maxHeap[0][0], minHeap[0][0])
    else:
        print('EMPTY')