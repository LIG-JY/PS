def deleteNode(llist, position):
    if position == 0:
        llist = llist.next
    else:
        current = llist
        while position>0:
            prev = current
            current = current.next
            position -= 1
        prev.next = current.next
    return llist
