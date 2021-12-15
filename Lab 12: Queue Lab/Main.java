
class Main {
  public static void main(String[] args) {
    String[] s = {"Hi", "Bye", "Kye", "Stye", "Rye"};
    Queue q = convert(s);
    enqueue(q, "3");      
  }
  public static void enqueue(Queue q, String s){
    if(q.data==null){
      q.data = new Node();
      q.data.data = s;
    }
    else{
      Node n = q.data;
      while(n.next!=null)
        n = n.next;
      n.next = new Node();
      n.next.data = s;
    }
  }
  public static String dequeue(Queue q){
    Node n = q.data;
    q.data = q.data.next;
    return n.data;
  }
  public static Queue convert(String[] s){
    Queue rv = new Queue();
    for(int i=0;i<s.length;i++)
      enqueue(rv , s[i]);
    return rv;
  }
  public static void circle(Queue q){
    Node n = q.data;
    while(n.next!=null)
      n = n.next;
    n.next = q.data;
    q.data = q.data.next;
    n.next.next = null;
  }
}