
public class Linkedlist<T> {
	private Node <T> Head;
    private Node<T>  current;
    public Linkedlist() {
        Head=current=null;
    }
    public boolean isEmpty(){
        return Head==null;
    }
    public void FindFirst(){
        current = Head;
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
    public boolean ifFull(){
        return false;
    }
   

}
