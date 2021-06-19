public interface Bike {


    /**
     * Get the bike serial number.
     *
     * @return the serial number of the bike
     */
    BikeSerialNumber getSerialNumber();


    /**
     * Check if a bike is currently rented out
     *
     * @return boolean representation of the rental status
     */
    boolean isRent();


    /**
     * Set the rental status of a bike
     *
     * @param rentalStatus boolean representation of the rental status
     */
    void setRentalStatus(boolean rentalStatus);
}
