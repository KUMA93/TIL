import sys

n, m, k = map(int, input().split())

l = []
segmentTree = [0]*(n*4)

def init(start, end, idx):
    if start == end:
        segmentTree[idx] = l[start-1]
        return segmentTree[idx]

    mid = (start+end)//2
    segmentTree[idx] = init(start, mid, idx*2) + init(mid+1, end, idx*2+1)
    return segmentTree[idx]

def find(start, end, idx, left, right):
    if start > right or end < left:
        return 0

    if start >= left and end <= right:
        return segmentTree[idx]

    mid = (start + end)//2
    sub_sum = find(start, mid, idx*2, left, right) + find(mid+1, end, idx*2+1, left, right)
    return sub_sum

def update(start, end, idx, updateIdx, updateData):
    if start > updateIdx or end < updateIdx:
        return

    segmentTree[idx] += updateData

    if start == end:
        return

    mid = (start + end)//2
    update(start, mid, idx*2, updateIdx, updateData)
    update(mid+1, end, idx*2+1, updateIdx, updateData)

for _ in range(n):
    l.append(int(input()))

init(1, n, 1)

for _ in range(m+k):
    a, b, c = map(int, input().split())
    if a == 1:
        tmp = c-l[b-1]
        l[b-1] = c
        update(1, n, 1, b, tmp)
    elif a == 2:
        print(find(1, n, 1, b, c))