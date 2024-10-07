import sys
input = sys.stdin.readline

# r = 31
# 1 ≤ L ≤ 50
# M = 1234567891

L = int(input())
alpha = list(range(1, 27))
str = list(map(str, input()))
sum = 0
for i in range(L):
    sum += alpha[ord(str[i]) - 97] * 31**i

# L이 커지면 모듈로 연산 필요
# alpha[ord(str[i]) - 97] * 31**i % 1234567891

print(sum%1234567891)