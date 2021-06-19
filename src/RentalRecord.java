import java.time.LocalDate;
import java.time.Period;
import java.util.*;

final class RentalRecord extends RentalManager {

    //map of customer number to the rented bike
    static final HashMap<CustomerNumber, Bike> RENTAL_RECORD =
            new HashMap<CustomerNumber, Bike>();
    protected static final String ELECTRIC_BIKE = "ElectricBike";


    //package-private constructor
    //Use RentalManager.getInstance() instead.
    RentalRecord() {
    }


    /**
     * @see Rental#issueBike(CustomerRecord, String) 
     * @throws IllegalArgumentException if customer or typeOfBike is null
     */
    public void issueBike(CustomerRecord customer, String typeOfBike) {
        if (customer == null || typeOfBike == null) {
            throw new IllegalArgumentException("Invalid input");

        }

        if (eligibilityCheck(customer, typeOfBike)) {
            for (Map.Entry<BikeSerialNumber, Bike> bike : BikeFactory.BIKES.entrySet()) {
                Bike bikeRent = bike.getValue();
                //If a bike with required type is found and is not on loan
                //Issue the bike and stop searching for the next bike
                if ((bikeRent.getClass().getSimpleName().equalsIgnoreCase(typeOfBike))
                        && (!bikeRent.isRent())) {
                    bikeRent.setRentalStatus(true);
                    //put the customer number and the bike issued into the rental record map
                    RENTAL_RECORD.put(customer.getCustomerNumber(), bikeRent);
                    break;
                }
            }
        } else {
            throw new IllegalArgumentException("Fail to issue a bike");
        }
    }


    /**
     * Check if the customer are eligible to rent
     * the required type of bike
     *
     * @param customer the customer record
     * @param typeOfBike type of bike required
     * @return boolean representation of the customer's eligibility
     */
    private boolean eligibilityCheck(CustomerRecord customer, String typeOfBike){

        //return false if the person does not have a customer record
        if (!(customer instanceof CustomerRecord)){
            return false;
        }

        //return false the company do not have the require type of bike available
        if (!(availableBikes(typeOfBike)>0)){
            return false;
        }

        //return false if customer is already renting a bike
        if (RENTAL_RECORD.containsKey(customer.getCustomerNumber())) {
            return false;
        }

        // return false if customer that are not Gold Class customer
        // or is under 21 trying to rent an electric bike
        if ((typeOfBike.equals(ELECTRIC_BIKE)) &&
                ((!customer.isGoldClass()) || (ageCalculator(customer)<21))){
            return false;
        }

        return true;
    }


    /**
     * Calculate the age of the customer
     *
     * @param customer the customer's record
     * @return the age of the customer
     */
    private int ageCalculator(CustomerRecord customer){
        return Period.between(customer.getDateOfBirth(), LocalDate.now()).getYears();
    }


    /**
     * @see Rental#terminateRental(CustomerRecord) 
     */
    public void terminateRental(CustomerRecord customer) {
        Bike rentedBike = RENTAL_RECORD.get(customer.getCustomerNumber());
        if (rentedBike !=null){
            rentedBike.setRentalStatus(false);
            //remove the record in the rental record map
            RENTAL_RECORD.remove(customer.getCustomerNumber());
        }
    }


    /**
     * @see Rental#availableBikes(String)
     */
    public int availableBikes(String typeOfBike) {
        int count = 0;
        for (Map.Entry<BikeSerialNumber, Bike> bike : BikeFactory.BIKES.entrySet()) {
            Bike bikeInCheck = bike.getValue();
            if ((bikeInCheck.getClass().getSimpleName().equalsIgnoreCase(typeOfBike)) &&
                    (!bikeInCheck.isRent()))
                count++;
        }
        return count;
    }


    /**
     * @see Rental#getRentedBikes()
     */
    public Collection<Bike> getRentedBikes() {
        Collection<Bike> rentedBike = new ArrayList<>();
        for (Map.Entry<BikeSerialNumber, Bike> bike : BikeFactory.BIKES.entrySet()) {
            Bike bikeInProgress = bike.getValue();
            if (bikeInProgress.isRent()) {
                rentedBike.add(bikeInProgress);
            }
        }
        return Collections.unmodifiableCollection(rentedBike);
    }


    /**
     * @see Rental#getBike(CustomerRecord)
     */
    public Bike getBike(CustomerRecord customer) {
        if (RENTAL_RECORD.containsKey(customer.getCustomerNumber())) {
            return RENTAL_RECORD.get(customer.getCustomerNumber());
        }
        return null;
    }
}