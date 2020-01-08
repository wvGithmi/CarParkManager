import java.util.Scanner;

public abstract class Vehicle
{
    Scanner input = new Scanner(System.in);

    public ParkingSlots add_vehicle()
    {
        ParkingSlots slot = new ParkingSlots();
        System.out.println("Enter the details\n");
        System.out.println("Registration ID : ");
        slot.id = input.nextLine();
        System.out.print("Brand of the vehicle : ");
        slot.brand = input.nextLine();
        return slot;
    }
}
