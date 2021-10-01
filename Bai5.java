import java.util.*;

public class Bai5 {
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

    //Xoa phan tu o vi tri bat ki
    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
        /*if (head == null){
            return null;
        }
        if ( position == 0){
            return head.next;
        }
        SinglyLinkedListNode temp = head;
        SinglyLinkedListNode pre_temp = null;
        int count = 0;
        while (count < position){
            pre_temp = temp;
            temp = temp.next;
            count++;
        }
        pre_temp.next = temp.next;
        return head;*/
        //dung de quy
        if (head == null) return null;
        if (position == 0){
            return head.next;
        }
        head.next = deleteNode(head.next, position-1);
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

        llist.head = deleteNode(llist.head, 3);
        //Xoa phan tu o vi tri so 3
        printLinkedList(llist.head);

        scanner.close();
    }

}
