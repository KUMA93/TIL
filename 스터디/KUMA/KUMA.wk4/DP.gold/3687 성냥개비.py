import sys
sys.stdin=open("input.txt", "rt")
input=sys.stdin.readline

t=int(input())
for i in range(t):
    n=int(input())
    # 2: 1
    # 3: 7
    # 4: 4
    # 5: 2 3 5
    # 6: 0 6 9
    # 7: 8
    dpMax=[0]*(n+1) # 성냥개비 n개로 만들수 있는 최대값
    dpMin=[str(10**15)]*(n+1) # 성냥개비 n개로 만들수 있는 최소값
    # 첫자리 0불가능, 최대값은 1의 자리부터 최소치로 만들며 올라가고 최소값은 1의 자리부터 최대치로 만들며 올라가야 한다
    # 4부터 한자리 두자리 선택 가능
    dpMax[2]='1'
    dpMin[2]='1'
    if n>2:
        dpMax[3]='7'
    tmp=[str(10**15)]*(n+1)
    tmp[3:8] = ['7', '4', '2', '6', '8']
    for i in range(3, n+1):
        dpMin[i]=tmp[i]

    # 2 3 4 5 6 7 / 8   9   10  11  12  13  14  / 15    16    17    18    19    20    21    / 22    23
    # 1 7 4 2 6 8 / 10  18  22  20  28  68  88  / 108   188   200   208   288   688   888   /
    # 2 3 4 5 6 7 / 2+6 2+7 5+5 5+6 5+7 6+7 7+7 / 2+6+7 2+7+7 5+6+6 5+6+7 5+7+7 6+7+7 7+7+7 /
    # dpMin[i]=dpMin[i-j] + dpMin[j]
    for i in range(4, n+1):
        dpMax[i]=dpMax[i-2]+dpMax[2]
    for i in range(8, n+1):
        for j in range(2, i):
            if j==6:
                dpMin[i]=str(min(int(dpMin[i]), int(dpMin[i-j]+'0')))
            else:
                dpMin[i]=str(min(int(dpMin[i]), int(dpMin[i-j]+dpMin[j])))

    print(dpMin[-1], dpMax[-1])

