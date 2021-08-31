public class Main {
  public static void main(String[] args) {
    System.out.println("2a. onesDigit(123)\t\t" + onesDigit(123));
    System.out.println("2a. onesDigit(201)\t\t" + onesDigit(201));
    System.out.println("2b. tensOnesDigit(3484)\t\t" + tensOnesDigit(3484));
    System.out.println("2b. tensOnesDigit(2410)\t\t" + tensOnesDigit(2410));
    System.out.println("2c. tensDigit(528)\t\t" + tensDigit(528));
    System.out.println("2c. tensDigit(980)\t\t" + tensDigit(980));
    System.out.println("2d. nthDigit(2512, 3)\t\t" + nthDigit(2512, 3));
    System.out.println("2d. nthDigit(5924, 0)\t\t" + nthDigit(5924, 0));
    
    System.out.println("3a. digits(212)\t\t" + digits(212));
    System.out.println("3a. digits(45284)\t\t" + digits(45284));
    System.out.println("3b. countEvenDigits(1234567890)\t\t" + countEvenDigits(1234567890));
    System.out.println("3b. countEvenDigits(5852)\t\t" + countEvenDigits(5852));

    System.out.println("4a. phoneNumberToString(925, 6830433)\t\t" + phoneNumberToString(925, 6830433));
    System.out.println("4a. phoneNumberToString(925, 5555555)\t\t" + phoneNumberToString(925, 5555555));

    System.out.println("5a. getDigits(547236, 3, 1)\t\t" + getDigits(547236, 3, 1));
    System.out.println("5a. getDigits(857394, 10, 3)\t\t" + getDigits(857394, 10, 3));

    System.out.println("6a. printLongDivision(4444, 4)\t\t");
    printLongDivision(4444,4);
    System.out.println("6a. printLongDivision(653568, 64)\t\t");
    printLongDivision(653568,64);
    System.out.println("6b. stringLongDivision(213, 4)\n" + stringLongDivision(213, 4));
    System.out.println("6b. stringLongDivision(7143, 182)\n" + stringLongDivision(7143, 182));
  }
  public static int onesDigit(int a){
    return a % 10;
  }
  public static int tensOnesDigit(int a){
    return a % 100;
  }
  public static int tensDigit(int a){
    return a % 100 / 10;
  }
  public static int nthDigit(int a, int n){
    int tenToPower = 1;
    for(int k=0; k<n+1; k++)
      tenToPower *= 10;
    return a % tenToPower / (tenToPower / 10);
  }
  public static int digits(int a){
    int numberOfDigits = 0;
    if(a < 0)
      a *= -1;
    else if (a == 0)
      return 1;
    while(a>0){
      numberOfDigits ++;
      a /= 10;
    }
    return numberOfDigits;

  }
  public static int countEvenDigits(int a){
    int numberOfEvenDigits = 0;
    while(a>0){
      if (a % 2 == 0){
        numberOfEvenDigits ++;
        a /= 10;
        }
      else
        a /= 10;
    }
    return numberOfEvenDigits;
  }
  public static String phoneNumberToString(int areaCode, int phoneNumber){
    String rv = "(" + areaCode + ") ";
    rv += phoneNumber / 10000 + " - ";
    if(phoneNumber % 10000 < 1000)
      rv += "0" + phoneNumber % 10000;
    else
      rv += "" + phoneNumber % 10000;
    return rv;
  }
  public static int getDigits(int a, int biggestDigit, int smallestDigit){
    int tenToPowerBig = 1;
    int tenToPowerSmall = 1;
    for(int l=0; l<biggestDigit+1; l++)
      tenToPowerBig *= 10;
    a %= tenToPowerBig;
    for(int m=0; m<smallestDigit; m++)
      tenToPowerSmall *= 10;
    a = a/tenToPowerSmall;
    return a;
  }
  public static void printLongDivision(int dividend, int divisor){
    int digitsInDividend = digits(dividend);
    int digitsInDivisor = digits(divisor);
    int leftBound = digitsInDividend - 1;
    int rightBound = leftBound;
    int digitsRangeSubtracted = getDigits(dividend, leftBound, rightBound);
    int subtracted = 0;
    String tabAnswer = "";
    String tabby = "";
    String tabRange = "";
    
    while(digitsRangeSubtracted/divisor < 1){
      rightBound--;
      digitsRangeSubtracted = getDigits(dividend, leftBound, rightBound);
    }

    for(int i=0; i<digitsInDividend+digitsInDivisor+3 - digits(dividend/divisor); i++){
      tabAnswer += " ";
    }
    System.out.println(tabAnswer + dividend/divisor + " r " + dividend%divisor);
    System.out.println(divisor + " | " + dividend);
    
    while(rightBound >= 0){  
      subtracted = (digitsRangeSubtracted/divisor)*divisor;
      digitsRangeSubtracted -= subtracted;
      tabby = "";
      tabRange = "";
      for(int k=0; k<leftBound-rightBound+2; k++){
        tabby += " ";
      }
      for(int k=0; k<leftBound-rightBound+2; k++){
        tabRange += " ";
      }
      if(digits(subtracted) <= digitsInDivisor){
        tabby += " ";
      }
      if(subtracted == 0){
        for(int z=0; z<digits(digitsRangeSubtracted)-1;z++)        
          tabby += " ";
      }
      System.out.println(tabby + "-" + subtracted);
      rightBound --;
      if (rightBound >= 0){
        if(digitsRangeSubtracted == 0)
          tabRange += " ";
        else if(digitsInDivisor > digits(digitsRangeSubtracted)){
          tabRange += " ";
        }
        digitsRangeSubtracted = digitsRangeSubtracted * 10 + nthDigit(dividend, rightBound);
        tabRange +="  ";
        System.out.println(tabRange + digitsRangeSubtracted);   
      }
      else{
        tabRange += "  ";
        if(digitsInDivisor > digits(digitsRangeSubtracted)){
            tabRange+=" ";
          }
        System.out.println(tabRange + digitsRangeSubtracted);
      }
    }
  }
  public static String stringLongDivision(int dividend, int divisor){
    int digitsInDividend = digits(dividend);
    int digitsInDivisor = digits(divisor);
    int leftBound = digitsInDividend - 1;
    int rightBound = leftBound;
    int digitsRangeSubtracted = getDigits(dividend, leftBound, rightBound);
    int subtracted = 0;
    String tabAnswer = "";
    String tabby = "";
    String tabRange = "";
    String rv = "";
    
    while(digitsRangeSubtracted/divisor < 1){
      rightBound--;
      digitsRangeSubtracted = getDigits(dividend, leftBound, rightBound);
    }

    for(int i=0; i<digitsInDividend+digitsInDivisor+3 - digits(dividend/divisor); i++){
      tabAnswer += " ";
    }
    rv += tabAnswer + dividend/divisor + " r " + dividend%divisor + "\n" + divisor + " | " + dividend + "\n" ;
    
    while(rightBound >= 0){  
      subtracted = (digitsRangeSubtracted/divisor)*divisor;
      digitsRangeSubtracted -= subtracted;
      tabby = "";
      tabRange = "";
      for(int k=0; k<leftBound-rightBound+2; k++){
        tabby += " ";
      }
      for(int k=0; k<leftBound-rightBound+2; k++){
        tabRange += " ";
      }
      if(digits(subtracted) <= digitsInDivisor){
        tabby += " ";
      }
      if(subtracted == 0){
        for(int z=0; z<digits(digitsRangeSubtracted)-1;z++)        
          tabby += " ";
      }
      rv += tabby + "-" + subtracted + "\n";
      rightBound --;

      if (rightBound >= 0){
        if(digitsRangeSubtracted == 0)
          tabRange += " ";
        else if(digitsInDivisor > digits(digitsRangeSubtracted)){
          tabRange+=" ";
        }
        digitsRangeSubtracted = digitsRangeSubtracted * 10 + nthDigit(dividend, rightBound);
        tabRange +="  ";
        rv += tabRange + digitsRangeSubtracted + "\n";
      }
      else{
        tabRange += "  ";
        if(digitsInDivisor > digits(digitsRangeSubtracted)){

            tabRange+=" ";
          }
        rv += tabRange + digitsRangeSubtracted + "\n";
      }
    }
    return rv;
  }
}
