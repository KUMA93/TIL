import sys

S=sys.stdin.readline().rstrip()
arr=set()
for i in range(len(S)):
    for j in range(i, len(S)):
        arr.add(S[i:j+1])
print(len(arr))