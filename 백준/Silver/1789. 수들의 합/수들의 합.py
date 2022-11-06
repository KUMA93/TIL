import sys
input = sys.stdin.readline

s = int(input())
cnt=2
Sum = 0
while Sum<s:
    Sum+=cnt
    cnt+=1

print(cnt-2)