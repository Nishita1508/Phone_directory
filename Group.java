
import java.util.Scanner;


class ContactNode {
    Contact contact;
    ContactNode next;

    public ContactNode(Contact contact) {
        this.contact = contact;
        this.next = null;
    }
}
class ContactLinkedList {
    ContactNode head;

    public void append(Contact contact) {
        ContactNode newNode = new ContactNode(contact);
        if (head == null) {
            head = newNode;
        } else {
            ContactNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void display() {
        ContactNode current = head;
        while (current != null) {
            System.out.println("Name: " + current.contact.getName() + ", Phone: " + current.contact.getPhoneNumber());
            current = current.next;
        }
    }
}

class Group {
    String groupName;
    ContactLinkedList contacts;

    Group()
    {
        
    }
    public Group(String groupName) {
        this.groupName = groupName;
        this.contacts = new ContactLinkedList();
    }
}

class GroupNode {
    Group group;
    GroupNode next;

    public GroupNode(Group group) {
        this.group = group;
        this.next = null;
    }
}
class GroupLinkedList {
    GroupNode head;

    public void append(Group group) {
        GroupNode newNode = new GroupNode(group);
        if (head == null) {
            head = newNode;
        } else {
            GroupNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
}

