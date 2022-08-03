import sys
sys.stdin=open("input.txt", "rt")
input=sys.stdin.readline

l, c=map(int, input().split()) # l개의 알파벳 소문자(최소 한개 모음, 두개 자음, 오름차순 정렬) c종류의 가능 문자 / 3≤L≤C≤15
cand=list(input().split())
cand.sort()
ch=[0]*c
collection=dict()
collection={'a':1, 'e':1, 'i':1, 'o':1, 'u':1}
pw=[]
def DFS(Lv, s):
    if Lv==l:
        coll, cons = 0, 0  # 모음, 자음 카운터
        for i in range(l):
            if pw[i] in collection:
                coll+=1
            else:
                cons+=1
        if coll>=1 and cons>=2:
            for x in pw:
                print(x, end='')
            print()
    else:
        for i in range(s, c):
            if ch[i]==0:
                ch[i]=1
                pw.append(cand[i])
                DFS(Lv+1, i+1)
                ch[i]=0
                pw.pop()

DFS(0, 0)