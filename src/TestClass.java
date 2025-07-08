import java.time.LocalDate;

public  class TestClass {


    private BookInventoryManager manager;


    public  TestClass(BookInventoryManager manager){

        this.manager=manager;
    }


    void TestRemoving(){


        try {
            manager.RemoveBook("B1");
            System.out.println("Removed book with ISPN B1 successfully.");

            System.out.println("------------------------------------------------------");

        }
        catch (BookNotFoundException e) {
            System.out.println("Failed to remove B1: " + e.getMessage());
        }

        System.out.println(" Removing  Book that does not exist (B99):");
        try {
            manager.RemoveBook("B99");

            System.out.println("------------------------------------------------------");

        }

        catch (BookNotFoundException e) {
            System.out.println("Error : " + e.getMessage());
        }

        System.out.println("------------------------------------------------------");

    }


    void TestRemovingOutDatedBooks() throws BookExistsException {

        PaperBook book7 = new PaperBook("B7", "Old Algorithms Book", LocalDate.of(2015, 6, 12), 200.0, 4);
        EBook book8 = new EBook("B8", "Legacy Systems", LocalDate.of(2016, 3, 22), 180.0, "MOBI");

        System.out.println(" Removing Outdated Books (older than 6 years):");





        System.out.println(" Trying To Add Outdated Books (older than 6 years):");

        try {

        System.out.println("Adding Book7:");
        manager.Add(book7);
        System.out.println("Adding Book8:");
        manager.Add(book8);
        }

        catch (BookExistsException ex){

            System.out.println("Error "+ex.getMessage() );
        }


        manager.RemoveOutDatedBooks(6);

        System.out.println("------------------------------------------------------");


    }


   void TestAdding() throws BookExistsException {



        PaperBook book1 = new PaperBook("B1", "Java Book", LocalDate.of(2021, 5, 10), 300.0, 10);
        PaperBook book2 = new PaperBook("B2", "C++ Book", LocalDate.of(2022, 1, 15), 450.0, 5);
        PaperBook book5 = new PaperBook("B5", "Backend", LocalDate.of(2022, 1, 15), 450.0, 5);

        EBook book3 = new EBook("B3", "Data Structures", LocalDate.of(2023, 3, 20), 250.0, "PDF");
        EBook book4 = new EBook("B4", "Java Book", LocalDate.of(2020, 8, 5), 320.0, "EPUB");

        DemoBook book6 = new DemoBook("B5", "Java Preview Edition", LocalDate.of(2019, 9, 1)); // Duplicate ISPN




        System.out.println("Adding Book1:");
        manager.Add(book1);


        System.out.println("------------------------------------------------------");

        System.out.println(" Adding Book5 (B5):");
        manager.Add(book5);


       System.out.println("------------------------------------------------------");


        try{


        System.out.println(" Trying to Add Duplicate Book6 (B5):");
        manager.Add(book6);

        }

        catch (BookExistsException ex){

            System.out.println("Error "+ex.getMessage() );
        }

       System.out.println("------------------------------------------------------");



    }


    void BuyPaperBook() throws BookExistsException, BookNotPurchasableException, InsufficientStockException, BookNotFoundException, InvalidBookTypeException, BookOutOfStockException {


        System.out.println("Buying paper Book (No Error)");

        PaperBook book = new PaperBook("B9", "Python Basics", LocalDate.of(2023, 2, 10), 280.0, 15);


        manager.Add(book);


        manager.CheckIfBookIsPurchasable(book.getIspn());

        PaperBookPurchaseRequest request=new PaperBookPurchaseRequest(book.getIspn(),"Giza",3);


        ShippingService shippingService=new ShippingService();
        PaperBookPurchaseService service=new PaperBookPurchaseService(manager.GetRepository(),shippingService);


        try {

        service.buy(request);
        }

        catch (Exception ex){

            System.out.println("Error :" + ex.getMessage());
        }

        System.out.println("----------------------------------------------------------------");
    }


    void BuyOutOfStockPaperBook() throws BookExistsException, BookNotPurchasableException {

        System.out.println("Buying paper Book (Out Of Stock)");


        PaperBook book = new PaperBook("B10", "Python Basics", LocalDate.of(2023, 2, 10), 280.0, 0);



        manager.Add(book);
        manager.CheckIfBookIsPurchasable(book.getIspn());
        PaperBookPurchaseRequest request=new PaperBookPurchaseRequest(book.getIspn(),"Giza",2);


        ShippingService shippingService=new ShippingService();
        PaperBookPurchaseService service=new PaperBookPurchaseService(manager.GetRepository(),shippingService);

        try {

            service.buy(request);
        }

        catch (Exception ex){

            System.out.println("Error :" + ex.getMessage());
        }


        System.out.println("----------------------------------------------------------------");
    }

    void BuyExcessQuantityPaperBook() throws BookExistsException, BookNotPurchasableException {


        System.out.println("Buying paper Book (Excess than stock)");


        PaperBook book = new PaperBook("B11", "Python Basics", LocalDate.of(2023, 2, 10), 280.0, 4);



        manager.Add(book);
        manager.CheckIfBookIsPurchasable(book.getIspn());

        PaperBookPurchaseRequest request=new PaperBookPurchaseRequest(book.getIspn(),"Giza",5);


        ShippingService shippingService=new ShippingService();
        PaperBookPurchaseService service=new PaperBookPurchaseService(manager.GetRepository(),shippingService);


        try {

            service.buy(request);
        }

        catch (Exception ex){

            System.out.println("Error :" + ex.getMessage());
        }

        System.out.println("----------------------------------------------------------------");
    }

    void BuyNotFoundBook() throws BookNotPurchasableException {


        System.out.println("Buying paper Book (Not Found)");


        PaperBook book = new PaperBook("B100", "Java", LocalDate.of(2023, 2, 10), 280.0, 15);

        PaperBookPurchaseRequest request=new PaperBookPurchaseRequest(book.getIspn(), "Giza",5);





        ShippingService shippingService=new ShippingService();
        PaperBookPurchaseService service=new PaperBookPurchaseService(manager.GetRepository(),shippingService);


        try {

            service.buy(request);
        }

        catch (Exception ex){

            System.out.println("Error :" + ex.getMessage());
        }

        System.out.println("----------------------------------------------------------------");


    }

    void BuyEBook() throws BookNotPurchasableException, BookExistsException {

        System.out.println("Buying EBook (No Error)");


        EBook book = new EBook("B12", "Machine Learning", LocalDate.of(2024, 1, 18), 350.0, "MOBI");


        manager.Add(book);

        EBookPurchaseRequest request=new EBookPurchaseRequest(book.getIspn(), "Ohisham@gmail.com");

        manager.CheckIfBookIsPurchasable(book.getIspn());


        EmailService emailService=new EmailService();
        EBookPurchaseService service=new EBookPurchaseService(manager.GetRepository(),emailService);

        try {

            service.buy(request);
        }

        catch (Exception ex){

            System.out.println("Error :" + ex.getMessage());
        }


        System.out.println("----------------------------------------------------------------");

    }


    void TryBuyDemoBook() throws BookExistsException {

        System.out.println("trying to Buy Demo Book ");



        DemoBook book = new DemoBook("B13", "Python Preview Edition", LocalDate.of(2022, 6, 20));


        manager.Add(book);
        try{

        manager.CheckIfBookIsPurchasable(book.getIspn());

        }

        catch (BookNotPurchasableException ex){

            System.out.println("Error :" +ex.getMessage());
        }


    }


}
