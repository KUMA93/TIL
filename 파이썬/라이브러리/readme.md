# 내장함수
## **sum()**: 리스트와 같은 iterable 객체의 모든 원소의 합 반환
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

## **min(), max()**: 파라미터가 2개 이상 들어 왔을 때 가장 작은/큰 값을 반환
  ```python
  res=min(6,8,4,2)
  print(res)
  # 출력: 2
  res=max(6,8,4,2)
  print(res)
  # 출력: 8
  ```
</br>

## **eval()**: 문자열 형태의 수식 계산 결과 반환
  ```python
  res=eval("(2+5)*3")
  print(res)
  # 출력: 21
  ```
</br>

## **sorted(), sort()**: iterable 객체를 받아서 정렬된 결과를 반환
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

