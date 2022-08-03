import sys
sys.stdin=open("input.txt", "rt")
input=sys.stdin.readline

n=int(input())
class Node:
    def __init__(self, val, lt, rt):
        self.val=val
        self.lt=lt
        self.rt=rt

def preorder(n):
    print(n.val, end='')
    if n.lt!='.':
        preorder(tree[n.lt])
    if n.rt!='.':
        preorder(tree[n.rt])

def inorder(n):
    if n.lt!='.':
        inorder(tree[n.lt])
    print(n.val, end='')
    if n.rt!='.':
        inorder(tree[n.rt])

def postorder(n):
    if n.lt!='.':
        postorder(tree[n.lt])
    if n.rt!='.':
        postorder(tree[n.rt])
    print(n.val, end='')
tree=dict()
for _ in range(n):
    pt, lt, rt = input().split()
    tree[pt] = Node(val=pt, lt=lt, rt=rt)
preorder(tree['A'])
print()
inorder(tree['A'])
print()
postorder(tree['A'])