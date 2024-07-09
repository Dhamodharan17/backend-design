public class LSP_V1 {

    //LSP - I can use object child class instead on parent class
    public static void main(String[] args) {
        
        Vehicle bike = new Bike();
        Vehicle car = new Car();
        bike.type();
        car.type();
        bike.steering();// will throw error
    }
}

abstract class Vehicle{

    public void type(){
        System.out.println("Vehicle");
    }

    abstract void steering();

}



class Car extends Vehicle{
    public void type(){
        System.out.println("Car");
    }

    public void steering(){
        System.out.println("Car have steering");
    }

}
