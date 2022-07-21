t=int(input())
def factorial(x):
    res=1
    while x:
        res*=x
        x-=1
    return res
for i in range(t):
    n, m=map(int, input().split())
    res=factorial(m)//(factorial(n)*factorial(m-n))
    print(res)