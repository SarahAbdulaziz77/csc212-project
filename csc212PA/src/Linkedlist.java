
public class LinkedList<T> {
	private Node<T> head;
    private Node<T> current;

    public LinkedList() {
        head=current=null;
    }
    public boolean isEmpty(){
        return head==null;
    }
    public void FindFirst(){
        current = head;
    }
    public void FindNext(){
        current=current.next;
    }
    public void update(T d){
        current.data=d;

    }
    public T Retrieve(){
        return current.data;
    }
    public boolean Full(){
        return false;
    }
    public boolean last() {
    	return current.next==null;
    }
    public void insert(T d) {
    	Node<T> p=new Node<T>(d);
    	if(head==null) {
    		head=p;
    		current=p;
    	}
    	else {
    		p.next=current.next;
    	    current.next=p;
    	    current=p;
    	}
    }
    public void Remove() {
    	if(current==head) {
    		head=head.next;
    		current=current.next;
    	}
    	else {
    		Node<T>p=head;
    		while(p.next!=current) {
    			p=p.next;
    		}
    	  p.next=current.next;
    	  if(current.next!=null)
    		  current=current.next;
    	  else 
    		  current=head;
    	  }
    	}
   public void AddInOrder(T new_contact) {
    Node<T> c = new Node<T>(new_contact);
    Node<T> p = head;
    Node<T> q = null;

    // If the list is empty
    if (head == null) {
        head = current = c;
        return;
    }

    // If the new contact should be at first
    if (((Contact) new_contact).compareTo(((Contact) head.data).getName()) < 0) {
        c.next = head;
        head = c;
        return;
    }

    // Find the suitable position to insert the new contact
    while (p != null && ((Contact) new_contact).compareTo(((Contact) p.data).getName()) >= 0) {
        q = p;
        p = p.next;
    }

    // Insert the new contact at the appropriate position
    q.next = c;
    c.next = p;
   }


}
