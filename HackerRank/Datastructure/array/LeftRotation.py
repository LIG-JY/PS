def rotateLeft(d, arr):
    idx = d
    if idx == len(arr) - 1:
        return [arr[idx]] +arr[:idx]
    else:
        return arr[idx:] + arr[:idx]
