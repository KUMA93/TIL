import sys
input = sys.stdin.readline

# 다장조 c d e f g a b C 차례로 1~8

ascend = list(range(1, 9))
descend = list(range(8, 0, -1))
input = list(map(int, input().split()))

if input[0] != 1 and input[0] != 8:
    res = "mixed"
else:
    if input[0] == 1:
        res = "ascending"
        for i in range(8):
            if input[i] != ascend[i]:
                res = "mixed"
                break
    elif input[0] == 8:
        res = "descending"
        for i in range(8):
            if input[i] != descend[i]:
                res = "mixed"
                break

print(res)