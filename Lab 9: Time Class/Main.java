class Main {
  public static void main(String[] args) {
    Time time1 = createTime(8, 6, 44, true);
    Time time2 = createTime(1, 14, 15, false);
    System.out.println(secondsBetween(time1, time2));
  }
  public static Time createTime(int hours, int minutes, int seconds, boolean isAM){
    Time returnObject = new Time();
    returnObject.hour = hours;
    returnObject.minute = minutes;
    returnObject.second = seconds;
    returnObject.isAM = isAM;
    return returnObject; 
  }
  public static String timeToString(Time object){
    String rv = object.hour + ":";
    if(object.minute<10)
      rv += "0" + object.minute + ":";
    else
      rv += object.minute + ":";
    if(object.second<10)
      rv += "0" + object.second;
    else
      rv += object.second;
    if(object.isAM)
      return rv + " AM";    
    else
      return rv+ " PM";
  }
  public static void test1(){
    Time start = createTime(9, 41, 0, true);
    Time end  = createTime(10, 22, 0, true);
    System.out.print("Start: " + timeToString(start) + "\n");
    System.out.print("End: " + timeToString(end));
  }
   public static Time addSeconds(Time time,  int addSeconds){
    time.second += addSeconds;
    while (time.second>59){
      time.second -= 60;
      time.minute += 1;
      while(time.minute>59){
        time.minute -= 60;
        time.hour += 1;
        if(time.hour == 12)
          time.isAM = !time.isAM;
        while(time.hour>12){
          time.hour -= 12;
        }
      }
    }
    return time;
  } 
  public static boolean equals(Time time1, Time time2){
    boolean rv = false;
    if(time1.second==time2.second&&time1.minute==time2.minute&&time1.hour==time2.hour&&time1.isAM==time2.isAM)
      rv = true;
    return rv;
  }
  public static int secondsBetween(Time time1, Time time2){
    int totalSecond1 = time1.hour*3600 + time1.minute*60 + time1.second;
    int totalSecond2 = time2.hour*3600 + time2.minute*60 + time2.second;
    if(!time1.isAM)
      totalSecond1 += 3600*12;
    if(!time2.isAM)
      totalSecond2 += 3600*12;
    return totalSecond2 - totalSecond1;
  }
}