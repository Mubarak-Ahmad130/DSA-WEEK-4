import java.util.Scanner;

    static class Node {
        int value;
        Node next;

        Node(int data) {
            this.value = data;
            this.next = null;
        }
    }

    public static class Linkedlist {
        Node head;
        Node tail;

        void display() {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }
            Node temp = head;
            do {
                System.out.println(temp.value);
                temp = temp.next;
            } while (temp != head);
        }

        void insertbegin(int val) {
            Node temp = new Node(val);
            if (head == null) {
                head = tail = temp;
                tail.next = head; // circular link
            } else {
                temp.next = head;
                head = temp;
                tail.next = head; // maintain circular link
            }
        }

        void insertpos(int val, int pos) {
            Node temp = new Node(val);
            if (head == null) {
                head = tail = temp;
                tail.next = head;
                return;
            }

            Node t = head;
            for (int i = 1; i < pos - 1 && t.next != head; i++) {
                t = t.next;
            }

            temp.next = t.next;
            t.next = temp;

            if (t == tail) // inserted at end
                tail = temp;

            tail.next = head; // circular link maintained
        }

        void insertend(int val) {
            Node temp = new Node(val);
            if (head == null) {
                head = tail = temp;
                tail.next = head;
            } else {
                tail.next = temp;
                tail = temp;
                tail.next = head;
            }
        }

        void deleteAtbegin() {
            if (head == null)
                return;
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
        }

        void deleteAnypos(int pos) {
            if (head == null)
                return;

            if (pos == 1) {
                deleteAtbegin();
                return;
            }

            Node temp = head;
            for (int i = 1; i < pos - 1 && temp.next != head; i++) {
                temp = temp.next;
            }

            Node del = temp.next;
            if (del == head)
                head = head.next;
            if (del == tail)
                tail = temp;

            temp.next = del.next;
            tail.next = head;
        }

        void deleteEnd() {
            if (head == null)
                return;
            if (head == tail) {
                head = tail = null;
                return;
            }

            Node temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = head;
            tail = temp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Linkedlist list = new Linkedlist();
        int c = 0;
        while (true) {
            System.out.println("----MENU FOR SINGLY CIRCULAR LINKED LIST----");
            System.out.println("enter [1] for traversal");
            System.out.println("enter [2] insert at beginning");
            System.out.println("enter [3] insert at any position");
            System.out.println("enter [4] insert at end");
            System.out.println("enter [5] delete at beginning");
            System.out.println("enter [6] delete at any position");
            System.out.println("enter [7] delete at end");
            System.out.println("enter [8] for exit");

            System.out.print("enter your choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    list.display();
                    break;
                case 2:
                    System.out.println("enter element");
                    int el = sc.nextInt();
                    list.insertbegin(el);
                    break;
                case 3:
                    System.out.println("enter position to add element");
                    int p = sc.nextInt();
                    System.out.println("enter element ");
                    int ele = sc.nextInt();
                    list.insertpos(ele, p);
                    break;
                case 4:
                    System.out.println("enter element");
                    int e = sc.nextInt();
                    list.insertend(e);
                    break;
                case 5:
                    list.deleteAtbegin();
                    list.display();
                    break;
                case 6:
                    System.out.println("enter position to delete element");
                    int pos = sc.nextInt();
                    list.deleteAnypos(pos);
                    list.display();
                    break;
                case 7:
                    list.deleteEnd();
                    list.display();
                    break;
                case 8:
                    System.out.println("exit");
                    c++;
                    break;
            }
            if (c != 0)
                break;
        }
        sc.close();
    }
