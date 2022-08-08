arr=str(input())
arr=arr.upper()
ch=[0]*26

for x in arr:
    ch[ord(x)-65]+=1
largest=-2147000000
for i in range(len(ch)):
    if largest<ch[i]:
        largest=ch[i]
        index=i

if ch.count(largest)>1:
    print("?")
elif ch.count(largest)==1:
    print(chr(index+65))
