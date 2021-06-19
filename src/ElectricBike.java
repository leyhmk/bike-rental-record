final class ElectricBike extends BikeFactory {

    private boolean batteryFull;


    //package-private constructor
    //Use BikeFactory.getInstance() instead.
    ElectricBike(BikeSerialNumber bikeSerialNumber) {
        super(bikeSerialNumber);
        super.setRentalStatus(false);
        //assume battery will be charge when a new bike is being register
        chargeBattery();
    }


    /**
     * Override BikeFactory setRentalStatus.
     * If an electric bike is being returned,
     * charge the bike's battery.
     *
     * @param rent boolean representation of bike
     * rental Status
     */
    public void setRentalStatus(boolean rent) {
        this.rentalStatus = rent;
        if (rent == false){
            chargeBattery();
        }
    }


    /**
     * Charge the bike's battery
     */
    void chargeBattery(){
        this.batteryFull = true;
    }


    /**
     * Check if an electric bike's battery is full.
     *
     * @return boolean representation of the bike battery's
     * status
     */
    public boolean batteryFull(){
        return batteryFull;
    }


    /**
     * Returns a string representation of an electric
     * bike. The string representation shows the bike
     * serial number, its type, its rental status
     * and battery status.
     */
    @Override
    public String toString(){
        return super.toString() +
                String.format("Type of Bike: Electric Bike\nOn Loan: %s\nBattery Full: %s\n",
                isRent(),batteryFull);
    }
}


