class circularLL {
    static class Node {
        int data;
        Node next;
    }

    static Node addToEmpty(Node last, int data) {
        if (last != null) {
            return last;
        }
        Node newNode = new Node();
        newNode.data = data;
        last = newNode;
        newNode.next = last;
        return last;
    }

    static Node addFront(Node last, int data) {
        if (last == null) {
            return addToEmpty(last, data);
        }
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = last.next;
        last.next = newNode;
        return last;
    }

    static Node addEnd(Node last, int data) {
        if (last == null) {
            return addToEmpty(last, data);
        }
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = last.next;
        last.next = newNode;
        last = newNode;
        return last;
    }

    static Node addAfter(Node last, int data, int item) {
        if (last == null) {
            return null;
        }
        Node newNode, p;
        p = last.next;
        do {
            if (p.data == item) {
                newNode = new Node();
                newNode.data = data;
                newNode.next = p.next;
                p.next = newNode;
                if (p == last) {
                    last = newNode;
                }
                return last;
            }
            p = p.next;
        } while (p != last.next);
        System.out.println(item + " not found in the list");
        return last;
    }

    static Node deleteNode(Node last, int key) {
        if (last == null) {
            return null;
        }
        if (last.data == key && last.next == last) {
            last = null;
            return last;
        }
        Node temp = last;
        if (last.data == key) {
            while (temp.next != last) {
                temp = temp.next;
            }
            temp.next = last.next;
            last = temp.next;
        }
        while (temp.next != last && temp.next.data != key) {
            temp = temp.next;
        }
        if (temp.next.data == key) {
            Node d = temp.next;
            temp.next = d.next;
        }
        return last;
    }

    static void traverse(Node last) {
        if (last == null) {
            System.out.println("List is empty.");
            return;
        }
        Node current = last.next;
        System.out.print("Circular List: ");
        do {
            System.out.print(current.data);
            current = current.next;
            if (current != last.next) {
                System.out.print(" -> ");
            }
        } while (current != last.next);
        System.out.println(" -> (loops back to " + last.next.data + ")");
    }

    public static void main(String[] args) {
        Node last = null;
        last = addToEmpty(last, 6);
        last = addEnd(last, 8);
        last = addFront(last, 2);
        last = addAfter(last, 10, 2);

        System.out.println("Initial list:");
        traverse(last);

        last = deleteNode(last, 8);
        System.out.println("\nAfter deleting 8:");
        traverse(last);

        last = addEnd(last, 15);
        last = addFront(last, 1);
        last = addAfter(last, 20, 10);

        System.out.println("\nFinal list:");
        traverse(last);
    }
}