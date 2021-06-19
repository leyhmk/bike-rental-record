import java.util.Random;

public class BikeSerialNumber {

    private final String BIKE_SERIAL_NUMBER;
    private final String FIRST_COMPONENT;
    private final String SECOND_COMPONENT;
    private Random randomNum = new Random();


    /**
     * Create a bike serial number when the method
     * is being called.
     */
    public BikeSerialNumber(){
        this.FIRST_COMPONENT = firstComponentGenerator();
        this.SECOND_COMPONENT = secondComponentGenerator();
        this.BIKE_SERIAL_NUMBER = FIRST_COMPONENT + SECOND_COMPONENT;
    }


    /**
     * Generate the first component of the bike
     * serial number. The first component of the
     * serial number is two random letters.
     *
     * @return a string of two random letters
     */
    private String firstComponentGenerator(){
        char firstChar = (char) (97 +randomNum.nextInt(26));
        char secondChar = (char) (97+randomNum.nextInt(26));
        //combine the two character into a string
        StringBuilder builder = new StringBuilder();
        builder.append(firstChar);
        builder.append(secondChar);
        return  builder.toString();
    }


    /**
     * Generate the second component of the bike
     * serial number. The second component of the
     * serial number is a three digit number.
     *
     * @return a three digit number
     */
    private String secondComponentGenerator(){
        int numberComponent = randomNum.nextInt(999);
        return String.format("%03d",numberComponent);
    }


    /**
     * Get the first component of the serial number.
     *
     * @return the first component of the serial number
     */
    public String getFirstComponent(){
        return FIRST_COMPONENT;
    }


    /**
     * Get the second component of the serial number.
     *
     * @return the second component of the serial number
     */
    public String getSecondComponent(){
        return SECOND_COMPONENT;
    }


    /**
     * Returns a string representation of the bike
     * serial number
     */
    @Override
    public String toString(){
        return BIKE_SERIAL_NUMBER;
    }
}
