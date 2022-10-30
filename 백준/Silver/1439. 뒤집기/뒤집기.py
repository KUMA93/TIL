import sys
input = sys.stdin.readline

s = input().rstrip()
cnt=[int(s[0])]
flag = int(s[0])

for x in s:
    if x=='0':
        if flag!=0:
            cnt.append(0)
            flag=0
    elif x=='1':
        if flag!=1:
            cnt.append(1)
            flag=1

print(min(cnt.count(0), cnt.count(1)))