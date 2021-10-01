import java.util.*;

public class Bai9 {
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

    //Tron 2 danh sach lien ket
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        //Dung de quy
        /*
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        if (head1.data <= head2.data) {
            head1.next = mergeLists (head1.next, head2);
            return head1;
        }
        else{
            head2.next = mergeLists (head1, head2.next);
            return head2;
        }*/

        //Dung vong lap
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        SinglyLinkedListNode head3 = null;
        if (head1.data < head2.data) {
            head3 = head1;
            head1 = head1.next;
        } else {
            head3 = head2;
            head2 = head2.next;
        }

        SinglyLinkedListNode temp = head3;
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        if (head1 == null) {
            temp.next = head2;
        } else {
            temp.next = head1;
        }

        return head3;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SinglyLinkedList llist1 = new SinglyLinkedList();

        int llist1Count = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < llist1Count; i++) {
            int llist1Item = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            llist1.insertNode(llist1Item);
        }

        SinglyLinkedList llist2 = new SinglyLinkedList();
        int llist2Count = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < llist2Count; i++) {
            int llist2Item = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            llist2.insertNode(llist2Item);
        }

        SinglyLinkedListNode llist3 = mergeLists(llist1.head, llist2.head);
        printLinkedList(llist3);


        scanner.close();
    }

}
