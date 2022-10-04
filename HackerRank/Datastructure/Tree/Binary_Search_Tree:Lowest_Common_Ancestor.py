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
 
# Enter your code here. Read input from STDIN. Print output to STDOUT
'''
class Node:
      def __init__(self,info): 
          self.info = info  
          self.left = None  
          self.right = None 
           

       // this is a node of the tree , which contains info as data, left , right
'''

from collections import deque

def lca(root, v1, v2):
    traversal_pt1 = root
    traversal_pt2 = root
    while traversal_pt1 == traversal_pt2:
        result = traversal_pt1
        compared_num1 = traversal_pt1.info
        compared_num2 = traversal_pt2.info
        if compared_num1 > v1:
            traversal_pt1 = traversal_pt1.left
        elif compared_num1< v1:
            traversal_pt1 = traversal_pt1.right
        if compared_num2 > v2:
            traversal_pt2 = traversal_pt2.left
        elif compared_num2< v2:
            traversal_pt2 = traversal_pt2.right
    return result
    
    

tree = BinarySearchTree()
t = int(input())

arr = list(map(int, input().split()))

for i in range(t):
    tree.create(arr[i])

v = list(map(int, input().split()))

ans = lca(tree.root, v[0], v[1])
print (ans.info)

