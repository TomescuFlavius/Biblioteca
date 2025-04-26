package app.books.services;

import app.books.models.Book;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookService {
    private File bookFile;
    private List<Book> books;
    public BookService() {
        bookFile = new File("C:\\mycode\\oop\\Biblioteca\\src\\app\\books\\file\\BookFile");
        books = new ArrayList<Book>();
        this.loadBooks();
    }
    public void loadBooks() {
        try{
            Scanner scanner = new Scanner(bookFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Book book = new Book(line);
                books.add(book);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void showBooks(){
        for (Book book : books) {
            System.out.println(book.descriere());
        }
    }

    public void saveBook(){
        try {
            FileWriter fileWriter = new FileWriter(bookFile);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(books);
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public String toSaveBooks(){
        String result = "";
        int i;
        for(i=0; i<books.size(); i++){
            result += books.get(i).descriere();
        }
        return result+books.get(i).descriere();
    }

    public void addBook(Book book){
        books.add(book);
        saveBook();
    }
}
