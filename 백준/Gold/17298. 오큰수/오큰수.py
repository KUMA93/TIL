import sys
input=sys.stdin.readline

n=int(input())
arr=list(map(int, input().split()))

# 스택 안쓰는 코드 - O(n^2) 시간 초과
# NGE=[0]*(n+1)
# NGE[n]=-1
# for i in range(0, n-1):
#     cnt=0
#     for j in range(i+1, n):
#         if arr[i]<arr[j]:
#             NGE[i+1]=arr[j]
#             break
#         else:
#             cnt+=1
#             if cnt==n-i-1:
#                 NGE[i+1]=-1
#                 break
# for i in range(1, n+1):
#     print(NGE[i], end=' ')

# 1 3 5 3 4
# 3 5 -1 -1 4
# nums에 popped를 넣다가 arr[-1]이 now보다 크면 nums를 하나씩 pop해서 비교함 - 인덱스 에러가 어디서 나는지 계속 나서 실패...
# 스택 코드
stack=[]

for i in range(n):
    while stack:
        if arr[i]>arr[stack[-1]]:
            arr[stack.pop()]=arr[i]
        else:
            stack.append(i)
            break
    if not stack:
        stack.append(i)

for i in stack:
    arr[i] = -1
print(*arr)