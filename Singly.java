import java.util.Scanner;
static class Node{
    int value;
    Node next;

    Node(int data){
        this.value=data;
        this.next=null;
    }
}

public static class Linkedlist {
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
            head = temp;
        }

    }

    void insertpos(int val, int pos) {
        Node temp = new Node(val);
        Node t = head;
        for (int i = 1; i < pos; i++) {
            t = t.next;
        }
        temp.next = t.next;
        t.next = temp;
    }

    void insertend(int val) {
        Node temp = new Node(val);
        if (head == null) {
            head = temp;
        } else
            tail.next = temp;
        tail = temp;
    }

    void deleteAtbegin() {
        head = head.next;
    }

    void deleteAnypos(int pos) {
        Node temp = null;
        for (int i = 1; i < pos; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        tail = temp;
    }

    void deleteEnd() {
        Node temp = head;
        if (temp == null)
            System.out.println("empty list");
        if (temp.next == null)
            temp = null;
        while (temp.next.next != null) {
            temp=temp.next;
        }
        temp.next=null;
    }
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Linkedlist list = new Linkedlist();
        int c=0;
        while(true) {
            System.out.println("----MENU FOR SINGLE LINKED LIST");
            System.out.println("enter [1] for traversal");
            System.out.println("enter [2] insert at biggining");
            System.out.println("enter [3] insert at any position");
            System.out.println("enter [4] insert at end");
            System.out.println("enter [5] delete at begginnig");
            System.out.println("enter [6] delete at any position");
            System.out.println("enter [7] delete at end");
            System.out.println("enter [8] for exit");

            System.out.println("enter your choice");
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
                    list.insertpos(p, ele);
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
            if(c!=0)
                break;
        }

    }
