package ra.run;

import ra.bussinessImp.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BookManagement {
    static Scanner scanner = new Scanner(System.in);

    static List<Book> books = new ArrayList<>();

    static Book book1 = new Book("Sách 10", "Sách 10", 256, 12000, 20000, 8000, true);
    static Book book2 = new Book("Sách 18", "Sách 18", 320, 10000, 25000, 15000, true);
    static Book book3 = new Book("Sách 7", "Sách 7", 120, 8000, 20000, 12000, true);
    static Book book4 = new Book("Sách 3", "Sách 3", 358, 5000, 23000, 18000, true);
    static Book book5 = new Book("Sách 25", "Sách 25", 296, 12000, 25000, 13000, true);
    static Book book6 = new Book("Sách 14", "Sách 14", 201, 20000, 40000, 20000, true);

    public static void main(String[] args) {
    books.add(book1);
    books.add(book2);
    books.add(book3);
    books.add(book4);
    books.add(book5);
    books.add(book6);

       while (true) {
           System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************");
           System.out.println("1. Nhập số sách và nhập thông tin sách \n" +
                   "2. Hiển thị thông tin các sách \n" +
                   "3. Sắp xếp sách theo lợi nhuận giảm dần \n" +
                   "4. Xóa sách theo mã sách \n" +
                   "5. Tìm kiếm sách theo tên sách \n" +
                   "6. Thay đổi trạng thái của sách theo mã sách \n" +
                   "7. Thoát");
           System.out.println("*********************************************");
           System.out.println("Nhập lựa chọn của bạn (1-7)");
           int choice = Integer.parseInt(scanner.nextLine());
           handleChoice(choice);
       }
    }

    public static void handleChoice (int choice) {
        switch (choice) {
            case 1:
                addBook();
                break;
            case 2:
                showAllBook();
                break;
            case 3:
                sortBook();
                break;
            case 4:
                deleteBook();
                break;
            case 5:
                findBook();
                break;
            case 6:
                changeStatus();
                break;
            case 7:
                System.exit(1);
            default:
                System.out.println("Không có lựa chọn này");
                break;
        }
    }

    private static void changeStatus() {
        System.out.println("Nhập mã sách bạn muốn thay đổi trạng thái: ");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookId() == n) {
                books.get(i).setBookStatus(!books.get(i).isBookStatus());
                break;
            }
        }

        System.out.println("Không tìm thấy ID sách bạn muốn đổi trạng thái");
    }

    private static void findBook() {
        System.out.println("Nhập tên sách bạn muốn tìm kiếm: ");
        String findName = scanner.nextLine();
        boolean checkBook = false;

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookName().toLowerCase().contains(findName.toLowerCase())){
                books.get(i).displayData();
                checkBook = true;
            }
        }
        if (!checkBook) {
            System.out.println("Không tìm thấy tên sách bạn cần tìm");
        }

    }

    private static void deleteBook() {
        System.out.println("Nhập id sách bạn muốn xóa: ");
        int idDelete = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < books.size() ; i++) {
            if (books.get(i).getBookId() == idDelete) {
                books.remove(i);
                System.out.println("Xóa thành công");
                return;
            }
        }
        System.out.println("ID sách bạn muốn xóa không có!");
    }

    private static void sortBook() {
        System.out.println("Danh sách sách sắp xếp giảm dần theo lợi nhuận: ");
//        Collections.sort(books, (b1, b2) -> (int) (b2.getInterest() - b1.getInterest()));
        Collections.sort(books);
        for (Book book: books) {
            book.displayData();
        }
    }

    private static void showAllBook() {
        for (int i = 0; i < books.size(); i++) {
            books.get(i).displayData();
        }
    }

    private static void addBook() {
        System.out.println("Nhập số lượng sách bạn muốn thêm mới: ");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("Nhập sách thứ: " + (i+1));
            Book newBook = new Book();
            newBook.inputData();
            books.add(newBook);
        }
    }


}
