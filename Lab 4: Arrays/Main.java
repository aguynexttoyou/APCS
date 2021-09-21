class Main {
  public static void main(String[] args) {
    double a[] = {1, 2, 5, 6, 7, 1, 2, 5, 6, 1};
    int b[] = {1, -3, 5, 0, 4, 1, 2};
    printArray(b);
    
    System.out.println(min(a));
    System.out.println(max(a));
    System.out.println(mean(a));
    System.out.println(median(a));
    System.out.println(standardDev(a));
    gradeLab5();
  }
  public static int sum(int[] a){
    int rv = 0;
    for(int i=0; i<a.length; i++){
      rv += a[i];
    }
    return rv;
  }
  public static int countZero(int[] a){
    int count = 0;
    for(int i=0; i<a.length; i++){
      if(a[i] == 0)
        count++;
    }
    return count;
  }
  public static int countPositive(int[] a){
    int count = 0;
    for(int i=0; i<a.length; i++){
      if(a[i] > 0)
        count++;
    }
    return count;
  }
  public static int countN(int[] a, int n){
    int count = 0;
    for(int i=0; i<a.length; i++){
      if(a[i] == n)
        count++;
    }
    return count;
  }
  public static void printArray(int[] a){
    String rv = "{";
    for(int i=0; i<a.length; i++){
      if(i == a.length-1)
        rv += a[i] + "}";
      else
        rv += a[i] + ", ";
    }
    System.out.println(rv);
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
  public static int[] copy(int[] a){
    int copy[]  = new int[a.length];
    for(int i=0; i<a.length; i++)
      copy[i] = a[i];
    return copy;
  }
  public static int[] bigger(int[] a){
    int copy[]  = new int[a.length+1];
    for(int i=0; i<a.length; i++)
      copy[i] = a[i];
    return copy;
  }  
  public static int[] smaller(int[] a){
    int copy[]  = new int[a.length-1];
    for(int i=0; i<a.length-1; i++)
      copy[i] = a[i];
    return copy;
  }
  public static void makeSquared(int[] a){
    for(int i=0; i<a.length; i++)
      a[i] = (int)Math.pow(a[i], 2);
  }
  public static int[] square(int[] a){
    int copy[]  = new int[a.length];
    for(int i=0; i<a.length; i++)
      copy[i] = (int)Math.pow(a[i], 2);
    return copy;
  }
  public static int[] splitDigits(int a){
    int b = a;
    int count = 0;
    while(b>0){
      b /= 10;
      count++;
    }
    int array[] = new int[count];
    for(int i=0;i<array.length;i++){
      array[count-1-i] = a%10;
      a /= 10;
    }
    return array;
 }
  public static int[] append(int[] a, int[] b){
    int append[] = new int[a.length+b.length];
    for(int i=0;i<a.length;i++)
      append[i] = a[i];
    for(int k=0;k<b.length; k++)
      append[a.length+k] = b[k];
    return append;
  }
  public static void makeReversed(int[] a){
    int storage = 0;
    for(int i=0;i<a.length/2; i++){
      storage = a[i];
      a[i] = a[a.length-1-i];
      a[a.length-1-i] = storage;
    }
  }
  public static int[] reverse(int[] a){
    int storage = 0;
    int copy[]  = new int[a.length];
    for(int i=0; i<a.length; i++)
      copy[i] = a[i];
    for(int i=0;i<a.length/2; i++){
      storage = copy[i];
      copy[i] = copy[copy.length-1-i];
      copy[copy.length-1-i] = storage;
    }
    return copy;
  }
  public static int[] remove(int[] a, int n){
    int count = a.length;
    for(int i=0; i<a.length;i++){
      if(a[i]==n)
        count--; 
    }
    int copy[]  = new int[count];
    count = 0;
    for(int k=0; k<a.length;k++){
      if(a[k]!=n){
        copy[count]=a[k];
        count++;
      }
    }
   return copy;
  }
  public static double min(double[] a){
    double smallestNum = a[0];
    for(int count = 1;count<a.length; count++){
      if(smallestNum>a[count])
        smallestNum = a[count];
    }
    return smallestNum;
  }
  public static double max(double[] a){
    double largestNum = a[0];
    for(int count = 1;count<a.length; count++){
      if(largestNum<a[count])
        largestNum = a[count];
    }
    return largestNum;
  }
  public static double mean(double[] a){
    double sum = 0;
    for(int i=0;i<a.length;i++)
      sum += a[i];
    return sum/a.length;
  }
   public static double median(double[] a){
    double copy[]  = new double[a.length];
    double storage = 0;  
    double median = 0;
    double halfOne = 0;
    double halfTwo = 0;
    for(int i=0; i<a.length; i++)
      copy[i] = a[i];
    for (int i=0; i<copy.length; i++){  
      for (int k=i+1;k<copy.length;k++){  
        if (copy[i] > copy[k]){  
          storage= copy[i];  
          copy[i] = copy[k];  
          copy[k] = storage;  
        }  
      }
    }
    if(copy.length%2 == 0){
      halfTwo = copy[copy.length/2];
      halfOne = copy[copy.length/2-1];
      median = (halfOne+halfTwo)/2;
    }
    else{
      median = copy[copy.length/2];
    }
    return median;
  }
  public static double standardDev(double[] a){
    double sum = 0;
    for(int i=0;i<a.length;i++)
      sum += a[i];
    double mean = sum/a.length;
    double standardDev = 0;
    for(int i=0; i<a.length;i++)
      standardDev += Math.pow(a[i]-mean,2);
    standardDev /= a.length;
    return Math.pow(standardDev, 0.5);
  }
  public static void gradeLab5(){
   int score = 0;
   int number = 1;
   try {
       number = 1;
       int[] a = {0, 4, 0, 12, 1, 6, 100, 0};
       boolean b = sum(a) == 123;
       if (b)
           score++;
       System.out.println(number + ". sum():\t\t\t\t\t\t\t" + b);
   } catch (Exception e1) {
       System.out.println("\n\n" + number + ". Your code crashed.");
   }
   try {
       number = 2;
       int[] a = {0, 4, 0, 12, 1, 6, 100, 0};
       boolean b = countZero(a) == 3;
       if (b)
           score++;
       System.out.println(number + ". countZero():\t\t\t\t\t\t" + b);
   } catch (Exception e1) {
       System.out.println("\n\n" + number + ". Your code crashed.");
   }
   try {
       number = 3;
       int[] a = {0, 4, 0, -12, 1, -6, 100, 0};
       boolean b = countPositive(a) == 3;
       if (b)
           score++;
       System.out.println(number + ". countPositive():\t\t\t\t\t" + b);
   } catch (Exception e1) {
       System.out.println("\n\n" + number + ". Your code crashed.");
   }
   try {
       number = 4;
       int[] a = {0, 4, 0, 12, 4, 4, 100, 0};
       boolean b = countN(a, 4) == 3;
       if (b)
           score++;
       System.out.println(number + ". countN():\t\t\t\t\t\t" + b);
   } catch (Exception e1) {
       System.out.println("\n\n" + number + ". Your code crashed.");
   }
   try {
       number = 5;
       int[] a = {0, 4, 0, 12, 1, 6, 100, 0};
       boolean b = arrayToString(a).equals("{0, 4, 0, 12, 1, 6, 100, 0}");
       if (b)
           score++;
       System.out.println(number + ". arrayToString():\t\t\t\t\t" + b);
   } catch (Exception e1) {
       System.out.println("\n\n" + number + ". Your code crashed.");
   }
   try {
       number = 6;
       int[] a = {0, 2, 4};
       int[] c = copy(a);
       c[1] = 3;
       boolean b = a[1] == 2 && c[1] == 3 && c[2] == 4;
       if (b)
           score++;
       System.out.println(number + ". copy():\t\t\t\t\t\t\t" + b);
   } catch (Exception e1) {
       System.out.println("\n\n" + number + ". Your code crashed.");
   }
   try {
       number = 7;
       int[] a = {1, 3, 5};
       int[] c = bigger(a);
       boolean b = c.length == 4 && c[0] == 1 && c[1] == 3 && c[2] == 5 && c[3] == 0;
       if (b)
           score++;
       System.out.println(number + ". bigger():\t\t\t\t\t\t" + b);
   } catch (Exception e1) {
       System.out.println("\n\n" + number + ". Your code crashed.");
   }
   try {
       number = 8;
       int[] a = {1, 3, 5};
       int[] c = bigger(a);
       boolean b = c.length == 4 && c[0] == 1 && c[1] == 3 && c[2] == 5 && c[3] == 0;
       if (b)
           score++;
       System.out.println(number + ". bigger():\t\t\t\t\t\t" + b);
   } catch (Exception e1) {
       System.out.println("\n\n" + number + ". Your code crashed.");
   }
   try {
       number = 9;
       int[] a = {1, 3, 5};
       int[] c = smaller(a);
       boolean b = c.length == 2 && c[0] == 1 && c[1] == 3;
       if (b)
           score++;
       System.out.println(number + ". smaller():\t\t\t\t\t\t" + b);
   } catch (Exception e1) {
       System.out.println("\n\n" + number + ". Your code crashed.");
   }
   try {
       number = 10;
       int[] a = {1, -3, 5};
       makeSquared(a);
       boolean b = a.length == 3 && a[0] == 1 && a[1] == 9 && a[2] == 25;
       if (b)
           score++;
       System.out.println(number + ". makeSquared():\t\t\t\t\t" + b);
   } catch (Exception e1) {
       System.out.println("\n\n" + number + ". Your code crashed.");
   }
   try {
       number = 11;
       int[] a = {1, -3, 5};
       int[] c = square(a);
       boolean b = a.length == 3 && a[0] == 1 && a[1] == -3 && a[2] == 5 &&
               c != null && c.length == 3 && c[0] == 1 && c[1] == 9 && c[2] == 25;
       if (b)
           score++;
       System.out.println(number + ". makeSquared():\t\t\t\t\t" + b);
   } catch (Exception e1) {
       System.out.println("\n\n" + number + ". Your code crashed.");
   }
   try {
       number = 12;
       int[] a = splitDigits(2010);
       boolean b = a.length == 4 && a[0] == 2 && a[1] == 0 && a[2] == 1 && a[3] == 0;
       if (b)
           score++;
       System.out.println(number + ". splitDigits():\t\t\t\t\t" + b);
   } catch (Exception e1) {
       System.out.println("\n\n" + number + ". Your code crashed.");
   }
   try {
       number = 13;
       int[] a = {1, 0, 0}, d = {0, 2, 3, 0, 4}, c = append(a, d);
       boolean b = c.length == 8 && c[0] == 1 && c[1] == 0 && c[2] == 0 && c[3] == 0 &&
               c[4] == 2 && c[5] == 3 && c[6] == 0 && c[7] == 4;
       if (b)
           score++;
       System.out.println(number + ". append():\t\t\t\t\t\t" + b);
   } catch (Exception e1) {
       System.out.println("\n\n" + number + ". Your code crashed.");
   }
   try {
       number = 14;
       int[] a = {1, 2, 3, 4};
       makeReversed(a);
       boolean b = a.length == 4 && a[0] == 4 && a[1] == 3 && a[2] == 2 && a[3] == 1;
       if (b)
           score++;
       System.out.println(number + ". makeReversed():\t\t\t\t\t" + b);
   } catch (Exception e1) {
       System.out.println("\n\n" + number + ". Your code crashed.");
   }
   try {
       number = 15;
       int[] a = {7, 8, 9, 0};
       int[] c = reverse(a);
       boolean b = a.length == 4 && a[0] == 7 && a[1] == 8 && a[2] == 9 && a[3] == 0 &&
               c.length == 4 && c[0] == 0 && c[1] == 9 && c[2] == 8 && c[3] == 7;
       if (b)
           score++;
       System.out.println(number + ". splitDigits():\t\t\t\t\t" + b);
   } catch (Exception e1) {
       System.out.println("\n\n" + number + ". Your code crashed.");
   }
   try {
       number = 16;
       int[] a = {1, 2, 3, 1, 1};
       int[] c = remove(a, 1);
       boolean b = a.length == 5 && a[0] == 1 && a[1] == 2 && a[2] == 3 && a[3] == 1 && a[4] == 1 &&
               c.length == 2 && c[0] == 2 && c[1] == 3;
       if (b)
           score++;
       System.out.println(number + ". remove():\t\t\t\t\t\t" + b);
   } catch (Exception e1) {
       System.out.println("\n\n" + number + ". Your code crashed.");
   }
   try {
       number = 17;
       double[] a = {1, -2, 3, 1, 1};
       boolean b = min(a) == -2;
       if (b)
           score++;
       System.out.println(number + ". min():\t\t\t\t\t\t\t" + b);
   } catch (Exception e1) {
       System.out.println("\n\n" + number + ". Your code crashed.");
   }
   try {
       number = 18;
       double[] a = {1, -2, 3, 1, 1};
       boolean b = max(a) == 3;
       if (b)
           score++;
       System.out.println(number + ". max():\t\t\t\t\t\t\t" + b);
   } catch (Exception e1) {
       System.out.println("\n\n" + number + ". Your code crashed.");
   }
   try {
       number = 19;
       double[] a = {1, 2, 4, 5, 3};
       boolean b = mean(a) == 3;
       if (b)
           score++;
       System.out.println(number + ". mean():\t\t\t\t\t\t\t" + b);
   } catch (Exception e1) {
       System.out.println("\n\n" + number + ". Your code crashed.");
   }
   try {
       number = 20;
       double[] a = {1, 2, 4, 6, 7};
       boolean b = Math.abs(standardDev(a) - 2.28) < .001;
       if (b)
           score++;
       System.out.println(number + ". standardDev():\t\t\t\t\t" + b);
   } catch (Exception e1) {
       System.out.println("\n\n" + number + ". Your code crashed.");
   }
   System.out.println("Score: " + score + " / 20");
  }
}
