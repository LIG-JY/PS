from collections import deque

def levelOrder(root):
    queue_ = deque()
    queue_.append(root)
    while queue_:
        target = queue_.popleft()
        print(target.info, end = ' ')
        if target.left:
            queue_.append(target.left)
        if target.right:
            queue_.append(target.right)
