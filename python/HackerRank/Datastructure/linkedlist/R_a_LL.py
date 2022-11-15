https://www.hackerrank.com/challenges/reverse-a-linked-list/problem?isFullScreen=true

def reverse(llist):
    if llist is None:
        return None
    elif llist.next is None:
        return llist
    else:
        prev = None
        current = llist
        next_ = llist.next
        while next_ is not None:
            current.next = prev
            prev = current
            current = next_
            next_ = next_.next
        current.next = prev
        return current
