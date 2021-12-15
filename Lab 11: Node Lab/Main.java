class Main {
  public static void main(String[] args) {
    Node h = new Node();
    Node c = h;
    Node g = null;
    h.data = "C";
    h.next = new Node();//B node
    c = c.next;
    c.data = "C";
    c.next = new Node();
    c = c.next;
    c.data = "A";
    c.next = new Node();
    c = c.next;
    c.data = "C";
    task1();
    task2();
  }
  public static String nodeToString(Node h){
    if(h==null){
      return "null";
    }
    String rv = "";
    while(h.next != null){
      rv += "[" + h.data + ", =>] ";
      h = h.next;
    }
    rv+= "[" + h.data + ", null]";
    return rv;
  }
  public static String get(Node h, int n){
    if(h==null)
      return "null";
    String rv = "";
    for(int i=0; i<=n;i++){
      if(h==null)
        return "null";
      rv = h.data;
      h = h.next;
    }
    return rv;
  }
  public static Node add(Node h, String s){
    Node c = h;
    if(c == null){
      c = new Node();
      c.data = s;
      return c;
    }
    while(c.next!=null){
      c = c.next;
    }
    c.next = new Node();
    c.next.data = s;
    return h;
  }
  public static Node add1(Node h, String s, int n){
    Node c = h;
    if(c == null){
      c = new Node();
      c.data = s;
      return h;
    }
    if(n==0){
      Node store = h;
      h = new Node();
      h.next = store;
      h.data = s;
      return h;
    }
    for(int i=0; i<n-1;i++){
      c = c.next;
    }
    Node store = c.next;
    c.next = new Node();
    c.next.data = s;
    c.next.next = store;
    return h;
  }
  public static Node remove(Node h, int index){
    Node c = h;
    if(h.next==null)
      return null;
    if(index==0){
      h = h.next;
      return h;
    }
    for(int i=0; i<index-1;i++){
      c = c.next;
    }
    c.next = c.next.next;
    return h;
  }
  public static void task1(){
    Node h = null;
    for(int i=1;i<=100;i++)
      h = add(h, i + "");
    System.out.println(nodeToString(h));
    for(int i=99;i>=3;i-=4){
      h=remove(h, i);
    }
    System.out.println(nodeToString(h));
  }
  public static void task2(){
    Node fib = new Node();
    fib.data = "1";
    int num = 1;
    int add = 1;
    int store = 1;
    for(int i=0; i<19;i++){
      fib = add(fib, num + "");
      store = num;
      num += add;
      add = store;
    }
    System.out.println(nodeToString(fib));
  }
  public static Node reverse(Node h){
    Node rv = h;
    h = h.next;
    rv.next = null;
    Node c;
    while(h!=null){
      c = h.next;
      h.next = rv;
      rv = h;
      h = c;
    }
    return rv;
  }
  public static Node remove1(Node h, String data){
    Node c = h;
    int index = 0;;
    while(c!=null){
      c = c.next;
      index++;
    }
    index-=1;
    for(int i= index;i>=0;i--){
      if(get(h,i)==data)
        h = remove(h, i);
    }
    return h;
  }

}