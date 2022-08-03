# 5주차 DFS + 구현 + 자료구조

## 6603 로또
* 뽑는 수는 6으로 고정, 수의 개수는 입력으로 주어지는 문제인데 첫 번째 숫자가 숫자들의 개수를 나타내는 k
* 이 문제는 `k개의 숫자중에 6개를 골라` 사전순으로 출력하는 문제이다.
* 입력 받는 부분 -  첫번째 숫자가 0이라면 프로그램 종료, 아니라면 숫자의 개수를 나타내는 변수 size에 저장 후 나머지 숫자 arr에 다시 저장
  ```python
  while True:
      arr=list(map(int, input().split()))
      if arr[0]!=0:
          size=arr[0]
          arr=arr[1:]
      else:
          exit(0) 
  ```
* 해당 숫자를 이미 `탐색했는지 알수 있는 캐시 배열 ch`와 `탐색한 숫자를 기록하는 case`
  ```python
  ch=[0]*(max(arr)+1)
  case=[0]*6
  ```
* 조합 구하는 부분 - 6개를 다 뽑았으면 출력, 그 이전까지는 `arr[s]부터` 마지막까지 탐색하면서 ch값이 0인 요소를 넣어준다
  ```python
  def DFS(Lv, s):
    if Lv==6:
        for x in case:
            print(x, end=' ')
        print()
        return
    else:
        for i in range(s, size):
            if ch[i]==0:
                ch[i]=1
                case[Lv]=arr[i]
                DFS(Lv+1, i+1)
                ch[i]=0
  ```

## 2800 괄호제거
* 괄호쌍의 인덱스값을 검색하기 위해 인강에서 듣고 자세히 공부하지 않았던 enumerate 함수를 다시 공부했다.
* `괄호쌍의 인덱스값`을 tmp에 저장
  ```python
  for i, v in enumerate(S):
      if v=='(':
          stack.append(i)
      elif v==')':
          tmp.append((stack.pop(), i))
  ```
* tmp에서 받아온 `인덱스값중`에 `1개부터 len(tmp)까지 조합`을 구한다. - 코테에서도 이런 내장 라이브러리 사용해도 되는가? 매번 재귀로 조합구하기가 여간 귀찮은게 아니다
  ```python
  for i in range(1, len(tmp)+1):
      comb = combinations(tmp, i)
  ```
* 괄호중 i개를 선택한 조합에 따라 i개의 `괄호를 제거`하고 `set 자료형`인 `answer`에 `문자열로 합쳐서 저장`해준다.
  ```python
  for j in comb:
      target=list(S) # list(S) 나 S.copy()같은 shallow copy를 해줘야 원본 리스트 S에 영향이 가지 않고 메모리도 덜 먹는다. deep copy는 메모리를 많이 먹음
      for k in j:
          target[k[0]] = ''
          target[k[1]] = ''
      answer.add(''.join(target))  
  ```

## 1937 욕심쟁이 판다
* dp까지 사용했는데도 메모리초과가 떴어서 계속 온몸비틀기했는데 사용언어를 pypy가 아닌 python으로 바꿔주니까 바로 통과... 속도가 더 빠른대신 메모리를 더 많이 사용하는 경향이 있다.
* 재귀한도에 걸려서 맞춤으로 풀어줬다. 500칸 * 500칸 * 4방향 = 10^6
  ```python
  sys.setrecursionlimit(10**6) # 500*500 250000*4 1000000
  ```
* `ch[x][y]`를 `0으로 초기화`해서 방문하지 않았음을 표시해주고 Panda함수를 통해서 좌표 (x, y)를 입력 받으면 그 좌표에서 대나무 양이 더 많은 곳으로 탐색을 하고 이미 탐색한 곳일 경우에 ch[x][y] 값을 리턴해준다.
  ```python
  def Panda(x, y):
      if ch[x][y]:
          return ch[x][y]
      ch[x][y]=1
      for i in range(4):
          xx=x+dx[i]
          yy=y+dy[i]
          if 0<=xx<n and 0<=yy<n and board[xx][yy]>board[x][y]:
              ch[x][y] = max(ch[x][y], Panda(xx, yy)+1)
      return ch[x][y]
  ```

## 9466 텀 프로젝트
* 내 풀이는 자꾸 시간초과가 떠서 구글링을 했다
* 나는 인덱스+1(학생 번호)와 그 학생이 원하는 학생 번호를 튜플로 묶어 저장한 뒤 진행했는데 풀이는 주어지는 입력 그대로 사용한 점이 가장 달랐고 방문기록을 알 수 있는 ch 활용 방법도 살짝 달랐다.
  ```python
  def findTeam(x):
    global res
    ch[x]=1
    team.append(x)
    now=s[x]
    if ch[now]:
        if now in team:
            res += team[team.index(now):]
        return
    else:
        findTeam(now) 
  ```

## 2573 빙산
* BFS로 영역탐색과 동시에 다음년도에 빙산의 높이가 얼마나 깎이는지를 찾았다.
* 처음부터 의도한건 아니고 영역탐색을 구현하고 보니 4방향탐색때 0인 값의 개수를 저장했다가 빼면 된다는 생각이 들어서 그렇게 구현했다.
* 구현 자체는 금방 했는데 계속 틀렸다고 떠서 왜그런가 이것저것 고쳐대다 보니 아주 기본적인 걸 틀렸다. 빙산의 높이가 10까지라는 문제의 조건을 오해해서 시간이 최대 10까지만 흐르게(for문 10번 반복) 해둬서 틀렸던 것이었다. 문제를 좀 더 꼼꼼하게 읽어야겠다.
* `인접한 빙산 탐색`과 `다음년도에 깎일 빙산의 높이`를 구하는 함수 glacialMount. 기본적인 bfs 형식이며 조건문이 하나 추가되어 `인접한 값이 0인 구역(바닷물)을 탐색`한다
  ```python
  def glacialMount(a, b):
    dq.append((a, b))
    while dq:
        x, y=dq.popleft()
        ch[x][y]=1
        for i in range(4):
            xx=x+dx[i]
            yy=y+dy[i]
            if 0<=xx<n and 0<=yy<m:
                if board[xx][yy]>0 and ch[xx][yy]==0:
                    ch[xx][yy]=1
                    dq.append((xx, yy))
                elif board[xx][yy]==0:
                    year[x][y]+=1
    return
  ```
* 반복문으로 시간이 흐르게 하는 부분, 매년도마다 `방문여부를 체크하는 ch배열`과 `빙산이 깎이는 높이를 저장하는 year배열`을 초기화, 인접한 빙산을 glacialMount를 통해 탐색하고 그 때마다 cnt값을 1씩 올려준다.
  ```python
  while True:
    ch=[[0]*m for _ in range(n)]
    year=[[0]*m for _ in range(n)]
    cnt=0
    for i in range(1, n-1):
        for j in range(1, m-1):
            if board[i][j]>0 and ch[i][j]==0:
                cnt+=1
                glacialMount(i, j)
    for i in range(n):
        for j in range(m):
            board[i][j]-=year[i][j]
            if board[i][j]<0:
                board[i][j]=0 
  ```
* 출력 부분 - cnt가 2이상일 경우 반복문마다 1씩 늘려줬던 res값을 출력하고 반복문 종료, cnt가 0인 경우 빙산이 없는 상황이므로 0을 출력하고 반복문 종료
  ```python
  if cnt==0:
      print(0)
      break
  if cnt>=2:
      print(res)
      break
  res+=1
  ```

## 7490 0만들기
* 알파벳 외에도 아스키코드값을 좀 외워둬야 하겠단 생각이 들었다.
* n에 따라 만들 수 있는 `모든 n-1개의 연산자 리스트를 미리 만들어 optr 배열에 저장`한다.
  ```python
  def optrGene(st, n): # 공백 아스키코드값 32 / + 아스키코드값 43 / - 아스키코드값 45
    if len(st)==n:
        optr.append(copy.deepcopy(st))
        return
    st.append(' ')
    optrGene(st, n)
    st.pop()

    st.append('+')
    optrGene(st, n)
    st.pop()

    st.append('-')
    optrGene(st, n)
    st.pop()
  ```
* 계산에 사용할 `정수`와 `연산자가 들어갈 자리`를 포함한 문자열 S를 만들어놓는다.
  ```python
  for i in range(1, 2*n):
    if i%2==0:
        S+=' '
    else:
        tmp=i//2+1
        S+=str(tmp) 
  ```
* 만들어 놓은 연산자들의 조합만큼 문자열에 넣어줘서 결과가 0인 경우에 출력한다. 이 때 문자열에 공백이 있을 경우 eval 함수가 작동하지 않으므로 공백을 지우고 계산한다.
  ```python
  for i in range(len(optr)):
      idx=0
      for j in range(len(S)):
          if S[j].isdigit():
              case.append(S[j])
          else:
              case.append(optr[i][idx])
              idx+=1
      res=''.join(case)
      if eval(res.replace(' ', '')) ==0:
          print(res)
      case=[]
  print() 
  ```

## 13023 ABCDE
* 처음에 문제만 읽고는 인원 관계없이 관계가 사이클을 이루는 경우와 `5명`이 사이클을 이루는 경우 둘 중에 헷갈렸는데 입력 조건에 n이 5이상인 걸 보고 후자구나 싶었다.
* 이번주차의 텀프로젝트와 비슷한 느낌이었는데 텀 프로젝트도 인접행렬로 구현했다가 시간초과를 벗어날 수 없어서 구글링 이후 인접리스트를 배웠었다. n의 범위가 `최대 2000`이라 `2000*2000`의 인접 행렬을 만들면 시간초과를 벗어날 수 없을 것 같아서 다른 방법을 생각했다.
* 처음엔 관계를 나타내는 `relation`을 시간이 덜 걸릴 것 같아서 `딕셔너리`로 구현을 했었는데 key error가 뜨는데 잡을수가 없어서 `인접리스트로 바꿨다`.
  ```python
  for i in range(m):
    a, b=map(int, input().split())
    if not a in relation:
        relation[a]=[]
    if not b in relation:
        relation[b]=[]
    relation[a].append(b)
    relation[b].append(a)
  -------------인접리스트로 수정---------------- 
  for i in range(m):
    a, b=map(int, input().split())
    relation[a].append(b)
    relation[b].append(a)
  ```
* dfs 부분 - 5명의 사이클 관계를 찾게되면 1을 출력 후 바로 프로그램을 종료하도록 했다. 반복문을 다 돌때까지 찾아내지 못하면 0을 출력한다.
  ```python
  def findCycle(Lv, idx):
    if Lv==4:
        print(1)
        exit(0)
    for i in relation[idx]:
        if not ch[i]:
            ch[i]=1
            findCycle(Lv+1, i)
            ch[i]=0 
  for i in range(n):
    ch[i]=1
    findCycle(0, i)
    ch[i]=0
  print(0)
  ```

## 1759 암호 만들기
* 일반적인 조합 만드는 문제에서 자음과 모음 조건이 붙은 문제이다.
* 알파벳은 `자음 + 모음`이므로 딕셔너리 자료형 collection을 만들어 모음을 저장한다
  ```python
  collection=dict()
  collection={'a':1, 'e':1, 'i':1, 'o':1, 'u':1}
  ```
* dfs에서 l만큼 조합이 만들어졌을 때 모음의 수와 자음의 수를 세어 조건을 만족할 시 출력한다.
  ```python
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
  ```

## 17281 야구
* 각 선수의 타석 결과를 배열로 받아서 선수를 배치하는 모든 경우의 수에 따른 최대 점수를 구하는 문제다
* 1번선수가 4번 타석에 서야한다.
* 정해진 순서대로 삼진 아웃이 나오기전까지 타석에 세운다.
  ```python
  scr=[list(map(int, input().split())) for _ in range(n)] # 1번~9번 선수들의 타석 결과
  player=list(range(1, 9)) # 순열을 구할 2번~9번(인덱스상 1~8) 선수 목록
  ```
* 순열 구하는 부분
  ```python
  for order in permutations(player, 8):
    order = list(order)
    order=order[:3] + [0] + order[3:] # 1번선수(인덱스 0) 4번타자(인덱스 3)으로
    score=0 # 순열마다 점수를 초기화
    idx=0 # 이닝에서 타자 번호를 가르킬 변수
  ```
* 이닝 진행 부분 - 문제에서 주어진 조건대로 0일 시 아웃 1~3루타는 해당 숫자 4는 홈런으로 처리했다.
  ```python
  for inning in range(1, n+1):
      out_cnt=0 # 아웃 횟수를 나타내는 변수
      base_1, base_2, base_3=0, 0, 0 # 1,2,3루에 선수가 있는 지 나타내는 변수
      while out_cnt<3: # 3아웃이 되기 전까지 진행
          if scr[inning-1][order[idx]]==0: # 아웃인 경우
              out_cnt+=1
          elif scr[inning-1][order[idx]]==1: # 안타인 경우
              score+=base_3
              base_1, base_2, base_3=1, base_1, base_2
          elif scr[inning-1][order[idx]]==2: # 2루타인 경우
              score+=base_2+base_3
              base_1, base_2, base_3=0, 1, base_1
          elif scr[inning-1][order[idx]]==3: # 3루타인 경우
              score+=base_1+base_2+base_3
              base_1, base_2, base_3=0, 0, 1
          elif scr[inning-1][order[idx]]==4: # 홈런인 경우
              score+=base_1+base_2+base_3+1
              base_1, base_2, base_3=0, 0, 0
          idx+=1
          if idx==9: # 9번 타자까지 치면 1번타자 차례로 돌아간다
              idx=0
    res=max(res, score)
  ```

## 6549 히스토그램에서 가장 큰 직사각형
* 처음엔 단순하게 생각해서 높이를 1씩 늘려가며 최대 연속 갯수를 구해서 개수*높이식으로 최대값만 변수 res에 저장하는 방식으로 구현했다. 하면서 이게 왜 플레티넘이지 싶었다.
  ```python
  while True:
    his=list(map(int, input().split()))
    if his[0]==0:
        break
    n=his[0]
    his=his[1:]
    size=max(his)
    res=0
    for i in range(size+1):
        cnt=0
        tmp=[]
        for j in range(n):
            if his[j]>=i:
                cnt+=1
            else:
                tmp.append(cnt*i)
                cnt=0
        tmp.append(cnt*i)
        res=max(res, max(tmp))
    print(res) 
  ```
* 시간초과가 뜨길래 문제를 자세히 읽어보니 주어지는 직사각형의 높이가 최대 10억이다.. 높이를 기준으로 삼으면 시간초과를 벗어날 수 없을 것 같아서 다른 방법을 생각했다.
* 최대 넓이는 직사각형을 적어도 하나 포함하므로 각 직사각형을 입력받을 때마다 최대한 그 사각형의 넓이를 양옆으로 이어나갈 수 있을만큼 잇고 넓이를 게산했는데 이것도 시간초과
  ```python
  for i in range(n):
    length=1
    det=1
    while 0<=i-det<n and histogram[i-det]>=histogram[i]:
        det+=1
        length+=1
    det=1
    while 0<=i+det<n and histogram[i+det]>=histogram[i]:
        det+=1
        length+=1
    res=max(res, length*histogram[i])
  ```
* 이외에도 몇가지 시도를 했는데 모두 시간초과가 떠서 구글링을 했다. 크게 세 가지 방법이 있었다.
  1. 스택 - 236ms
  2. 분할정복 - 992ms
  3. 세그먼트 트리(분할정복 사용)
* 출제 의도는 분할 정복으로 풀으라고 한 것 같은데 생각보다 어려워서 다른 사람이 써놓은 코드를 보고도 이해하는데 꽤 오래걸렸다.
* 스택 코드가 압도적으로 시간, 메모리 모두 좋은 결과를 냈지만 알고 있지 않으면 활용하기가 어렵다는 생각이 들었다.
* 주어진 히스토그램을 절반으로 나누는 분할을 한다고 할 때 분할 정복의 아이디어는 다음과 같다.
  1. 분할 선 기준으로 `왼쪽 히스토그램에서 가장 큰 직사각형`
  2. 분할 선 기준으로 `오른쪽 히스토그램에서 가장 큰 직사각형`
  3. `분할 선을 포함`하는 직사각형 중 `가장 큰 직사각형`
* 이 셋중 최대값을 저장해 나가면 문제가 풀리는 형태이다.
* 나중에 다시 풀어봐야겠다.

## 14939 불 끄기
* 우선 모양을 점검해볼 필요가 있다. 스위치는 다음 모양의 상태를 모두 바꾼다
```
 O
OOO
 O
```
* 몇가지 규칙을 추출해 보면
  1. 스위치는 단 한 번만 누르는 경우만 고려 하면 된다. -> 그 이상 누르는 건 최소값이 될 수없다.
  2. 스위치를 누르는 순서는 중요치 않다.
  3. 위의 모양에서 윗방향 전구가 확실히 꺼진 상태로 고정이 되려면 좌표가 (i, j)라고 할 때, (i+1, j)에서 스위치를 눌러 꺼지거나 (i, j)가 꺼진상태여야 한다.
  4. 즉, (i+1, j)의 스위치를 (i, j)의 불이 켜져있다면 누르고 꺼져있다면 누르지 않아야 한다.
  5. 자신 보다 바로 위의 요소가 없는 첫째 줄의 경우 모든 경우의 수를 구해봐야 한다.
* 첫째 줄의 경우의 수를 중복순열로 구하는 식으로 했다. `10칸을 0 혹은 1로 채우는 모든 경우의 수(1024가지)`에 대해 스위치를 1에서 눌러주고 둘째줄 부터의 기능을 시행한다.
  ```python
  for c in product(num, repeat=10):
    tmp_board=[board[i][:] for i in range(10)]
    cnt=0
    for j in range(10):
        if c[j]==1:
            switch(tmp_board, 0, j)
            cnt+=1
  ```
* 둘째줄 부터는 조건에 맞게 `(i-1, j)가 켜져있는 상태`면 일일이 스위치를 눌러보는 식으로 구현했다. 마지막까지 다 눌러보면 `9번째 줄까지는 불이 다 꺼진 상태`이고 `10번째 줄만 불이 다 꺼졌는 지 검사`해주면 된다.
  ```python
      for i in range(1, 10):
        for j in range(10):
            if tmp_board[i-1][j]:
                switch(tmp_board, i, j)
                cnt+=1
    if sum(tmp_board[9])==0: # 앞에까지는 다 끄면서 내려왔으므로 마지막줄만 검사
       res=min(res, cnt)

* 이후 다른사람들의 풀이가 궁금해서 검색해봤는데 비트마스킹으로 풀었다. 중복순열로 푼 내 풀이가 미세하게 속도가 빨랐다. 코드를 읽어봤는데 전공때 배운 비트마스킹이 이런식으로도 사용될수 있구나 싶어서 감탄했다... 자세한 설명은 임얼쑤에게 들어야지