"""
# Definition for a Node.
class Node:
    def __init__(self, x, next=None, random=None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution(object):
    def copyRandomList(self, head):
        if head is None:
            return None

        # Step 1: Create a new node after every original node
        current = head

        while current:
            newNode = Node(current.val)

            newNode.next = current.next
            current.next = newNode

            current = newNode.next

        # Step 2: Set random pointers of new nodes
        current = head

        while current:
            if current.random:
                current.next.random = current.random.next

            current = current.next.next

        # Step 3: Separate original list and copied list
        current = head
        newHead = head.next
        newCurr = newHead
        while current:
            current.next = newCurr.next
            current = current.next

            if current:
                newCurr.next = current.next
                newCurr = newCurr.next

        return newHead
        
        