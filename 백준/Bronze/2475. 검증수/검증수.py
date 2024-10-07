import sys
input = sys.stdin.readline

input = list(map(int, input().split()))
sum = 0
for x in input:
    sum += x**2

print(sum%10)