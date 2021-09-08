class Main {
  public static void main(String[] args) {
    System.out.println(intBinaryNBit(11111111, 8));
    System.out.println(doubleBinaryNBit(10101010, 5, 3));
    gradeLab4();
  }
  public static int intBinary8Bit(int a){
    int sum = 0;
    int secondPower = 1;
    for(int i=0;i<7;i++){
      secondPower *= 2;
      sum += a%10*secondPower;
      a /= 10;
    }
    secondPower *= -2;
    sum += a%2*secondPower;
    return sum/2;
  }
  public static int intBinaryNBit(int a, int n){
    int sum = 0;
    int secondPower = 1;
    for(int i=0;i<n-1;i++){
      secondPower *= 2;
      sum += a%10*secondPower;
      a /= 10;
    }
    secondPower *= -2;
    sum += a%2*secondPower;
    return sum/2;
  }
  public static double doubleBinary8Bit(int a){
    int secondPower = 1;
    int exponent = 0;
    int mantissa = 0;
    double rv = 0;
    for(int i=0;i<3;i++){
      secondPower *= 2;
      mantissa += a%10*secondPower;
      a /= 10;  
    }
    secondPower *= -2;
    mantissa += a%2*secondPower; 
    a /= 10;
    secondPower = 1;
    for(int k=0;k<3;k++){
      secondPower *= 2;
      exponent += a%10*secondPower;
      a /= 10;  
    }
    secondPower *= -2;
    exponent += a%2*secondPower;  
    rv += mantissa/2.0 * Math.pow(2.0, exponent/2.0);
    return rv;
  }
  public static double doubleBinaryNBit(int a, int e, int m){
    int secondPower = 1;
    int exponent = 0;
    int mantissa = 0;
    double rv = 0;
    for(int i=0;i<m-1;i++){
      secondPower *= 2;
      mantissa += a%10*secondPower;
      a /= 10;  
    }
    secondPower *= -2;
    mantissa += a%2*secondPower; 
    a /= 10;
    secondPower = 1;
    for(int k=0;k<e-1;k++){
      secondPower *= 2;
      exponent += a%10*secondPower;
      a /= 10;  
    }
    secondPower *= -2;
    exponent += a%2*secondPower;  
    rv += mantissa/2.0 * Math.pow(2.0, exponent/2.0);
    return rv;
  }
  public static void gradeLab4(){ 
    int score=0;
    int number=1;
       try{
           number = 1;
           boolean b = intBinary8Bit(1001) == 9;
           if(b)
               score++;
           System.out.println(number + ". intBinary8Bit():\t\t\t\t\t\t" + b);
       }
       catch(Exception e1){
           System.out.println("\n\n" + number + ". Your code crashed.");
       }
       try{
           number = 2;
           boolean b = intBinary8Bit(10011100) == -100;
           if(b)
               score++;
           System.out.println(number + ". intBinary8Bit() negative:\t\t\t" + b);
       }
       catch(Exception e1){
           System.out.println("\n\n" + number + ". Your code crashed.");
       }
       try{
           number = 3;
           boolean b = intBinaryNBit(1100, 5) == 12;
           if(b)
               score++;
           System.out.println(number + ". intBinaryNBit():\t\t\t\t\t\t" + b);
       }
       catch(Exception e1){
           System.out.println("\n\n" + number + ". Your code crashed.");
       }
       try{
           number = 4;
           boolean b = intBinaryNBit(1000001100, 11) == 524;
           if(b)
               score++;
           System.out.println(number + ". intBinaryNBit() big:\t\t\t\t\t" + b);
       }
       catch(Exception e1){
           System.out.println("\n\n" + number + ". Your code crashed.");
       }
       try{
           number = 5;
           boolean b = intBinaryNBit(1000001100, 11) == 524;
           if(b)
               score++;
           System.out.println(number + ". intBinaryNBit() big:\t\t\t\t\t" + b);
       }
       catch(Exception e1){
           System.out.println("\n\n" + number + ". Your code crashed.");
       }
       try{
           number = 6;
           boolean b = intBinaryNBit(11100, 5) == -4;
           if(b)
               score++;
           System.out.println(number + ". intBinaryNBit() neg:\t\t\t\t\t" + b);
       }
       catch(Exception e1){
           System.out.println("\n\n" + number + ". Your code crashed.");
       }
       try{
           number = 7;
           boolean b = Math.abs(doubleBinary8Bit(11) - 3) < .0001;
           if(b)
               score++;
           System.out.println(number + ". doubleBinary8Bit() mantissa:\t\t\t" + b);
       }
       catch(Exception e1){
           System.out.println("\n\n" + number + ". Your code crashed.");
       }
       try{
           number = 8;
           boolean b = Math.abs(doubleBinary8Bit(110010) - 16) < .0001;
           if(b)
               score++;
           System.out.println(number + ". doubleBinary8Bit() exp:\t\t\t\t" + b);
       }
       catch(Exception e1){
           System.out.println("\n\n" + number + ". Your code crashed.");
       }
       try{
           number = 9;
           boolean b = Math.abs(doubleBinary8Bit(1100110) - 384) < .0001;
           if(b)
               score++;
           System.out.println(number + ". doubleBinary8Bit() full:\t\t\t\t" + b);
       }
       catch(Exception e1){
           System.out.println("\n\n" + number + ". Your code crashed.");
       }
       try{
           number = 10;
           boolean b = Math.abs(doubleBinaryNBit(11001100, 3, 5) - 3) < .0001;
           if(b)
               score++;
           System.out.println(number + ". doubleBinaryNBit():\t\t\t\t\t" + b);
       }
       catch(Exception e1){
           System.out.println("\n\n" + number + ". Your code crashed.");
       }

       System.out.println("\nTotal: " + score + " / 10\n");
   }

}


