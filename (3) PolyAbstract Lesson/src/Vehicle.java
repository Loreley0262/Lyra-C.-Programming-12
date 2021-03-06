
//an abstract class is like a blueprint for classes below it (like in inheritance)
// ex you'd never instantiate a vehicle object, just a car truck or motorcycle

public abstract class Vehicle {
    public int registrationNumber;
    public Person owner;

    Vehicle(int registrationNumber, Person owner){
        this.registrationNumber = registrationNumber;
        this.owner = owner;
    }

    Vehicle(){
        registrationNumber = 0;
        owner = null;
    }

    public abstract void honk();
    //used b/c we want every subclass to have and to override this method

}
