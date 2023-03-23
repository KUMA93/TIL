import sys
input=sys.stdin.readline

n, k=map(int, input().split())
p=1000000007
# 재귀 / 재귀 한도 초과 / 메모리 초과
# def factorial(x):
#     if x==1:
#         return 1
#     else:
#         return x*factorial(x-1)
#
# res=factorial(n)//(factorial(k)*factorial(n-k))
# print(res)

# dp / 메모리 초과 / 나머지를 각 값 저장할때 계산 -> 값 커지면 12 쯤에서 값이 역전 일어나서 이것도 안됨
# fact=[0]*(n+1)
# fact[1]=1
# for i in range(2, n+1):
#     fact[i]=fact[i-1]*i%p

# 일반적인 O(N)으로는 안되는것 같음.. n이 최대 4000000이라 웬만한 방법으로 안된다
# 도저히 시간초과 메모리초과를 벗어날 방법이 없어서 찾아보니 페르마 소정리를 이용해야한다고 한다.

def factorial(num, mod):
    res=1
    for i in range(2, num+1):
        res=res*i%p
    return res

def power(num, p, mod):
    if p==1:
        return num%mod
    if p%2==0:
        return (power(num,p//2,mod)**2)%mod
    else:
        return ((power(num,p//2,mod)**2)*num)%mod

print(factorial(n, p)*power(factorial(k, p)*factorial(n-k, p), p-2, p)%p)