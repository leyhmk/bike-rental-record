public abstract class RentalManager implements Rental {


    /**
     * enforce single instance of the rental record
     */
    private static final RentalRecord RECORD_BOOK = new RentalRecord();
    public static RentalRecord getInstance(){
        return RECORD_BOOK;
    }
}
