import java.util.*;

public class Bai3 {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }
    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    //Ham in danh sach lien ket
    static void printLinkedList(SinglyLinkedListNode head) {
        if (head == null) return;
        System.out.println(head.data);
        printLinkedList(head.next);
    }

    //Chen vao dau danh sach lien ket
    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode node_1 = new SinglyLinkedListNode(data);
        if (head == null){
            head = node_1;
            node_1.next = null;
            return head;
        }
        node_1.next = head;
        head = node_1;
        return head;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SinglyLinkedList llist = new SinglyLinkedList();

        int llistCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < llistCount; i++) {
            int llistItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            llist.insertNode(llistItem);
        }

        llist.head = insertNodeAtHead(llist.head, 7);
        //Chen 7 vao dau danh sach
        printLinkedList(llist.head);

        scanner.close();
    }

}
