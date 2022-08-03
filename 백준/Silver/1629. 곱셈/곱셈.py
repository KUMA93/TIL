import sys
input=sys.stdin.readline

A, B, C=map(int, input().split()) # A의 B승을 C로 나눈 나머지

def power(a, b):
    if b==1:
        return a%C
    else:
        if b%2==0:
            return power(a,b//2)**2%C
        else:
            return power(a,b//2)**2*a%C

print(power(A, B))