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
    Object obj=toString(num1)+num2;
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
  public static int toInt(String values){
    return Integer.parseInt(values);
  }
  public static String
  toString(String values){
    return String.valueOf(values);
  }
  public static Double
  toDouble(String values){
    return Double.parseDouble(values) ;
  }
} 
