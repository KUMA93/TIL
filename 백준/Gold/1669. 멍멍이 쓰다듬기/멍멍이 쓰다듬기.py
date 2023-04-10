import sys
import math
input = sys.stdin.readline

# 0 ≤ X ≤ Y < 2^31
X, Y = map(int, input().split())
gab = Y - X
s_gab = int(math.sqrt(gab))
sum = 0
if gab == 0:
    print(sum)
    exit(0)
if gab == s_gab * s_gab:
    sum = (s_gab-1) * 2 + 1
elif gab <= s_gab * s_gab + s_gab:
    sum = (s_gab-1) * 2 + 2
else:
    sum = (s_gab-1) * 2 + 3
print(sum)