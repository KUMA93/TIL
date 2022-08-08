import sys
input=sys.stdin.readline

t=int(input())
for _ in range(t):
    n=int(input())
    lst=[]
    for i in range(n):
        lst.append(list(map(int, input().split())))
    lst.sort()
    # 정렬 후 첫번째 지원자는 무조건 뽑힌다. 그다음 면접 심사 순위를 기준으로 감소함수 갯수 세면 될듯
    std = lst[0][1]
    cnt=1
    for i in range(1, n):
        if lst[i][1]<std:
            std=lst[i][1]
            cnt+=1
    print(cnt)