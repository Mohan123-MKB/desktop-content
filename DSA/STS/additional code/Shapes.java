import java.util.*;
abstract class Shape{
    abstract double area();
}
class Circle extends Shape{
    double radius;
    Circle(double r){
        radius=r;
    }
    double area(){
        return Math.PI * radius * radius;
    }
}
class Rectangle extends Shape{
    double width,height;
    Rectangle(double w,double h){
        width=w;
        height=h;
    }
    double area(){
        return width * height;
    }
}
class Triangle extends Shape{
    double base,height;
    Triangle(double b,double h){
        base=b;
        height=h;
    }
    double area(){
       return 0.5 *base*height;
    }
}
public class Shapes{
    public static void main(String ar[]){
        Shape s1=new Circle(5);
        Shape s2=new Rectangle(5,5);
        Shape s3=new Triangle(5,5);
         System.out.println("Area of Circle: " + s1.area());
        System.out.println("Area of Rectangle: " + s2.area());
        System.out.println("Area of Triangle: " + s3.area());


}
}
