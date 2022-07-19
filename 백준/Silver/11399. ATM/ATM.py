import sys
input=sys.stdin.readline

n=int(input())
time=list(map(int, input().split())) # 오름차순으로 정렬하면 끝 아닌가..?
time.sort()
tmp, Sum=0, 0
for i in range(n):
    tmp+=time[i]
    Sum+=tmp
print(Sum)