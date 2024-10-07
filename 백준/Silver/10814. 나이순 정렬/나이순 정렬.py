n = int(input())
member = []
for i in range (n):
    age, name = input().split()
    age = int(age)
    member.append((age, name, i))

member.sort(key = lambda x : (x[0], x[2]))

for age, name, idx in member:
    print(age, name)