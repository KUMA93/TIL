import sys
sys.stdin=open("input.txt", "rt")

input=sys.stdin.readline
n=int(input().strip())
ptlt, ptrt=map(str, input().split('*'))
ptrt=ptrt.strip() # 계속 안되서 이것저것 해보니 줄바꿈이 문제였다.....
for i in range(n):
    tmp=input().strip()
    if len(tmp)>=len(ptlt)+len(ptrt):
        if tmp[:len(ptlt)]==ptlt and tmp[len(tmp)-len(ptrt):]==ptrt:
            print('DA')
        else:
            print('NE')

