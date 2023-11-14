import java.util.Arrays;
import java.util.List;
 class Main extends Overriding {
  public static void main(String[] args) {
   List<Integer>listNums=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
    for(int n:listNums){
      println(n);
    }
    String num1="21";
    int num2=29;
    Object obj=toInt(num1)+num2;
    print(obj);
  }
}

class Overriding{
  public static void
  print(Object object){
    System.out.print(object);
  }
  public static void 
  println(Object object){
    System.out.println(object);
  }
  public static int toInt(Object object){
    return (int)object;
  }
  public static String
  toString(Object object){
    return object.toString();
  }
  public static Double toDb(Object object){
    return (double)object;
  }
} 
