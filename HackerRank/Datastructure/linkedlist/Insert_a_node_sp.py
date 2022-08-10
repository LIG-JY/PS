def insertNodeAtHead(llist, data):
    if llist is None:
        llist = SinglyLinkedListNode(data)
    else:
        current = llist
        llist = SinglyLinkedListNode(data)
        llist.next = current
    return llist
