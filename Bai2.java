import java.util.*;

public class Bai2 {
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

    //Ham chen vao cuoi dslk
    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        //Dung vong lap
        SinglyLinkedListNode temp = head;
        SinglyLinkedListNode node = new SinglyLinkedListNode(data);
        if(temp == null){
            head = node;
            return head;
        }
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
        node.next = null;
        return head;

        //Dung de quy
        /*SinglyLinkedListNode temp = new SinglyLinkedListNode(data);
        if (head == null) return temp;
        else {
            if (head.next == null){
                head.next = temp;
            }
            else  insertNodeAtTail(head.next, data);
        }
        return  head;*/
    }

    static void printLinkedList(SinglyLinkedListNode head) {
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }

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

        insertNodeAtTail(llist.head, 6);
        // Chen vao cuoi danh sach phan tu 6
        printLinkedList(llist.head);

        scanner.close();
    }
}
