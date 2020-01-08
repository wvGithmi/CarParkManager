public class Van extends Vehicle{

    int cargoVolume;

    public ParkingSlots add_van()
    {
        ParkingSlots slot = new ParkingSlots();
        slot = super.add_vehicle();
        System.out.print("Enter the cargo Volume : ");
        slot.cargoVolume = input.nextInt();
        return slot;
    }
}
