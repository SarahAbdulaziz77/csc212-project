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
    
    private boolean checkByTraverseInOrder(BSTNode<Contact> p, String phone_number) {
        if (p == null) return true;
        checkByTraverseInOrder(p.left, phone_number);
        if (p.key.equals(phone_number)) {
            return false;
        }
        return checkByTraverseInOrder(p.right, phone_number);
    }

    public boolean checkByTraverseInOrder(String phone_number) {
        return checkByTraverseInOrder(root, phone_number);
    }

    public boolean insert(String key, Contact val) {
    	//adds a contact but make sure its unique by name and phone_number
        if (empty()) {
            current=root=new BSTNode<Contact>(key,val);
            return true;
        }
        //if number exist?
        if(checkByTraverseInOrder(val.getPhoneNumber()) ){
        	return false; 
        }
        //if name exist?
        if(findkey(key)) {
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
    			}
    			
    			//case2-3:one child on left or right..or none..we want to connect the child of p with p parent to remove p
    			//update p to the child of node that we want to delete
    			if(p.left!=null) {
    				p=p.left;
    			}
    			else {
    				p=p.right;	
    			}
    			//if it was root
    			if(q==null) { 
    			root=p;
    			//root here will only have one child cause we covered the case of two
    			}
    			else {
    			//connect the parent q of node we want to delete..in two cases(if it has one child or none)
    				if(n.compareToIgnoreCase(q.key)<0) {
    					q.left=p;
    				}
    				else {
    					q.right=p;
    				}
    			}
    			current=root;
    			return true;
    		}//what
    	}//what
    	return false;//not found
    }//what
    		

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


    }

