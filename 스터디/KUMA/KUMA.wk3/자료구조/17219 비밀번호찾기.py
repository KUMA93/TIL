import sys
sys.stdin=open("input.txt", "rt")
input=sys.stdin.readline

n, m=map(int, input().split())
pwList=dict()
for i in range(n):
    site, pw=input().split()
    pwList[site]=pw
for j in range(m):
    site=input().rstrip()
    print(pwList[site])