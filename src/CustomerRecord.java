import java.time.LocalDate;

public class CustomerRecord extends Customer {

    private final CustomerNumber CUSTOMER_NUMBER;
    private final LocalDate DATE_OF_ISSUE;
    private boolean goldClass;


    /**
     * Create the customer record with given customer's first name,
     * last name, date of birth, the date of issue of the record
     * and whether the customer is a Gold Class customer.
     *
     * @param firstName customer's first name
     * @param firstName customer's first name
     * @param lastname customer's last name
     * @param dateOfBirth customer's date of birth
     * @param dateOfIssue date of issue of the record
     * @param goldClass identifier of the customer Gold Class membership status
     */
    public CustomerRecord(String firstName, String lastname,
                          LocalDate dateOfBirth, LocalDate dateOfIssue, boolean goldClass){
        super(firstName,lastname,dateOfBirth);
        this.DATE_OF_ISSUE = dateOfIssue;
        this.goldClass = goldClass;
        //Generate the customer number
        this.CUSTOMER_NUMBER = new CustomerNumber(firstName,lastname, dateOfIssue.getYear());

    }


    /**
     * Get the customer number.
     *
     * @return the customer number
     */
    public CustomerNumber getCustomerNumber() {
        return CUSTOMER_NUMBER;
    }


    /**
     * Get the issue date of the customer record.
     *
     * @return date of issue
     */
    public LocalDate getDateOfIssue() {
        return DATE_OF_ISSUE;
    }


    /**
     * Check whether the customer is a Gold Class
     * customer.
     *
     * @return boolean representation of the customer's
     * Gold Class membership status
     */
    public boolean isGoldClass() {
        return goldClass;
    }


    /**
     * Returns string representation of the customer record.
     * The string representation is made up of the customer name,
     * date of birth, date of issue of the record,
     * whether the customer hold a Gold Class membership in
     * five separate lines.
     *
     */
    @Override
    public String toString(){
        return super.toString() +
                String.format("Date of Issue: %s\nCustomer Number: %s\nGold Class Member: %s",
                        DATE_OF_ISSUE, CUSTOMER_NUMBER,goldClass);
    }


    /**
     * Checking if two customer records are equal by comparing
     * their customer number.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CustomerRecord)) return false;
        CustomerRecord customer = (CustomerRecord) obj;
        return (CUSTOMER_NUMBER == customer.getCustomerNumber());
    }


    /**
     * Override hashCode()
     */
    @Override
    public int hashCode() {
        int hc = 17;
        int multiplier = 37;
        return multiplier*hc + (CUSTOMER_NUMBER.hashCode());
    }
}
