public final class CustomerName {

    private String firstName;
    private String lastName;


    /**
     * Construct the customer name from the given first and
     * last name.
     *
     * @param firstName is the first part of the name
     * @param lastName is the second part of the name
     */
    public CustomerName (String firstName, String lastName){
        setFirstName(firstName);
        setLastName(lastName);
    }


    /**
     * Set the first part of the name.
     *
     * @param firstName first part of the name
     * @throws IllegalArgumentException if firstName is empty
     */
    public void setFirstName(String firstName) {
        if (firstName.length()==0){
            throw new IllegalArgumentException("The first name is empty.");
        }
        this.firstName = firstName;
    }


    /**
     * Set last name.
     *
     * @param lastName second part of the name
     * @throws IllegalArgumentException if last name is empty.
     */
    public void setLastName(String lastName){
        if (lastName.length()==0){
            throw new IllegalArgumentException("The last name is empty.");
        }
        this.lastName = lastName;
    }


    /**
     * Return the first part of the name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }


    /**
     * Return the second part of the name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }


    /**
     * Returns a string representation of a name.
     * The string representation is the first name and last name
     * separated by a space character.
     */
    @Override
    public String toString(){return firstName +" "+lastName;}
}
