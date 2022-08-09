def insertNodeAtPosition(llist, data, position):
    loc = 0
    current = llist  #Node
    while loc < position-1:
        current = current.next
        loc += 1
    nextNode = current.next  #Node
    current.next = SinglyLinkedListNode(data)
    current.next.next = nextNode
    return llist
