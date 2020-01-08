import java.util.Scanner;

public class Car extends Vehicle
{
    public  ParkingSlots add_car()
    {
        ParkingSlots slot = new ParkingSlots();
        slot = super.add_vehicle();
        System.out.print("The number of doors : ");
        slot.noOfDoors = input.nextInt();
        System.out.print("The color of the car : ");
        slot.color = input.next();
        return slot;
    }

    public void displayCars(ParkingSlots park1[], int maxSlots)
    {
        WestministerCarParkManager obj = new WestministerCarParkManager();
        int noOfCars = count_cars(park1, maxSlots);
        if(noOfCars == 0)
        {
            System.out.println("Number of cars = 0");
        }else{
            System.out.println("Number of cars = "+noOfCars);
            System.out.println("\tSlot\t\t\tRegistration ID  \t\tType \t\t\tBrand\t\t\tNo of doors\t\t\tColor");
            for(int x = 0 ; x < maxSlots ; x++){
                if(park1[x] != null)
                {
                    System.out.println("\t " + park1[x].slot + "\t\t\t\t\t" + park1[x].id + "\t\t\t " + park1[x].type + "\t\t\t" + park1[x].brand + "\t\t\t" + park1[x].noOfDoors + "\t\t\t\t\t" + park1[x].color);
                }
            }
        }
    }

    public int count_cars(ParkingSlots park1[], int maxSlots){
        int x = 0;
        for(int y = 0 ; y < maxSlots ; y++)
        {
            if(park1[y] != null)
            {
                if(park1[y].type.equals("Car")) {
                    x++;
                }
            }
        }
        return x;
    }
}
