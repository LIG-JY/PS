class Node:
    def __init__(self, info):
        self.info = info  
        self.left = None  
        self.right = None 
        self.level = None 

    def __str__(self):
        return str(self.info) 

def preOrder(root):
    if root == None:
        return
    print (root.info, end=" ")
    preOrder(root.left)
    preOrder(root.right)
    
class BinarySearchTree:
    def __init__(self): 
        self.root = None

#Node is defined as
#self.left (the left child of the node)
#self.right (the right child of the node)
#self.info (the value of the node)

    def insert(self, val):
        Node_ = Node(val)
        start = self.root
        if not start:
            self.root = Node_
        while start:
            if start.info > val:
                if start.left:
                    start = start.left
                else:
                    start.left = Node_
                    return
            else:
                if start.right:
                    start = start.right
                else:
                    start.right = Node_
                    return
                
            
            
        
            

tree = BinarySearchTree()
t = int(input())

arr = list(map(int, input().split()))

for i in range(t):
    tree.insert(arr[i])

preOrder(tree.root)

