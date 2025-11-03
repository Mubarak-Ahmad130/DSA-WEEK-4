import java.util.Scanner;

    static class Node {
        int value;
        Node next;
        Node prev;

        Node(int data) {
            this.value = data;
            this.next = null;
            this.prev = null;
        }
    }

     static class Linkedlist {
        Node head;
        Node tail;

        void display() {
            Node temp = head;
            while (temp != null) {
                System.out.println(temp.value);
                temp = temp.next;
            }
        }

        void insertbegin(int val) {
            Node temp = new Node(val);
            if (head == null) {
                head = tail = temp;
            } else {
                temp.next = head;
                head.prev = temp;
                head = temp;
            }
        }

        void insertpos(int val, int pos) {
            Node temp = new Node(val);
            if (head == null) {
                head = tail = temp;
                return;
            }
            if (pos == 1) {
                insertbegin(val);
                return;
            }

            Node t = head;
            for (int i = 1; i < pos - 1 && t.next != null; i++) {
                t = t.next;
            }

            temp.next = t.next;
            temp.prev = t;

            if (t.next != null)
                t.next.prev = temp;
            else
                tail = temp; // if inserted at end

            t.next = temp;
        }

        void insertend(int val) {
            Node temp = new Node(val);
            if (head == null) {
                head = tail = temp;
            } else {
                tail.next = temp;
                temp.prev = tail;
                tail = temp;
            }
        }

        void deleteAtbegin() {
            if (head == null)
                return;
            if (head.next == null) {
                head = tail = null;
            } else {
                head = head.next;
                head.prev = null;
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
            for (int i = 1; i < pos && temp != null; i++) {
                temp = temp.next;
            }

            if (temp == null)
                return;

            if (temp.next != null)
                temp.next.prev = temp.prev;
            else
                tail = temp.prev; // if deleting last node

            if (temp.prev != null)
                temp.prev.next = temp.next;
        }

        void deleteEnd() {
            if (head == null)
                return;
            if (head.next == null) {
                head = tail = null;
                return;
            }
            tail = tail.prev;
            tail.next = null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Linkedlist list = new Linkedlist();
        int c = 0;
        while (true) {
            System.out.println("----MENU FOR DOUBLY LINKED LIST----");
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

