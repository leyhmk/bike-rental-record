import java.time.LocalDate;

public class Testing {

    private static final String ROAD_BIKE = "RoadBike";
    private static final String ELECTRIC_BIKE = "ElectricBike";


    /**
     * For testing the whole system.
     * Check for the commenting in order to
     * decide which testing case are required.
     * Comment out unwanted testing cases.
     */
    public static void main(String[] args) {

        //Create 10 electric bikes
        //int i can be changed to iterate less
        //And check the result of no more required type of bike is available
        for (int i=0; i<10; i++){
            Bike bikeElectricTest = BikeFactory.getInstance(ELECTRIC_BIKE);
        }


        //Create 50 road bikes
        for (int i=0; i<50; i++){
            Bike bikeRoadTest = BikeFactory.getInstance(ROAD_BIKE);
        }


        //Check that giving invalid type of bike will throw exception
        Bike invalidTypeTest = BikeFactory.getInstance("Bicycle");


        //Customer One: passed 21 years old but not a Gold Class customer
        //Cannot rent an electric bike
        CustomerRecord recordOne = new CustomerRecord("Janice", "Ho",
                LocalDate.of(1998,4,6),
                LocalDate.of(2020,01,02),
                false);


        //Customer Two: Gold Class member, but not yet passed 21 years old
        //Cannot rent an electric bike
        CustomerRecord recordTwo = new CustomerRecord("David","Anson",
                LocalDate.of(2003,10,30),
                LocalDate.of(2010,05,21),
                true);


        //Customer Three: a Gold Class member and passed 21 years old
        //Can rent an electric bike
        CustomerRecord recordThree = new CustomerRecord("Marcus","Leung",
                LocalDate.of(1990,07,05),
                LocalDate.of(2000,03,04),
                true);


        //Customer Four: not a Gold Class member and not yet passed 21 years old
        //Cannot rent an electric bike
        CustomerRecord recordFour = new CustomerRecord("Benjiman","Myung",
                LocalDate.of(2004,06,18),
                LocalDate.of(2010,9,15),
                false);


        //Customer Five: a Gold Class member and passed 21 years old
        //Can rent an electric bike
        CustomerRecord recordFive = new CustomerRecord("Song","Lee",
                LocalDate.of(1995,10,22),
                LocalDate.of(2020,01,20),
                true);


        //Check customer name immutability
        CustomerName name = recordFive.getName();
        name.setLastName("Testing");
        name.setFirstName("Hello");
        System.out.println(recordFive);


        //Check customer date of birth immutability
        LocalDate dob = recordOne.getDateOfBirth();
        dob = LocalDate.of(2020,05,05);
        System.out.println(recordOne);


        Rental rentalRecord = RentalManager.getInstance();


        //Check the availableBikes method is running properly
        rentalRecord.issueBike(recordThree,ELECTRIC_BIKE);
        rentalRecord.issueBike(recordFour,ROAD_BIKE);
        rentalRecord.issueBike(recordTwo,ROAD_BIKE);
        rentalRecord.issueBike(recordOne,ROAD_BIKE);
        rentalRecord.issueBike(recordFive,ELECTRIC_BIKE);
        System.out.println(rentalRecord.availableBikes(ELECTRIC_BIKE));
        System.out.println(rentalRecord.availableBikes(ROAD_BIKE));


        //Check the getRentedBikes method is running properly
        System.out.println(rentalRecord.getRentedBikes());


        //Check getBike method is running properly
        System.out.println(rentalRecord.getBike(recordThree));


        //Check customer should not be allowed to rent two bikes at the same time
        rentalRecord.issueBike(recordThree,ROAD_BIKE);


        //Make sure the programme will not crush if trying to check
        //a customer that is not currently renting a bike
        rentalRecord.terminateRental(recordThree);
        System.out.println(rentalRecord.getBike(recordThree));
    }
}

