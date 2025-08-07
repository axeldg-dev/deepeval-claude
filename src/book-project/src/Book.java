import java.util.List;
import java.util.ArrayList;

public class Book {
    private List<String> pages;
    private int currentPage;
    private String title;
    
    public Book(String title) {
        this.title = title;
        this.pages = new ArrayList<>();
        this.currentPage = 0;
    }
    
    public void addPage(String content) {
        pages.add(content);
    }
    
    public String readCurrentPage() {
        if (pages.isEmpty()) {
            return "This book has no pages.";
        }
        if (currentPage >= pages.size()) {
            return "You've reached the end of the book.";
        }
        return "Page " + (currentPage + 1) + ": " + pages.get(currentPage);
    }
    
    public boolean turnToNextPage() {
        if (currentPage < pages.size() - 1) {
            currentPage++;
            return true;
        }
        return false;
    }
    
    public boolean turnToPreviousPage() {
        if (currentPage > 0) {
            currentPage--;
            return true;
        }
        return false;
    }
    
    public void goToPage(int pageNumber) {
        if (pageNumber >= 1 && pageNumber <= pages.size()) {
            currentPage = pageNumber - 1;
        }
    }
    
    public int getCurrentPageNumber() {
        return currentPage + 1;
    }
    
    public int getTotalPages() {
        return pages.size();
    }
    
    public String getTitle() {
        return title;
    }
    
    public boolean hasNextPage() {
        return currentPage < pages.size() - 1;
    }
    
    public boolean hasPreviousPage() {
        return currentPage > 0;
    }
    
    public String getBookInfo() {
        return "Book: " + title + " (" + pages.size() + " pages, currently on page " + (currentPage + 1) + ")";
    }
}