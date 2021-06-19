import java.util.Collection;

public interface Rental {


    /**
     * Issue a bike given the customer's record and the type of bike
     * required.
     *
     * @param name customer who want to rent a bike
     * @param typeOfBike the type of bike required
     * @throws IllegalArgumentException if a bike cannot be issued.
     */
    void issueBike(CustomerRecord name, String typeOfBike);


    /**
     * Terminate the rental record given the customer record.
     * If trying to terminate a non-existent contract has no
     * effect.
     *
     * @param name the record of the customer
     */
    void terminateRental(CustomerRecord name);


    /**
     * Get the number of bikes of the specified type that
     * are available to rent.
     *
     * @param typeOfBike the specific type of bike required
     * @return the number of bike available
     */
    int availableBikes(String typeOfBike);


    /**
     * Get a collection of all bikes currently rented out.
     * If no bike is on loan, this method will return an
     * empty collection.
     *
     * @return List of bikes that are on loan
     */
    Collection<Bike> getRentedBikes();


    /**
     * Given a customer's record, returns the bike that
     * they are currently renting.
     * If they are not currently renting any bike, return null.
     *
     * @param name the customer's record
     * @return the bike they are currently renting
     */
    Bike getBike(CustomerRecord name);
}
