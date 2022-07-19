import sys
input=sys.stdin.readline

n=int(input())
dt=list(map(int, input().split()))
cost=list(map(int, input().split()))
# 2 3 1 10 5 6 8 7 2
# 5 2 4 1 2 4 8 10 2 8
Sum=0
i=0
while i!=n-1:
    Sum+=dt[i]*cost[i]
    j=i+1
    while j<n-1 and cost[i]<cost[j]:
        Sum+=dt[j]*cost[i]
        j+=1
    i+=1
    i+=j-i
print(Sum)