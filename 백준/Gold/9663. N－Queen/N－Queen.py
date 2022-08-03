import sys
n=int(sys.stdin.readline().rstrip())
ch=[0]*n
cnt=0
def check(x):
    for i in range(x):
        if ch[x]==ch[i] or abs(ch[x]-ch[i])==x-i:
            return False
    return True

def Queens(x):
    global cnt
    if x==n:
        cnt+=1
        return
    else:
        for i in range(n):
            ch[x]=i
            if check(x):
                Queens(x+1)

Queens(0)
print(cnt)