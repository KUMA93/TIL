import sys
sys.stdin=open("input.txt", "rt")
input=sys.stdin.readline

n=int(input())
rope=[]
for i in range(n):
    rope.append(int(input()))
rope.sort(reverse=True)
maxW=0
for i in range(n):
    tmp=rope[i]*(i+1)
    maxW=max(maxW, tmp)
print(maxW)