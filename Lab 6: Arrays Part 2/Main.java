class Main {
  public static void main(String[] args) {
    int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    int[] b = null;
    int[] c = a;
    int[] d = null;
    int[] e = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    System.out.println(equalityType(a, e));
    System.out.println(arrayToString(subArray(a, 2, 7)));
  }
  public static int safeLength(int[] a){
    if(a==null)
      return -1;
    else
      return a.length;
  }
  public static boolean equals(int[] a, int[] b){
    boolean rv = true;
    if(a==null&&b==null)
      return true;
    else if(a==null&&b!=null||a!=null&&b==null)
      return false;
    else if(a.length!=b.length)
      return false;
    else{
      for(int i=0;i<a.length;i++){
        if(a[i]!=b[i]){
          rv = false;
        }
        rv = true && rv;
      }
      return rv;
    }
  }
  public static String equalityType(int[] a, int[] b){
  boolean rv = true;
  if(a==b)
    return "==";
  else if(a==null&&b!=null||a!=null&&b==null)
    rv = false;
  else if(a.length!=b.length)
    rv =  false;
  else{
    for(int i=0;i<a.length;i++){
      if(a[i]!=b[i]){
        rv = false;
       }
       rv = true && rv;
     }
   }
  if(rv)
    return "equals";
  else
    return "not equal";
  }
  public static int[] append(int[] a, int[] b){
   int append[] = new int[a.length+b.length];
   for(int i=0;i<a.length;i++)
     append[i] = a[i];
   for(int k=0;k<b.length; k++)
     append[a.length+k] = b[k];
   return append;
 }
 public static String arrayToString(int[] a){
   String rv = "{";
   for(int i=0; i<a.length; i++){
     if(i == a.length-1)
       rv += a[i] + "}";
     else
       rv += a[i] + ", ";
   }
   return rv;
 }
  public static int getIndex(int[] a, int index){
    if(index<0)
      return a[a.length+index];
    else
      return a[index];
  }
  public static int[] subArray(int[] a, int start, int end){
    int[] rv = new int[end-start];
    int count = 0;
    for(int i=start;i<end;i++){
      rv[count] = a[i];
      count++;
    }
    return rv;
  }
}
