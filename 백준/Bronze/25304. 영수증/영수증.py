import sys
input=sys.stdin.readline

x=int(input())
n=int(input())
Sum=0
for i in range(n):
    a, b=map(int, input().split())
    Sum+=a*b
if Sum==x:
    print("Yes")
else:
    print("No")