import sys
input = sys.stdin.readline

# N개의 랜선 필요 / N개 이상도 가능
# K개의 랜선 길이 제각각

K, N = map(int, input().split())
lanList = []
for _ in range(K):
    lanList.append(int(input()))

left = 1
right = max(lanList)

while left <= right:
    mid = (left + right) // 2
    cnt_mid, cnt_right = 0, 0

    for x in lanList:
        cnt_mid += x // mid
        cnt_right += x // (mid+1)

    if cnt_mid >= N:
        if cnt_right >= N:
            left = mid + 1
        else:
            print(mid)
            break
    else:
        right = mid - 1