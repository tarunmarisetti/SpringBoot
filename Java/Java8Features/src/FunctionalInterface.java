interface Shape{
    void draw();
}
class Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("Rectangle");

    }
}
class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("Square");


    }
}
public class FunctionalInterface {
    public static void main(String[] args) {
        Shape rectangle=new Rectangle();
        rectangle.draw();
        Shape square=new Square();
        square.draw();

        Shape rectangle1=()-> System.out.println("rectangle from lambda Expression");
        rectangle1.draw();

        print(()-> System.out.println("square from lambda expression"));

    }
    public static void print(Shape shape){
        shape.draw();
    }




}
