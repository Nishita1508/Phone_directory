
class CallHistoryNode {
    Contact contact;
    CallHistoryNode next;

    public CallHistoryNode(Contact contact) {
        this.contact = contact;
        this.next = null;
    }
}

public class CallHistoryStack {
    private CallHistoryNode top;

    public CallHistoryStack() {
        top = null;
    }

    public void push(Contact contact) {
        CallHistoryNode newNode = new CallHistoryNode(contact);
        newNode.next = top;
        top = newNode;
    }

    public void pop(String name) {
        if (top == null) {
            System.out.println("No history");
        } else {
            Contact deletedContact = top.contact;
            top = top.next;
            System.out.println(deletedContact.getName() + " = " + deletedContact.getPhoneNumber() + " is deleted");
        }
    }

    public void clearHistory() {
        top = null;
        System.out.println("Call history cleared.");
    }

    public void displayCallHistory() {
        if (top == null) {
            System.out.println("No history");
        } else {
            CallHistoryNode current = top;
            while (current != null) {
                Contact call = current.contact;
                System.out.println(call.getName() + " = " + call.getPhoneNumber());
                current = current.next;
            }
        }
    }
    public void updateCallHistoryStack(String phoneNumber, String newName) {
    CallHistoryNode current = top;
    while (current != null) {
        if (current.contact.getPhoneNumber().equals(phoneNumber)) {
            current.contact.setName(newName);
            break;
        }
        current = current.next;
    }
}

}
