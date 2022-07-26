import sys

n=int(sys.stdin.readline().rstrip())
num=[int(sys.stdin.readline().rstrip()) for _ in range(n)]
num2=[]
for i in range(1, n):
    num2.append(abs(num[i]-num[i-1]))
def gcd(x, y):
    while y!=0:
        x, y=y, x%y
    return x
GCD=num2[0]
res=[]
for i in range(len(num2)):
    GCD=gcd(GCD, num2[i])
for i in range(2, int(GCD**0.5)+1):
    if GCD%i==0:
        res.append(i)
        if GCD//i!=i:
            res.append(GCD//i)
res.append(GCD)
res.sort()
for x in res:
    print(x, end=' ')