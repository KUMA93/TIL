import sys
input=sys.stdin.readline

n=int(input())
#  1   4
#     3 5
# 0      6
#       5 7
#     3    8
#       5   9
#        6   10
#          8   11
#          8     12
#   2              13
#                12  14
# 끝나는 시간 기준 정렬 후, 최소값부터 가능한 회의 추가
timetable=[]
for i in range(n):
    st, ed=map(int, input().split())
    timetable.append((ed, st))
timetable.sort()
limit=0
cnt=0
for i in range(n):
    if timetable[i][1]>=limit:
        cnt+=1
        limit=timetable[i][0]
print(cnt)