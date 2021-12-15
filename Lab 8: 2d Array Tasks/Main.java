class Main {
  public static void main(String[] args){
    int[][] b = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
    System.out.println(arrayToString2d((pascalsTriangle(20))));
  }
  public static String arrayToString(int[] a){
   if(a==null)
    return "null";
   String rv = "{";
   for(int i=0; i<a.length; i++){
     if(i == a.length-1)
       rv += a[i] + "}";
     else
       rv += a[i] + ", ";
   }
   return rv;
 }
  public static String arrayToString2d(int[][] a){
    if(a==null)
      return "null";
    String rv = "{";
    for(int i=0; i<a.length; i++){
      while(i<a.length-1&&a[i]==null){
        rv += "null,\n ";
        i += 1;
      }
      if(i==a.length-1&&a[i]==null){
        rv += "null}}";
        return rv;
      }
      rv += "{";
      if(i == a.length-1){
        for(int j=0; j<a[i].length; j++){
          if(j == a[i].length-1)
            rv += a[i][j] + "}";
          else
            rv += a[i][j] + ", ";
        }
        rv += "}";
      }
      else{
        for(int j=0; j<a[i].length; j++){
          if(j == a[i].length-1)
            rv += a[i][j] + "}";
          else
            rv += a[i][j] + ", ";
        }
        rv += ",\n ";
      }
    } 
    return rv;
  }
  public static boolean threeInARow(int[][] a){
    if(a[0][0]!=0&&a[0][0]==a[0][1]&&a[0][0]==a[0][2]||a[1][0]!=0&&a[1][0]==a[1][1]&&a[1][0]==a[1][2]||a[2][0]!=0&&a[2][0]==a[2][1]&&a[2][0]==a[2][2])
      return true;
    if(a[0][0]!=0&&a[0][0]==a[1][0]&&a[0][0]==a[2][0]||a[0][1]!=0&&a[0][1]==a[1][1]&&a[0][1]==a[2][1]||a[0][2]!=0&&a[0][2]==a[1][2]&&a[0][2]==a[2][2])
      return true;
    if(a[0][0]!=0&&a[0][0]==a[1][1]&&a[0][0]==a[2][2]||a[2][0]!=0&&a[2][0]==a[1][1]&&a[2][0]==a[0][2])
      return true;
    else
      return false;
  }
  public static int sumOf2dArray(int[][] a){
    int sum = 0;
    if(a==null)
      return 0;
    for(int i=0; i<a.length; i++){
      while(a[i]==null){
        i++;
        if(i==a.length)
          return sum;
      }
      for(int j=0;j<a[i].length; j++){
        sum += a[i][j];
      }
    }
    return sum;
  }
  public static int sumOfMajorDiagonal(int[][] a){
    int sum = 0;
    for(int i=0;i<a.length; i++){
      sum += a[i][i];
    }
    return sum;
  }
    public static int sumOfMinorDiagonal(int[][] a){
    int sum = 0;
    for(int i=0;i<a.length; i++){
      sum += a[i][a.length-1-i];
    }
    return sum;
  }
  public static int min(int[] a){
    if(a==null)
      return 0;
    int smallestNum = a[0];
    for(int count = 1;count<a.length; count++){
      if(smallestNum>a[count])
        smallestNum = a[count];
    }
    return smallestNum;
  }
  public static int min2d(int[][] a){
    if(a==null)
      return 0;
    int i=0;
    while(a[i]==null&&i<a.length-1)
      i++;
    int smallestNum = min(a[i]);
    for(i=i+1; i<a.length; i++){
      if(smallestNum>min(a[i])&&a[i]!=null)
        smallestNum = min(a[i]);
    }
    return smallestNum;
  }
  public static int min2d2(int[][] a){
    if(a==null)
      return 0;
    int count=0;
    while(a[count]==null&&count<a.length-1)
      count++;
    if(count==a.length-1&&a[count]==null)
      return 0;
    int smallestNum = a[count][0];
    for(int i=count;i<a.length;i++){
      if(smallestNum>min(a[i])&&a[i]!=null){
        for(int k=0;k<a[i].length;k++){
          if(a[i][k]<smallestNum)
            smallestNum = a[i][k];
        }
      }
    }
    return smallestNum;
  }
  public static void rotate(int[][] a){
    int storage;
    for(int i=0;i<a.length;i++){
      for(int j=i;j<a[i].length;j++){
        storage = a[i][j];
        a[i][j] = a[j][i];
        a[j][i] = storage;
      }
    }
    for(int k=0; k<a.length; k++){
      for(int l=0; l<a[l].length/2; l++){
        storage = a[k][l];
        a[k][l]=a[k][a.length-1-l];
        a[k][a.length-1-l] = storage;
      }
    }
  }
  public static int[][] expand(int[][]a){
    int[][] rv = new int[a.length*2][];
    int countOut = 0;
    int countIn = 0;
    for(int i=0; i<rv.length;i+=2){
      countIn = 0;
      rv[i] = new int[a[countOut].length*2];
      rv[i+1] = rv[i];
      for(int j=0; j<rv[i].length;j+=2){
        rv[i][j] =  a[countOut][countIn];
        rv[i][j+1] = rv[i][j];
        countIn++;     
      }
      countOut++;
    }
    return rv;
  }
  public static void pattern(){
    int[][] a = new int[5][];
    for(int i=0; i<a.length;i++)
      a[i] = new int[i+1];  
    for(int j=0; j<a.length; j++)
      for(int k=0;k<a[j].length;k++){
        a[j][k] = k+1;
      }
    System.out.println(arrayToString2d(a));
    int[] storageArray;
    int storage;
    for(int i=0; i<a.length/2; i++){
      storageArray = a[i];
      a[i] = a[a.length-1-i];
      a[a.length-1-i] = storageArray;
    } 
    for(int i=0; i<a.length; i++){
      for(int j=0; j<a[i].length/2;j++){
        storage = a[i][j];
        a[i][j] = a[i][a[i].length-1-j];
        a[i][a[i].length-1-j] = storage;
      }
    }
    System.out.println(arrayToString2d(a));
    for(int i=0; i<a.length/2; i++){
      storageArray = a[i];
      a[i] = a[a.length-1-i];
      a[a.length-1-i] = storageArray;
    } 
    for(int i=0; i<a.length; i++){
      for(int j=0; j<a[i].length; j++){
        a[i][j] = a.length-i;
      }
    }
    System.out.println(arrayToString2d(a));
  }
  public static int[][] pascalsTriangle(int n){
    int[][] a = new int[n][];
    for(int i=0; i<a.length; i++)
      a[i] = new int[i+1];
    for(int i=0; i<a.length; i++){
      for(int j=0; j<a[i].length; j++){
        if(j==0 || j==i)
          a[i][j] = 1;
        else
          a[i][j] = a[i-1][j] + a[i-1][j-1];
      } 
    }
    return a;
  }
}  