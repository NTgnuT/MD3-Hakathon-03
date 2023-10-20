package ra.bussinessImp;

import ra.bussiness.IBook;

import java.util.Scanner;

public class Book implements IBook, Comparable<Book>{
    //▪ bookId – mã sách – int
    //▪ bookName – tên sách – String
    //▪ title – tiêu đề sách – String
    //▪ numberOfPages – Số trang sách
    //▪ importPrice – giá nhập sách – float
    //▪ exportPrice – giá bán sách – float
    //▪ interest – lợi nhuận – float
    //▪ bookStatus – trạng thái – Boolean
    private int bookId;
    private static int newId = 1;
    private String bookName;
    private String title;
    private int numberOfPages;
    private float importPrice;
    private float exportPrice;
    private float interest;
    private boolean bookStatus;

    public Book() {
        this.bookId = Book.newId++;
    }

    public Book(String bookName, String title, int numberOfPages, float importPrice, float exportPrice, float interest, boolean bookStatus) {
        this.bookId = Book.newId++;
        this.bookName = bookName;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên sách: ");
        this.bookName=scanner.nextLine();

        System.out.println("Nhập tiêu đề cho sách: ");
        this.title=scanner.nextLine();

        System.out.println("Nhập số trang sách: ");
        this.numberOfPages= Integer.parseInt(scanner.nextLine());

        System.out.println("Nhập giá nhập sách: ");
        this.importPrice= Float.parseFloat(scanner.nextLine());

        System.out.println("Nhập giá bán sách: ");
        this.exportPrice= Float.parseFloat(scanner.nextLine());

        System.out.println("Nhập trạng thái sách (true-còn hàng, false-hết hàng): ");
        this.bookStatus= Boolean.parseBoolean(scanner.nextLine());

        this.interest = this.exportPrice - this.importPrice;
    }

    @Override
    public void displayData() {
        System.out.printf("Mã sách: %d, tên sách: %s, tiêu đề sách: %s, số trang sách: %d, giá nhập: %.02f, giá bán: %.02f, lợi nhuận: %.02f, trạng thái sách: %s \n",
                bookId, bookName, title, numberOfPages, importPrice, exportPrice, interest, (bookStatus ? "Còn hàng" : "Hết hàng"));
    }

    @Override
    public int compareTo(Book o) {
        return (int) (o.getInterest() - this.getInterest());
    }
}
