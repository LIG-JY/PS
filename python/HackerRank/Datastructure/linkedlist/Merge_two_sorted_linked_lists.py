https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists/problem?isFullScreen=true

## Merge Two sorted linked lists

def mergeLists(head1, head2):
    answer = SinglyLinkedList()
    while head1 and head2:  # if either of them is False while statement stop
        if head1.data > head2.data:
            answer.insert_node(head2.data)
            head2 = head2.next
        else:
            answer.insert_node(head1.data)
            head1 = head1.next
    if head1 is None:  # llist1 is empty
        while head2:
            answer.insert_node(head2.data)
            head2 = head2.next
    elif head2 is None:  # llist2 is empty
        while head1:
            answer.insert_node(head1.data)
            head1 = head1.next
    return answer.head
