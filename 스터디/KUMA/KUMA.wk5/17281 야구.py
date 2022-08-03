import sys
sys.stdin=open("input.txt", "rt")
from itertools import permutations
input=sys.stdin.readline

n=int(input())
scr=[list(map(int, input().split())) for _ in range(n)] # 1번선수는 4번타자
player=list(range(1, 9))
res=0

# 이닝당 한줄씩 각 선수의 타석 결과 , 3아웃이 되지 않을 경우 1번부터 다시 반복, 이닝이 종료될 때 순서 유지
for order in permutations(player, 8):
    order = list(order)
    order=order[:3] + [0] + order[3:] # 1번선수(인덱스 0) 4번타자로
    score=0
    idx=0
    for inning in range(1, n+1):
        out_cnt=0
        base_1, base_2, base_3=0, 0, 0
        while out_cnt<3:
            if scr[inning-1][order[idx]]==0:
                out_cnt+=1
            elif scr[inning-1][order[idx]]==1:
                score+=base_3
                base_1, base_2, base_3=1, base_1, base_2
            elif scr[inning-1][order[idx]]==2:
                score+=base_2+base_3
                base_1, base_2, base_3=0, 1, base_1
            elif scr[inning-1][order[idx]]==3:
                score+=base_1+base_2+base_3
                base_1, base_2, base_3=0, 0, 1
            elif scr[inning-1][order[idx]]==4:
                score+=base_1+base_2+base_3+1
                base_1, base_2, base_3=0, 0, 0
            idx+=1
            if idx==9:
                idx=0
    res=max(res, score)
print(res)