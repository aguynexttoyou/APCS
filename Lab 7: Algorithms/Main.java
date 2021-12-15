class Main {
  public static void main(String[] args) {
  testCode1();
  testCode2();
  testCode3();
  testCode4a();
  testCode4c();
  testCode5a();
  testCode5c();
  int[] a = {29, 232, 12, 2, 1,2, 4,12, 3, 4, 1, 2, 12,6, 4, 3, 2, 4, 5, 6, 7};
  selectionSort(a);
  for(int i=0;i<a.length; i++)
    System.out.println(a[i]);
  }
  public static int[] collate3(int[] a, int[] b, int[] c){
    if(a == null||b==null||c==null){
      int rv[] = null;
      return rv;
    }
    int rv[] = new int[a.length*3];
    int arrayInArray = 0;
    for(int i=0; i<rv.length;i+=3){
      rv[i] = a[arrayInArray];
      rv[i+1] = b[arrayInArray];
      rv[i+2] = c[arrayInArray];
      arrayInArray++;
    }
    return rv;
  }
  public static void testCode1(){
    int[] a = {1, 4, 7};
    int[] b = {2, 5, 8};
    int[] c = {3, 6, 9};
    int[] ans = collate3(a, b, c);
    int[] correct = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    boolean allElementsMatch = true;
    for(int i=0; i<correct.length; i++)
      allElementsMatch &= ans[i] == correct[i];
    if(allElementsMatch)
      System.out.println("Part 1 works!!!");
    else
      System.out.println("Part 1 back to the drawing board");
  }
  public static int[] collate2(int[] a, int[] b){
    if(a == null && b == null){
      int [] rv = null;
      return rv;
    }
    else if(a == null)
      return b;
    else if(b == null)
      return a;
    else{
      int rv[] = new int[a.length+b.length];
      int count = 0;
      for(int i=0;i<rv.length;i++){
        if(count<a.length && count<b.length){
          rv[i] = a[count];
          i++;
          rv[i] = b[count];
        }
        else if(count>=b.length)
          rv[i] = a[count];
        else if(count>=a.length)
          rv[i] = b[count];
        count++;
      }
      return rv;
    }
  }
  public static void testCode2(){
    int a[] = {1,2,3,4,5};
    int b[] = {6,7,8};
    int c[] = null;
    int d[] = {1, 2, 3};
    int correct1[] = {1, 6, 2, 7, 3, 8, 4, 5};
    int ans1[] = collate2(a, b);
    int correct2[] = {1, 2, 3};
    int ans2[] = collate2(c,d);
    int correct3[] = {1, 2, 3};
    int ans3[] = collate2(d,c); 
    boolean allElementsMatch = true;
    for(int i=0; i<correct1.length; i++)
      allElementsMatch &= ans1[i] == correct1[i];
    for(int k=0; k<correct2.length; k++)
      allElementsMatch &= ans2[k] == correct2[k];
    for(int j=0; j<correct3.length; j++)
      allElementsMatch &= ans3[j] == correct3[j];
    if(allElementsMatch)
      System.out.println("Part 2 works!!!");
    else
      System.out.println("Part 2 back to the drawing board");

  }
  public static int[] merge(int[]a, int[] b){
    if(a == null && b == null){
      int [] rv = null;
      return rv;
    }
    else if(a == null)
      return b;
    else if(b == null)
      return a;
    int rv[] = new int[a.length+b.length];
    int countA = 0;
    int countB = 0;
    for(int i=0;i<rv.length;i++){
      if(countA<a.length && countB<b.length){
        if(a[countA]<b[countB]){
          rv[i] =a[countA];
          countA++;
        }
        else{ 
          rv[i] = b[countB];
          countB++;
        }
      }
      else if(countB>=b.length){
        rv[i] = a[countA];
        countA++;
      }
      else if(countA>=a.length){
        rv[i] = b[countB];
        countB++;
      }
    }
    return rv;
  }
  public static void testCode3(){
    int a[] = {1,3,4,8}; 
    int b[] = {2,5,6,7,8}; 
    int ans1[] = merge(a, b);
    int[] correct1 = {1, 2, 3, 4, 5, 6, 7, 8, 8};
    int c[] = null;
    int d[] = {1, 2, 3};
    int correct2[] = {1, 2, 3};
    int ans2[] = merge(c,d);
    int correct3[] = {1, 2, 3};
    int ans3[] = merge(d,c);
    boolean allElementsMatch = true;
    for(int i=0; i<correct1.length; i++)
      allElementsMatch &= ans1[i] == correct1[i];
    for(int k=0; k<correct2.length; k++)
      allElementsMatch &= ans2[k] == correct2[k];
    for(int j=0; j<correct3.length; j++)
      allElementsMatch &= ans3[j] == correct3[j];
    if(allElementsMatch)
      System.out.println("Part 3 works!!!");
    else
      System.out.println("Part 3 back to the drawing board");
  }
  public static int smallestIndex1(int[] a){
    int smallestIndex = 0;
    for(int i=0; i<a.length-1;i++){
      if(a[smallestIndex]>a[i+1]){
        smallestIndex = i+1;
      }
    }
    return smallestIndex;
  }
  public static void testCode4a(){
    int[] a = {5, 4, 1, 2, 3, 5, 6, 7, 4, 2, 3, 4, 5};
    if(smallestIndex1(a)==2)
      System.out.println("Part 4a works!!!");
    else
      System.out.println("it doesn't work :(((");
  } 
  public static int smallestIndex(int[] a, int n){
    int smallestIndex = n;
    for(int i=n; i<a.length-1;i++){
      if(a[smallestIndex]>a[i+1]){
        smallestIndex = i+1;
      }
    }
    return smallestIndex;
  }
  public static void testCode4c(){
    int[] a = {3, 4, 5, 6, 7, 3, 9};
    if(smallestIndex1(a)==0)
      System.out.println("Part 4a works!!!");
    else
      System.out.println("it doesn't work :(((");
  } 
  public static void sSort(int[] a){
    int indexOfSmallestVariable = 0;
    int smallestValue = 0;
    for(int i=0;i<a.length;i++){
      indexOfSmallestVariable = smallestIndex(a, i);
      smallestValue = a[indexOfSmallestVariable];
      a[indexOfSmallestVariable] = a[i];
      a[i] = smallestValue;
    }
  }
  public static void testCode5a(){
    int[] a = {1, 3, 4, 8, 5, 7, 6, 2};
    sSort(a);
    int[] correct = {1, 2, 3, 4, 5, 6, 7, 8};
    boolean allElementsMatch = true;
    for(int i=0; i<correct.length; i++)
      allElementsMatch &= a[i] == correct[i];
    if(allElementsMatch)
      System.out.println("Part 5a works!!!");
    else
      System.out.println("Part 5a back to the drawing board");
  }
  public static void selectionSort(int[] a){
    int smallestValue = 0;
    int smallestIndex = 0;
    for(int i=0;i<a.length;i++){
      smallestIndex = i;
      for(int k=i; k<a.length-1;k++){
        if(a[smallestIndex]>a[k+1]){
          smallestIndex = k+1;
        }
      }
      smallestValue = a[smallestIndex];
      a[smallestIndex] = a[i];
      a[i] = smallestValue;
    }
  }
  public static void testCode5c(){
    int[] a = {1,3,4,8,5,7,6,2};
    selectionSort(a);
    int[] correct = {1, 2, 3, 4, 5, 6, 7, 8};
    boolean allElementsMatch = true;
    for(int i=0; i<correct.length; i++)
      allElementsMatch &= a[i] == correct[i];
    if(allElementsMatch)
      System.out.println("Part 5c works!!!");
    else
      System.out.println("Part 5c back to the drawing board");
  }
}