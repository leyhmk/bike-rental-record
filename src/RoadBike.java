final class RoadBike extends BikeFactory {


    //package-private constructor
    //Use BikeFactory.getInstance() instead.
    RoadBike(BikeSerialNumber bikeSerialNumber) {
        super(bikeSerialNumber);
        super.setRentalStatus(false);
    }


    /**
     * Returns a string representation of a road
     * bike. The string representation shows the
     * bike serial number, its type and its rental
     * status.
     */
    @Override
    public String toString(){
        return super.toString() +
                "Type of Bike: Road Bike\nOn Loan: " + isRent() +"\n";
        }
}
