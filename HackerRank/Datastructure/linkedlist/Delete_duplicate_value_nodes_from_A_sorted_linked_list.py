###
https://www.hackerrank.com/challenges/delete-duplicate-value-nodes-from-a-sorted-linked-list/problem?isFullScreen=true
###

def removeDuplicates(llist):
    start = llist
    temp = llist
    while llist.next:
        if llist.data > temp.data:
            temp.next = llist
            temp = llist
        llist = llist.next
    if llist.data == temp.data:
        temp.next = None
    else:
        temp.next = llist
    return start

