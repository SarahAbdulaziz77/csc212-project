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
    if (((Contact) new_contact).compareTo(((Contact) head.data).getFullName()) < 0) {
        c.next = head;
        head = c;
        return;
    }

    // Find the suitable position to insert the new contact
    while (p != null && ((Contact) new_contact).compareTo(((Contact) p.data).getFullName()) >= 0) {
        q = p;
        p = p.next;
    }

    // Insert the new contact at the appropriate position
    q.next = c;
    c.next = p;
   }
   
   
   
   public boolean deleteContact(String nameOrNumber) {
	   //if the list is empty
	   if (head == null) 
		   return false;
	   
	   //if there is one element in the list
	   if (head.next == null) { 
		     if (((Contact)head.data).getFullName().equals(nameOrNumber) || ((Contact)head.data).getNumber().equals(nameOrNumber)) {
		     head = head.next; //or head = null;
	    	 current = head;
	    	 return true;
	    	 }
		     else
		      return false;  
		    }
	   
	   
	   // if the contact is in head, and there are more than 1 element in the list
	   if (((Contact)head.data).getFullName().equals(nameOrNumber) || ((Contact)head.data).getNumber().equals(nameOrNumber)) {
	    	 head = head.next; 
	    	 current = head;
	    	 return true;
	    	  } 
	          else {
	    		 
	   
	   Node<T> p = head.next;
	   Node<T> q = head;
	   
	   // checking the rest of the list, except for head (already checked)
	   while(p.next!= null) {
		   if (((Contact)p.data).getFullName().equals(nameOrNumber) || ((Contact)p.data).getNumber().equals(nameOrNumber)) {
			   q.next = p.next;
			   current = p.next;
			   return true;
		   }
			   
		   else {
			   p = p.next;
			   q = q.next;
		   }
	   }//while stops here
		
	       // checking the last element in the list
		   if (((Contact)p.data).getFullName().equals(nameOrNumber) || ((Contact)p.data).getNumber().equals(nameOrNumber)) {
			   q = q.next; //or q.next = null;
			   current = head;
			   return true;
		   }
		  
	   }
	   //all cases have been checked 
	   return false;
   }
	   
   
 
}
