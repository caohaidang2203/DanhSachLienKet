import java.util.*;

public class Bai4 {
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

    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        //DUng vong lap
        /*if (head == null) {
            return null;
        }
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        if (position == 0){
            newNode.next = head;
            head = newNode;
            return head;
        }
        SinglyLinkedListNode temp = head;
        SinglyLinkedListNode prev_temp = null;
        int count = 0;
        while (count < position){
            prev_temp = temp;
            temp = temp.next;
            count++;
        }
        prev_temp.next = newNode;
        newNode.next = temp;
        return head;*/

        //Dung de quy
        SinglyLinkedListNode temp = head;
        if (position == 0) {
            SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
            newNode.next = temp;
            return newNode;
        }
        temp.next = insertNodeAtPosition(head.next, data, position -1);
        return temp;

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

        llist.head = insertNodeAtPosition(llist.head, 7, 3);
        //Chen 7 vao vi tri thu 3 danh sach
        printLinkedList(llist.head);

        scanner.close();
    }

}
