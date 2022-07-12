import sys
input=sys.stdin.readline

n=int(input()) #1<=n<=100000 n범위가 크고 시간 제한이 빡빡하니 방법을 잘 찾아야 한다
arr=list(map(int, input().split()))

#dy[n]에서 n을 연속된 수의 개수로 정하고 푸는 동적계획인거 같은데 쌩으로 이 문제를 만났을 때 동적계획을 떠올릴수 있을까
#난 일단 이런식으로 풀거 같다 -> 시간초과 -> 다른 방법 찾다가 동적계획
# dy=[0]*(n+1)
# dy[0]=-2147000000
# dy[1]=max(arr)
# def findMax(s):
#     Max=-2147000000
#     for i in range(0, n-s+1):
#         Sum=0
#         for j in range(i, i+s):
#             Sum+=arr[j]
#         Max=max(Max, Sum)
#     return Max
# for i in range(2, n+1):
#     dy[i]=findMax(i)
# print(dy)
# print(max(dy))

#동적 계획
#dy[n]에서 n을 연속된 수의 개수로 정하고 푸는 방법은 브루탈포스에 가깝게 풀수밖에 없어서 동적 계획법이 의미가없다. 다른 방법을 찾아야한다
#결국 찾아내지 못해서 구글링 해보니 연속합을 구해나가면서 현재 위치의 값을 더한 값과 비교해서 더 큰값을 저장하는 방법이었다. 
#10 -4 3 1 5 6 -35 12 21 -1
#10 6 9 10 15 21 -14 12 33 
for i in range(1, n):
    arr[i]=max(arr[i], arr[i]+arr[i-1])

print(max(arr))
