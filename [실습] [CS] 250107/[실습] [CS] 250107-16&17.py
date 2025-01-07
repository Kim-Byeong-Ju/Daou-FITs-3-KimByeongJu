class DNode:
    def __init__(self, data):
        self.data = data  # 노드의 데이터
        self.next = None  # 다음 노드를 가리키는 참조
        self.prev = None  # 이전 노드를 가리키는 참조

class DoublyLinkedList:
    def __init__(self):
        self.head = None  # 리스트의 처음을 가리키는 head
        self.tail = None  # 리스트의 끝을 가리키는 tail

    def append(self, data):
        new_node = DNode(data)
        if not self.head:  # 리스트가 비어있다면 새로운 노드가 head와 tail
            self.head = self.tail = new_node
            return
        self.tail.next = new_node  # 기존의 tail의 다음 노드는 새 노드
        new_node.prev = self.tail  # 새 노드의 이전 노드는 기존의 tail
        self.tail = new_node  # 새 노드를 tail로 갱신


    def prepend(self, data):
        new_node = DNode(data)
        if not self.head:  # 리스트가 비어있다면 새로운 노드가 head와 tail
            self.head = self.tail = new_node
            return
        new_node.next = self.head  # 새 노드의 다음 노드는 기존의 head
        self.head.prev = new_node  # 기존 head의 이전 노드는 새 노드
        self.head = new_node  # 새 노드를 head로 갱신

    def delete(self, data):
        temp = self.head
        while temp:  # 리스트에서 데이터를 찾을 때까지 순차 탐색
            if temp.data == data:
                if temp.prev:  # 삭제하려는 노드가 중간에 있을 경우
                    temp.prev.next = temp.next
                if temp.next:  # 삭제하려는 노드가 중간에 있을 경우
                    temp.next.prev = temp.prev
                if temp == self.head:  # 삭제하려는 노드가 head인 경우
                    self.head = temp.next
                if temp == self.tail:  # 삭제하려는 노드가 tail인 경우
                    self.tail = temp.prev
                temp = None
                return
            temp = temp.next

    def display(self):
        temp = self.head
        while temp:
            print(temp.data, end=" <-> ")
            temp = temp.next
        print("None")

# 사용 예시
dll = DoublyLinkedList()
dll.append(1)
dll.append(2)
dll.append(3)
dll.prepend(0)
dll.display()  # 0 <-> 1 <-> 2 <-> 3 <-> None
dll.delete(2)
dll.display()  # 0 <-> 1 <-> 3 <-> None
