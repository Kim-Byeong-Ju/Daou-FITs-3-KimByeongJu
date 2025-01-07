# 실습과제 14번

class Node:
    def __init__(self, data):
        self.data = data  # 노드의 데이터
        self.next = None  # 다음 노드를 가리키는 참조

class SinglyLinkedList:
    def __init__(self):
        self.head = None  # 리스트의 처음은 None으로 시작

    def append(self, data):
        new_node = Node(data)
        if not self.head:  # 리스트가 비어있다면 새로운 노드를 첫 번째 노드로 설정
            self.head = new_node
            return
        last = self.head
        while last.next:  # 마지막 노드를 찾음
            last = last.next
        last.next = new_node  # 마지막 노드의 다음 노드로 새 노드를 연결

    def prepend(self, data):
        new_node = Node(data)
        new_node.next = self.head  # 새 노드는 현재 head를 가리킴
        self.head = new_node  # head를 새 노드로 갱신

    def delete(self, data):
        temp = self.head
        if temp and temp.data == data:  # 첫 번째 노드가 삭제할 노드인 경우
            self.head = temp.next
            temp = None
            return

        prev = None
        while temp and temp.data != data:  # 삭제할 노드를 찾음
            prev = temp
            temp = temp.next

        if temp is None:  # 해당 값이 리스트에 없으면 반환
            return

        prev.next = temp.next  # 이전 노드가 현재 노드의 다음 노드를 가리키게 함
        temp = None
    def display(self):
        temp = self.head
        while temp:
            print(temp.data, end=" -> ")
            temp = temp.next
        print("None")


sll = SinglyLinkedList()
sll.append(1)
sll.append(2)
sll.append(3)
sll.prepend(0)
sll.display()
sll.delete(2)
sll.display()
