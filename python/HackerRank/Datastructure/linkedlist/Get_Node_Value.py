###
https://www.hackerrank.com/challenges/get-the-value-of-the-node-at-a-specific-position-from-the-tail/problem?isFullScreen=true
###

def getNode(llist, positionFromTail):
    lenght = llist_count # global var
    while lenght - 1 > positionFromTail:
        llist = llist.next
        lenght -= 1
    return llist.data
