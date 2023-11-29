public class ContactBST {
    private BSTNode<Contact> root;
    private BSTNode<Contact> current;
    public ContactBST(){
        current=root=null;
    }
    public void clear(){
        current = root = null;
    }
    public boolean empty(){
        return root == null;
}
    public boolean full(){
        return false;
    }
    public Contact retrieve(){
        return current.data;
    }

    public boolean findkey(String key) {
        if (empty())
            return false;
        BSTNode<Contact> p = root;
        while (p !=null) {
            current=p;
            if(key.compareToIgnoreCase(p.key)==0) {
                return true;
            }
            else if (key.compareToIgnoreCase(p.key)<0) {
                p=p.left;
            }
            else {
                p=p.right;
            }

        }
        return false;

    }
    public Contact getContact(String key) {
        if (empty())
            return null;
        
        BSTNode<Contact> p = root;
        while (p !=null) {
            current=p;
            if(key.compareToIgnoreCase(p.key)==0)
                return p.data;
            else if (key.compareToIgnoreCase(p.key)<0)
                p=p.left;
            else
                p=p.right;
        }
        return null;
    }
    
    public boolean hasPhoneNumber(String phoneNumber) {
    	if(root==null)
    		return false;
        return hasPhoneNumber(root, phoneNumber);
    }

    private boolean hasPhoneNumber(BSTNode<Contact> node, String phoneNumber) {
        if (node == null) {
            return false; // Base case: reached a leaf node, contact not found
        }
        // Traverse left
        if (hasPhoneNumber(node.left, phoneNumber)) {
            return true;
        }
        // Check current node's contact for the given phone number
        if (node.data.getPhoneNumber().equals(phoneNumber)) {
            return true; // Contact found
        }
        // Traverse right
        return hasPhoneNumber(node.right, phoneNumber);
    }

    public boolean insert(String key, Contact val) {
    	//adds a contact but make sure its unique by name and phone_number
        if (empty()) {
            current=root=new BSTNode<Contact>(key,val);
            return true;
        }
        //if number exist?
        if(hasPhoneNumber(val.getPhoneNumber()) ){
        	System.out.println("Contact with the specified number found!");
        	return false; 
        }
        //if name exist?
        if (findkey(val.getFullName())) {
            System.out.println("Contact with the specified name found!");
            return false;
        }
        
        BSTNode<Contact> p = root;
        BSTNode<Contact> q = root;
        //now we may add but look for suitable place
    	while( p!= null) {
    		q=p;
    		//its not going to equal cause we avoided that prev
    		if(key.compareToIgnoreCase(p.key)<0) 
    			p=p.left;
    		else if (key.compareToIgnoreCase(p.key)>0) 
    			p=p.right;
    	}
    	
        if (key.compareToIgnoreCase(current.key)<0) {
        	q.left= new BSTNode<Contact>(key,val);
            current=q.left;
            return true;
        }
        else {
        	q.right=new BSTNode<Contact>(key,val);
            current=q.right;
            return true;
        }
    }
    
    public boolean removeKey(String k) {
    //if empty
        if (root == null) {
        	System.out.println("The BST of contact is empty");
            return false;
        }
    //search for the name by key
    	String n=k;
    	BSTNode<Contact> p =root;
    	BSTNode<Contact> q =null; //parent of p
    	while( p!= null) {
    		if(n.compareToIgnoreCase(p.key)<0) {
    			q=p;
    			p=p.left;
    		}
    		else if (n.compareToIgnoreCase(p.key)>0) {
    			q=p;
    			p=p.right;
    		}
    		else {
    			//found the key n==p.key now delete where p is the key and q is his parent
    	    	//check three cases...
    			
    			//case 1:has two children
    			if(p.left!=null && p.right!=null) {
    		     	//find the min of right subtree :its found by one step on left then loop to last left node
    				BSTNode<Contact> min =p.right;
    				q=p;
    				while(min.left!=null) {
    					q=min;
    					min=min.left;
    				}
    			    //update the root of the subtree of p to the min then delete min
    				p.key=min.key;
    				p.data=min.data;
    				//now to delete the min old place by turning it one child case
    				n=min.key;
    				p=min;
    				//q is still parent of old min place
    		     	}//end case of two children
    			
    			//case2-3:one child on left or right..or none..we want to connect the child of p with p parent to remove p
    			//update p to the child of node that we want to delete
    			if(p.left!=null)
    				p=p.left;
    			else
    				p=p.right;	
    			//if it was root
    			if(q==null) 
    			root=p; //root here will only have one child cause we covered the case of two
    			else {
    			//connect the parent q of node we want to delete..in two cases(if it has one child or none)
    				if(n.compareToIgnoreCase(q.key)<0)
    					q.left=p;
    				else
    					q.right=p;
    			}
    			current=root; //after deleting set the current on root
    			return true;
    		}//end case where we found it and deleted it 
    	}//done searching all BST
    	return false;//not found
    }//end method
    		

    private void inOrder(BSTNode<Contact> p){
        if(p==null) return;
        inOrder(p.left);
        System.out.println("key : "+p.key );
        System.out.println(p.data.toString());
        inOrder(p.right);


    }

    public void inOrder(){
        if(root==null)
            System.out.println("empty tree");
        inOrder(root);


    }

    public void preOrder(){
        if(root==null)
            System.out.println("empty tree");
        preOrder(root);
    }


    private void preOrder(BSTNode<Contact> p){
        if(p==null) return;
        System.out.println("key : "+p.key );
        System.out.println(p.data.toString());
        inOrder(p.left);
        inOrder(p.right);


    }
public LinkedList<Contact> SearchByFirstName(String name){
        LinkedList<Contact> matching_contacts = new LinkedList<>(); // we will store the matching contacts in it
        if (root==null)
            return matching_contacts;
        SearchByFirstName(root,name,matching_contacts); // the private one
        return matching_contacts;
    }
    private void SearchByFirstName(BSTNode<Contact> p , String name, LinkedList<Contact> matching_contacts){
        if(p==null)
            return;
        SearchByFirstName(p.left,name,matching_contacts);
        String CurrentFullName= p.key;
        String getFirstName =  CurrentFullName.substring(0, CurrentFullName.indexOf(' ')); // to get only the first name
        if (getFirstName.equalsIgnoreCase(name)) {
            matching_contacts.insert(p.data); }
        SearchByFirstName(p.right,name,matching_contacts);
    }
    }
