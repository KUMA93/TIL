# 내장함수

> * [sum()](#sum)</br>
> * [min(), max()](#min-max)</br>
> * [eval()](#eval)</br>
> * [sorted(), sort()](#sorted-sort)</br>
> * [순열과 조합](#순열과-조합)</br>
> * [중복 순열과 중복 조합](#중복순열과-중복조합)</br>
> * [heapq - heap기능](#heapq---heap기능)</br>

## **sum()**
* 리스트와 같은 iterable 객체의 모든 원소의 합 반환
  ```python
  res=sum(1,2,3,4)
  print(res)
  # 출력: 10
  # ==========================================================
  lst=[1,2,3,'KUMA',4,5]
  res=sum(lst)
  print(res)
  # 출력: 숫자가 아닌 값이 있기 때문에 error
  # ==========================================================
  lst=[]
  tup=()
  res=sum(lst)
  print(res)
  # 출력: 0
  res=sum(tup)
  # 출력: 0
  ```
</br>

## **min(), max()** 
* 파라미터가 2개 이상 들어 왔을 때 가장 작은/큰 값을 반환
  ```python
  res=min(6,8,4,2)
  print(res)
  # 출력: 2
  res=max(6,8,4,2)
  print(res)
  # 출력: 8
  ```
</br>

## **eval()**
* 문자열 형태의 수식 계산 결과 반환
  ```python
  res=eval("(2+5)*3")
  print(res)
  # 출력: 21
  ```
  > 오류를 발생시킬 위험이 높은 함수이므로 잘써야 한다.   

</br>

## **sorted(), sort()**
* iterable 객체를 받아서 정렬된 결과를 반환
  ```python
  res=sorted([3,9,6,8]) #기본은 오름차순
  print(res)
  # 출력: [3,6,8,9]
  res=sorted([3,9,6,8], reverse=True) #내림차순
  print(res)
  # 출력: [9,8,6,3]
  # ==========================================================
  numbers=[1,4,2,9]
  numbers.sort()
  print(numbers)
  # 출력: [1,2,4,9]
  numbers.sort(reverse=True)
  print(numbers)
  # 출력: [9,4,2,1]
  ```
</br>
 
## **순열과 조합** 
* 기본적으로 파이썬에서 제공하는 함수를 이용해 손쉽게 순열과 조합을 구할 수 있지만 연습 과정에서는 직접 구해본다.
* **Permutations(arr, r)**: len(arr)가 n일 때 nPr의 모든 결과를 불러온다
* **combinations(arr, r)**: len(arr)가 n일 때 nCr의 모든 결과를 불러온다

  ```python
  #Permutations
  from itertools import permutations
  data=['최', '규', '헌']
  res=list(permutations(data, 3))
  print(res)
  ```
  ```
  [('최', '규', '헌'), ('최', '헌', '규'), ('규', '최', '헌'), ('규', '헌', '최'), ('헌', '최', '규'), ('헌', '규', '최')]
  ```
  ```python
  #combinations
  from itertools import combinations
  data=['최', '규', '헌']
  res=list(combinations(data, 3))
  print(res)
  ```
  ```
  [('최', '규', '헌')]
  ```
  ```python
  res=list(combinations(data, 2))
  print(res)
  ```
  ```
  [('최', '규'), ('최', '헌'), ('규', '헌')]
  ```
</br>

## **중복순열과 중복조합**
* **product(arr, reapeat=r)**: len(arr)가 n일 때 nπr의 모든 결과를 불러온다
  > permutations에서 원소를 중복하여 repeat 속성값으로 준 만큼 데이터를 뽑는다.   
* **combinations_with_replacement(arr, r)**: len(arr)가 n일 때 nHr의 모든 결과를 불러온다
  > combinations에서 원소를 중복하여 r만큼 데이터를 뽑는다.

  ```python
  #product
  from itertools import combinations
  data=['최', '규', '헌']
  res=list(product(data, repeat=3))
  print(res)
  ```
  ```
  [('최', '최'), ('최', '규'), ('최', '헌'), ('규', '최'), ('규', '규'), ('규', '헌'), ('헌', '최'), ('헌', '규'), ('헌', '헌')]    
  ```

  ```python
  #combinations_w_r
  from itertools import combinations_with_replacement
  data=['최', '규', '헌']
  res=list(combinations_with_replacement(data, 2))
  print(res)
  ```
  ```
  [('최', '최'), ('최', '규'), ('최', '헌'), ('규', '규'), ('규', '헌'), ('헌', '헌')]
  ```
</br>

## **heapq - heap기능**
* 최댓값과 최솟값을 찾는 연산을 빠르게 하기 위해 고안된 완전이진트리를 기본으로 한다.
* **heapq.heappush(heap, item)** -item을 heap에 삽입 
* **heapq.heappop(heap)** -힙에서 가장 작은 원소를 pop&리턴
* **heapq.heapify(list)** -list를 heap으로 변환한다, (O(N))
  ```python
  import heapq
  heap=[]
  heapq.heappush(heap, 44)
  heapq.heappush(heap, 22)
  heapq.heappush(heap, 33)
  print(heap)
  ```
  ```
  [22, 44, 33]
  ```
  ```python
  print(heapq.heappop(heap))
  print(heapq.heappop(heap))
  print(heapq.heappop(heap))
  ```
  ```
  22
  33
  44
  ```
  ```python
  data=[11, 33, 66]
  heapq.heapify(data)
  heapq.heappush(data, 22)
  print(data)
  print(heapq.heappop(data))
  ```
  ```
  [11, 22, 66, 33]
  11
  ```
