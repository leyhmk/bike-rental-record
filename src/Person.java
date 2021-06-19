import java.time.LocalDate;

public interface Person {


    /**
     * Get the person's full name
     *
     * @return the name of the person
     */
    CustomerName getName();


    /**
     * Get the person's date of birth.
     *
     * @return the date of birth of the person
     */
    LocalDate getDateOfBirth();
}
