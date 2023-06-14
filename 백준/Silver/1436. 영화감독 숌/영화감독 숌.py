n=int(input())
cnt=0
now=666
s=str(now)
while True:
    if s in str(now):
        cnt+=1
        if cnt==n:
            print(now)
            break
    now+=1