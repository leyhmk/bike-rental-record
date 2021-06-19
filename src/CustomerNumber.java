public final class CustomerNumber {

    private final String CUSTOMER_NUMBER;
    private static int serialNumber = 0;


    /**
     * Create the Customer number with given customer's
     * first name, last name and the year in which the
     * customer record was issued.
     *
     * @param firstName customer's first name
     * @param lastName customer's last name
     * @param yearIssued year in which the record was issue
     */
    public CustomerNumber(String firstName, String lastName, int yearIssued){
        String firstComponents = initialGenerator(firstName,  lastName);
        int secondComponents = yearIssued;
        String thirdComponents = serialNumberGenerator();
        this.CUSTOMER_NUMBER = firstComponents + "-" + secondComponents + "-" + thirdComponents;
    }


    /**
     * Generate the first component of the Customer Number.
     * The first component is made up of the initial of the first
     * name, follow by the initial of the last name.
     *
     * @param firstName the customer's first name
     * @param lastName the customer's last name
     * @return the combined initial
     */
    private String initialGenerator(String firstName, String lastName){
        char firstNameInitial = firstName.charAt(0);
        char lastNameInitial = lastName.charAt(0);
        //combine the two initial into one string
        StringBuilder builder = new StringBuilder();
        builder.append(firstNameInitial);
        builder.append(lastNameInitial);
        return builder.toString();
    }


    /**
     * Generate the third part of the customer number,
     * which is an arbitrary serial number.
     *
     * @return the arbitrary number in two digit format
     */
    private String serialNumberGenerator(){
        //increment of the arbitrary number ensure uniqueness of the customer number
        serialNumber++;
        return String.format("%02d",serialNumber);
    }


    /**
     * Return a string representation of
     * the customer number.
     */
    @Override
    public String toString() {
        return CUSTOMER_NUMBER;
    }
}
