import sys
sys.stdin=open("input.txt", "rt")
input=sys.stdin.readline

def makeMap(n):
    global arr
    if n==1:
        arr[0]='-'
        return
    elif n==3:
        arr[0:3]=['-',' ','-']
        return
    n//=3
    makeMap(n)
    for i in range(3):
        if i==1:
            continue
        else:
            for k in range(n):
                arr[n*i+k]=arr[k]

while True:
    num=input().strip()
    if not num:
        break
    num=int(num)
    arr=[' ']*(3**num)
    makeMap(3**num)
    for x in arr:
        print(x, end='')
    print()