import java.util.*;

public class Bai10 {
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

    public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {
        // Write your code here
        //C1
        /*int sizeOfList = 0;
        for (SinglyLinkedListNode node = llist; node != null; node=node.next) {
            sizeOfList++;
        }
        int po = sizeOfList - 1 - positionFromTail;
        int i = 0;
        SinglyLinkedListNode temp = llist;
        while (i < po) {
            i++;
            temp = temp.next;
        }
        return temp.data;*/
        //C2
        SinglyLinkedListNode temp = llist;
        for (int i = 0; llist.next != null; i++) {
            llist = llist.next;
            if ( i >= positionFromTail) {
                temp = temp.next;
            }
        }
        return temp.data;
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


        System.out.println(getNode(llist.head, 5));

        scanner.close();
    }

}
