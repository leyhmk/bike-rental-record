import java.time.LocalDate;


public class Customer implements Person {

    private final CustomerName NAME;
    private final LocalDate DATE_OF_BIRTH;


    /**
     * Create customer with given first name, last name
     * and date of birth.
     *
     * @param firstName first part of the customer's name
     * @param lastName second part of the customer's name
     * @param dateOfBirth customer's date of birth
     */
    public Customer(String firstName, String lastName, LocalDate dateOfBirth){
        CustomerName name = new CustomerName(firstName,lastName);
        this.NAME = new CustomerName(name.getFirstName(), name.getLastName());
        this.DATE_OF_BIRTH = dateOfBirth;
    }


    /**
     * @see Person#getName()
     */
    public CustomerName getName() {
        return new CustomerName(NAME.getFirstName(), NAME.getLastName());
    }


    /**
     * @see Person#getDateOfBirth()
     */
    public LocalDate getDateOfBirth() {
        return DATE_OF_BIRTH;
    }


    /**
     * Return a string representation of the customer.
     * The string representation is the customer's name
     * and date of birth in two separate lines.
     */
    @Override
    public String toString(){
        return String.format("Customer Name: %s\nDate of Birth: %s\n", NAME,DATE_OF_BIRTH);
    }
}
