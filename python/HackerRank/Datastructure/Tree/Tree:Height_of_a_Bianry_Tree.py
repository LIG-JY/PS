max_ = list()       
def dfs(root, height):
    if not root:
        max_.append(height - 1)
    else:
        dfs(root.left, height+1)
        dfs(root.right, height+1)
def height(root):
    dfs(root, 0)
    return max(max_)
