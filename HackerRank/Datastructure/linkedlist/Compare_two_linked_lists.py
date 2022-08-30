https://www.hackerrank.com/challenges/compare-two-linked-lists/problem?isFullScreen=true
# Compare two linekd lists

def compare_lists(llist1, llist2):
    while (llist1.next is not None) and (llist2.next is not None):
        if llist1.data == llist2.data:
            llist1, llist2 = llist1.next, llist2.next
        else:
            return 0
    if (llist1.next is not None) or (llist2.next is not None):
        return 0
    return 1
