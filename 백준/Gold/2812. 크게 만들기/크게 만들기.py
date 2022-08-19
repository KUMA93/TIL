import sys
input=sys.stdin.readline

n, k = map(int, input().split())
num=list(input().rstrip())
stack=[]
K=k
# 1. k개까지의 숫자를 앞에서 부터 지웠을 때 현재 제일 앞자리 수보다 커지는 경우 삭제
# 2. 남은 k값만큼 왼쪽에서부터 삭제..? // 남은 k개만큼 왼쪽수가 오른쪽수보다 작을경우 삭제
# 가 아니고 스택에 숫자를 쌓다가 남은 k의 범위 안에서 최대한의 숫자를 제거 해나가면 된다.
# 4177325284
# 41838852 // 4
# 4183 8
# 4 123 8
for i in range(n):
    while K>0 and stack and stack[-1] < num[i]:
        stack.pop()
        K-=1
    stack.append(num[i])

print(''.join(stack[:n-k]))
