public class BookDemo {
    public static void main(String[] args) {
        Book myBook = new Book("Adventures in Programming");
        
        myBook.addPage("Once upon a time, there was a programmer who loved to code.");
        myBook.addPage("The programmer discovered the joy of creating digital worlds.");
        myBook.addPage("With each line of code, new possibilities emerged.");
        myBook.addPage("And they all lived happily ever after, debugging forever.");
        
        System.out.println(myBook.getBookInfo());
        System.out.println();
        
        System.out.println("Reading the book:");
        System.out.println(myBook.readCurrentPage());
        System.out.println();
        
        System.out.println("Turning pages forward:");
        while (myBook.hasNextPage()) {
            myBook.turnToNextPage();
            System.out.println(myBook.readCurrentPage());
        }
        
        System.out.println();
        System.out.println("Turning pages backward:");
        while (myBook.hasPreviousPage()) {
            myBook.turnToPreviousPage();
            System.out.println(myBook.readCurrentPage());
        }
        
        System.out.println();
        System.out.println("Going to specific page (page 3):");
        myBook.goToPage(3);
        System.out.println(myBook.readCurrentPage());
    }
}