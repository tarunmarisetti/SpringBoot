interface Vehicle{
    void displayVehicleType(String Type);
}
class vehicleImpmts implements Vehicle{

    @Override
    public void displayVehicleType(String Type) {
        System.out.println("It is a "+Type);
    }
}
public class LambdaExpressions {
    public static void main(String[] args) {
        Vehicle vehicle=new vehicleImpmts();
        vehicle.displayVehicleType("Bus");

//        using lambda expression
        Vehicle vehicle1=(Type)-> System.out.println("it is a "+Type);
        vehicle1.displayVehicleType("car");
    }
}
