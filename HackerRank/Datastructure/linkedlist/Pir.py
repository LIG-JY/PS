def reversePrint(llist):
    if llist == None:
        return None
    else:
        temp = []
        while llist:
            temp.insert(0,llist.data)
            llist = llist.next
        for i in range(len(temp)):
            print(temp[i])

def ReversePrint(head):
    if head:
        ReversePrint(head.next)
        print(head.data)
# Recursion의 원리는 Stack입니다.
