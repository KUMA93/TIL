n=int(input())
m=n
cnt=1

while True:
    m=(m%10)*10 + ((m//10)+(m%10))%10
    if m==n:
        break
    cnt+=1

print(cnt)