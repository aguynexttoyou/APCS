public class Main {
   public static void main(String[] args){
    for(int i=0;i<24;i++)
      for(int j=0;j<60;j++)
        for (int k=0; k<60; k++)
          System.out.println(timeToString(i, j, k));
    
    System.out.println(timeToString(0, 9, 0));
    System.out.println(timeToString(12, 5, 4));
    System.out.println(timeToString(15, 0, 15));
    System.out.println(differenceInSeconds(1, 0, 0, 1, 1, 9));
    System.out.println(secondsToEndOfSchool(13, 0, 0));
    gradeProject();
   }
  
  public static String timeToString(int h, int m, int s){
    String ampm = "";
    String hours = "";
    String seconds = "";
    String minutes = "";
    if (h > 12){
      ampm = " PM";
      h = h-12;
      hours = h + "";
     }     
    else if (h == 0){
      ampm = " AM";
      h = h+12;
      hours = h + "";
    }
    else if (h==12){
      ampm = " PM";
      hours = h + "";
    }
    else if (h<10){
      ampm = " AM";
      hours = "" + h;
    }  
    else{
      ampm = " AM";
      hours = h + "";
    }
    if (s < 10)
      seconds = "0" + s;
    else
      seconds = s + "";
    if (m<10)
      minutes = "0" + m;
    else 
      minutes = m + "";
    
    String rv = hours + ":" + minutes + ":" + seconds + ampm;
    return rv;
  } 
 public static int[] add(int h, int m, int s, int addSeconds){
   int[] time = new int[3];
    s += addSeconds;
    while (s>59){
      s -= 60;
      m += 1;
      while(m>59){
        m -= 60;
        h += 1;
        while(h>23){
          h -= 24;
        }
      }
    }
    time[0] = h;
    time[1] = m;
    time[2] = s;

    return time;
  } 
  public static int differenceInSeconds(int h1, int m1, int s1, int h2, int m2, int s2){
    h1 *= 3600;
    m1 *= 60;
    h2 *= 3600;
    m2 *= 60;
    int totalSecond1 = h1 + m1 + s1;
    int totalSecond2 = h2 + m2 + s2;
    int difference = totalSecond2 - totalSecond1;
    return difference;
  }
  public static int secondsToEndOfSchool(int h, int m, int s){
    h *= 3600;
    m *= 60;
    int timeInSeconds = h + m + s;
    int timeBeforeSchool = 54000 - timeInSeconds;
    if (timeBeforeSchool <= 0)
      return 0;
    else 
      return timeBeforeSchool;
  }
  public static void gradeProject(){
   int score=0;
   int number=1;
   try{
       number = 1;
       boolean b = timeToString(0,0,0).equals("12:00:00 AM");
       if(b)
           score++;
       System.out.println(number + ". timeToString() midnight:\t\t\t" + b);
   }
   catch(Exception e1){
       System.out.println("\n\n" + number + ". Your code crashed.");
   }
   try{
       number = 2;
       boolean b = timeToString(1,12,59).equals("1:12:59 AM");
       if(b)
           score++;
       System.out.println(number + ". timeToString() AM:\t\t\t\t" + b);
   }
   catch(Exception e1){
       System.out.println("\n\n" + number + ". Your code crashed.");
   }
   try{
       number = 3;
       boolean b = timeToString(14,50,11).equals("2:50:11 PM");
       if(b)
           score++;
       System.out.println(number + ". timeToString() PM:\t\t\t\t" + b);
   }
   catch(Exception e1){
       System.out.println("\n\n" + number + ". Your code crashed.");
   }
   try{
       number = 4;
       boolean b = timeToString(4,9,1).equals("4:09:01 AM");
       if(b)
           score++;
       System.out.println(number + ". timeToString() Leading Zeros:\t" + b);
   }
   catch(Exception e1){
       System.out.println("\n\n" + number + ". Your code crashed.");
   }
   try{
       number = 5;
       int[] a = add(1,2,3,4);
       boolean b = a[0] == 1 && a[1] == 2 && a[2] == 7;
       if(b)
           score++;
       System.out.println(number + ". add():\t\t\t\t\t\t\t" + b);
   }
   catch(Exception e1){
       System.out.println("\n\n" + number + ". Your code crashed.");
   }
   try{
       number = 6;
       int[] a = add(1,2,3,3661);
       boolean b = a[0] == 2 && a[1] == 3 && a[2] == 4;
       if(b)
           score++;
       System.out.println(number + ". add() overflow:\t\t\t\t\t" + b);
   }
   catch(Exception e1){
       System.out.println("\n\n" + number + ". Your code crashed.");
   }
   try{
       number = 7;
       int[] a = add(23,59,59,1);
       boolean b = a[0] == 0 && a[1] == 0 && a[2] == 0;
       if(b)
           score++;
       System.out.println(number + ". add() overflow day:\t\t\t\t" + b);
   }
   catch(Exception e1){
       System.out.println("\n\n" + number + ". Your code crashed.");
   }
   try{
       number = 8;
       int a = differenceInSeconds(1,1,1,2,2,2);
       boolean b = a == 3661;
       if(b)
           score++;
       System.out.println(number + ". differenceInSeconds():\t\t\t" + b);
   }
   catch(Exception e1){
       System.out.println("\n\n" + number + ". Your code crashed.");
   }
   try{
       number = 9;
       int a = differenceInSeconds(1,1,1,15,15,15);
       boolean b = a == 14*3661;
       if(b)
           score++;
       System.out.println(number + ". differenceInSeconds() big:\t\t" + b);
   }
   catch(Exception e1){
       System.out.println("\n\n" + number + ". Your code crashed.");
   }
   try{
       number = 10;
       int a = secondsToEndOfSchool(1,1,1);
       boolean b = a == 50339;
       if(b)
           score++;
       System.out.println(number + ". secondsToEndOfSchool():\t\t\t" + b);
   }
   catch(Exception e1){
       System.out.println("\n\n" + number + ". Your code crashed.");
   }
   System.out.println("\nTotal: " + score + " / 10\n");
  }
}
