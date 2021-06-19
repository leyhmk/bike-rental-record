import java.util.HashMap;
import java.util.Map;

public abstract class BikeFactory implements Bike {

    private static final String ROAD_BIKE = "RoadBike";
    private static final String ELECTRIC_BIKE = "ElectricBike";
    //map of bike serial number to instantiated bike
    public static final Map<BikeSerialNumber, Bike> BIKES = new HashMap<BikeSerialNumber, Bike>();
    private final BikeSerialNumber BIKE_SERIAL_NUMBER;
    protected boolean rentalStatus;


    BikeFactory(BikeSerialNumber bikeSerialNumber){
        this.BIKE_SERIAL_NUMBER = bikeSerialNumber;
    }


    /**
     * Return a bike of the specific type.
     *
     * @param typeOfBike the type of bike to return
     * @return the specific type of bike required
     * @throws IllegalArgumentException if typeOfBike is
     * an invalid bike type
     */
    public static Bike getInstance(String typeOfBike){
        // Generate a new random bike serial number
         BikeSerialNumber newNumber = new BikeSerialNumber();
         Bike newBike = BIKES.get(newNumber);

         //enforce single instance per bike serial number
         while (newBike != null){
             newNumber = new BikeSerialNumber();
             newBike = BIKES.get(newNumber);
         }
         if (typeOfBike.equals(ELECTRIC_BIKE)){
             newBike = new ElectricBike(newNumber);
         }else if (typeOfBike.equals(ROAD_BIKE)){
             newBike = new RoadBike(newNumber);
         }else{
             throw new IllegalArgumentException(typeOfBike + " is an invalid type.");
         }

         //put newBike in bike map
         BIKES.put(newNumber, newBike);

         // return the instance
         return newBike;
    }


    /**
     * @see Bike#getSerialNumber()
     */
    public BikeSerialNumber getSerialNumber(){
        return BIKE_SERIAL_NUMBER;
    }


    /**
     * @see Bike#isRent()
     */
    public boolean isRent(){
        return rentalStatus;
    }


    /**
     * @see Bike#setRentalStatus(boolean);
     */
    public void setRentalStatus(boolean rent) {
        this.rentalStatus = rent;
    }


    /**
     * Returns a string representation of a bike,
     * which is the bike serial number.
     */
    @Override
    public String toString(){
        return "Bike Serial Number: " + BIKE_SERIAL_NUMBER + "\n";
    }


    /**
     * Checking if two bikes are the same by comparing
     * their bike serial numbers.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Bike)) return false;
        Bike bike = (Bike) obj;
        return (BIKE_SERIAL_NUMBER.equals(bike.getSerialNumber()));
    }


    /**
     *Override hashCode()
     */
    @Override
    public int hashCode() {
        int hc = 17;
        int multiplier = 37;
        return multiplier*hc+(BIKE_SERIAL_NUMBER.hashCode());
    }
}
