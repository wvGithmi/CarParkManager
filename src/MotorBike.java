public class MotorBike extends Vehicle
{
    int engineCapacity;

    public ParkingSlots add_motorbike()
    {
        ParkingSlots slot = new ParkingSlots();
        slot = super.add_vehicle();
        System.out.print("Engine capacity : ");
        slot.engineCapacity = input.nextInt();
        return slot;
    }
}
