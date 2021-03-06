import sys
input=sys.stdin.readline

n=int(input())

dy=[0]*(n+1)
dy[0], dy[1]=1, 1 #dy[1]=1, dy[2]=2로 초기화 시켜서 n이 1일때를 고려하지 않아 index error가 발생했음
#규칙성 - dy[n]은 dy[n-2]에 00을 붙이거나 dy[n-1]에 1을 붙이는 결과물의 숫자와 같다 - 조합으로도 해결가능할듯..? 일단 피보나치 수열
'''
dy[1]=1 = 1
dy[2]=00 11 = 2
dy[3]=001 100 111 = 3
dy[4]=0011 1100 1001 1111 0000 = 5
dy[5]=11111 00111 10011 11001 11100 10000 00100 00001 = 8
dy[6]=111111 000000 001111 100111 110011 111001 111100 000011 100001 100100 001001 001100 110000 = 13
'''

for i in range(2, n+1):
    dy[i]=(dy[i-1]+dy[i-2])%15746 # 인트형 변수 크기가 커지면 메모리 초과가 나므로 애초에 나머지값을 저장했음

print(dy[n])