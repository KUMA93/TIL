import sys
sys.stdin=open("input.txt", "rt")
input=sys.stdin.readline

t=int(input())
for i in range(t):
    k=int(input())
    file=list(map(int, input().split()))
    # 임시파일을 만드는 횟수는 k-1번, =비용 발생 횟수
    # a b c d e
    # a+b c d+e // a+b+d+e
    # 3a+3b+2c+2d+2e
    # 2a+2b+2c+3d+3e
    # a b+c d+e // b+c+d+e
    # a+b+c d+e // a+2b+2c+d+e
    # a+b+c+d+e // 2a+3b+3c+2d+2e
    # (k-2)을 곱해줄 인접한 (k-3)개 수를 고르는 방법? ㄴㄴ
    # a b c d
    # a+b c+d // a+b+c+d
    # a+b+c+d // 2a+2b+2c+2d
    # a b+c d // b+c
    # a+b+c d // a+2b+2c
    # a+b+c+d // 2a+3b+3c+d
    # a+b c d // a+b
    # a+b+c d // 2a+2b+c
    # a+b+c+d // 3a+3b+2c+d
    # a b c+d // c+d
    # a b+c+d // b+2c+2d
    # a+b+c+d // a+2b+3c+3d
    # k1부터 k2까지 파일합병 최소 비용합 dp[k1][k2] 이라하면 dp[0][k]=dp[0][k1]+dp[k1][k]
    # 1차원으로는 안되나? dp[i]=dp[j]+dp[i-j] 은 안될듯 요소 값이 다 다르게 들어와서, 단순 sum배열로 만들어서 활용해야할듯
    # dp[0][k]=min(dp[0][k], dp[0][k1]+dp[k1][k], ...)


    dp=[[0]*k for _ in range(k)]
    # for i in range(k):
    #     dp[i][i]=file[i]

    for i in range(k-1):
        dp[i][i+1] = file[i] + file[i+1]
        for j in range(i+2, k):
            dp[i][j] = dp[i][j-1] + file[j]

    for d in range(2, k):
        for i in range(k-d):
            j=i+d
            dp[i][j] += min([dp[i][k] + dp[k+1][j] for k in range(i, j)])

    # for i in range(k, -1, -1):
    #     if i<k-1:
    #         dp[i][i+1]=dp[i+1][i+1]+dp[i][i]
    # j=2
    # while j<k:
    #     for i in range(k-j):
    #         dp[i][i+j]=min(dp[i+1][i+j]+dp[i][i], dp[i][i+j-1]+dp[i+j][i+j])
    #     j+=1
    # 02 13 24...
    # 03 14 25
    print(dp[0][k-1])
    for x in dp:
        print(x)
    print()