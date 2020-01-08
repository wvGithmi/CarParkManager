import java.util.Scanner;

public class WestministerCarParkManager implements CarParkManager
{
    int maxSlots = 20;
    ParkingSlots[] park1 = new ParkingSlots[20];
    Scanner input = new Scanner(System.in);

    public static void main(String args[])
    {
        WestministerCarParkManager obj = new WestministerCarParkManager();
        int i = 0;
        while (i != 4)
        {
            i = obj.print_menu();
            switch (i)
            {
                case 1 :
                    obj.add_vehicle();
                    break;
                case 2 :
                    obj.delete_vehicle();
                    break;
                case 3 :
                    obj.print_summary();
                    break;
            }
        }
    }

    public void add_vehicle()
    {
        int count = find_slot();
        if(count == -1)
        {
            System.out.println("Cannot insert a new vehicle.");
        }else{
            System.out.println("Select vehicle type : \ncar - type1\nvan - type2\nmotor bike - type 3\n\ntype : ");
            int x = input.nextInt();

            switch (x)
            {
                case 1 :
                    Car carObj = new Car();
                    park1[count] = carObj.add_car();
                    park1[count].slot = count;
                    park1[count].type = "Car";
                    break;
                case 2 :
                    Van vanObj = new Van();
                    park1[count] = vanObj.add_van();
                    park1[count].slot = count;
                    park1[count].type = "Van";
                    break;
                case 3 :
                    MotorBike motorbikeObj = new MotorBike();
                    park1[count] = motorbikeObj.add_motorbike();
                    park1[count].slot = count;
                    park1[count].type = "Motor Bike";
                    break;
            }
            System.out.println("Successfully inserted.");
        }
    }

    public void delete_vehicle()
    {
        displaySlots();
        System.out.print("Enter slot number to remove the vehicle : ");
        int delSlot = input.nextInt();
        park1[delSlot] = null;
    }

    public void print_summary()
    {
        Car obj = new Car();
        displaySlots();
        obj.displayCars(park1, maxSlots);
    }

    public int print_menu()
    {
        System.out.println("\n\n-------Westminister Car Park Manager-------");
        System.out.println("1 - Add Vehicle\n");
        System.out.println("2 - Delete Vehicle\n");
        System.out.println("3 - View Summary\n");
        System.out.println("4 - EXIT\n\n");
        System.out.println("Select your choice : ");
        int x = input.nextInt();
        return x;
    }

    public void displaySlots()
    {
        int count = count_vehicles();
        if(count == 0)
        {
            System.out.println("\t -Park is Empty-");
            System.out.println("\t________________");
        }else{
            System.out.println("\tSlot\t\tRegistration ID \t\tType\t\t\tBrand");
            for (int x = 0 ; x < maxSlots ; x++)
            {
                if(park1[x] != null)
                {
                    System.out.println("\t " + park1[x].slot + "\t\t\t\t" + park1[x].id + "\t\t\t\t" + park1[x].type + "\t\t\t" + park1[x].brand);
                }
            }
        }
    }

    public int find_slot()
    {
        int x = 1;
        for(int y = 0 ; y < maxSlots ; y++)
        {
            if(park1[y] == null)
            {
                x = y;
                break;
            }
        }
        return x;
    }

    public int count_vehicles()
    {
        int x = 0;
        for(int y = 0 ; y < maxSlots ; y++)
        {
            if(park1[y] != null)
            {
                x++;
            }
        }
        return x;
    }

}
