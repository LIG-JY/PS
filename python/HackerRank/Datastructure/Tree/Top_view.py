class Node:
    def __init__(self, info): 
        self.info = info  
        self.left = None  
        self.right = None 
        self.level = None 

    def __str__(self):
        return str(self.info) 

class BinarySearchTree:
    def __init__(self): 
        self.root = None

    def create(self, val):  
        if self.root == None:
            self.root = Node(val)
        else:
            current = self.root
         
            while True:
                if val < current.info:
                    if current.left:
                        current = current.left
                    else:
                        current.left = Node(val)
                        break
                elif val > current.info:
                    if current.right:
                        current = current.right
                    else:
                        current.right = Node(val)
                        break
                else:
                    break

"""
Node is defined as
self.left (the left child of the node)
self.right (the right child of the node)
self.info (the value of the node)
"""

def traversal(root, depth, count, temp):
    if root is None:
        return
    if depth not in temp:
        temp[depth] = [root.info, count]
    if count < temp[depth][1]:
        temp[depth] = [root.info, count]
    traversal(root.right, depth + 1, count + 1, temp)
    traversal(root.left, depth - 1, count + 1, temp)

def topView(root):
    temp = dict()
    traversal(root, 0, 0, temp)
    ans = sorted(temp.items() key = lambda x: x[0])
    for i in ans:
        print(i[1][0], end = ' ') 



tree = BinarySearchTree()
t = int(input())

arr = list(map(int, input().split()))

for i in range(t):
    tree.create(arr[i])

topView(tree.root)
