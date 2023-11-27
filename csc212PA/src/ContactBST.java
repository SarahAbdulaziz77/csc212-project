public class ContactBST {
    private BSTNode root;
    private BSTNode current;
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
        BSTNode p = root;
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
    public boolean insert(String key , Contact val) {
        if (empty()) {
            current=root=new BSTNode(key,val);
            return true;
        }

        BSTNode p = current;
        if(findkey(key)) {
            current=p;
            return false;
        }

        BSTNode tmp = new BSTNode(key,val);
        if (key.compareToIgnoreCase(current.key)<0) {
            current.left=tmp;
        }
        else {
            current.right=tmp;

        }
        current=tmp;
        return true;


    }

    private void inOrder(BSTNode p){
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
        inOrder(root);
    }


    private void preOrder(BSTNode p){
        if(p==null) return;
        System.out.println("key : "+p.key );
        System.out.println(p.data.toString());
        inOrder(p.left);
        inOrder(p.right);


    }


    }

