package app.books.services;

import app.books.models.Book;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BookService {
    private File bookFile;
    private List<Book> books;

    public BookService() {
        bookFile = new File("C:\\mycode\\oop\\Biblioteca\\src\\app\\books\\file\\books.txt");
        books = new ArrayList<Book>();
        this.loadBooks();
    }

    public void loadBooks() {
        try {
            Scanner scanner = new Scanner(bookFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Book book = new Book(line);
                books.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showBooks() {
        for (Book book : books) {
            System.out.println(book.descriere());
        }
    }

    public void saveBook() {
        try {
            FileWriter fileWriter = new FileWriter(bookFile);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(toSaveBooks());
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String toSaveBooks() {
        String result = "";
        int i;
        for (i = 0; i < books.size()-1; i++) {
            result += books.get(i).toSave()+"\n";
        }
        return result + books.get(i).toSave();
    }

    public void addBook(Book book) {
        book.setId(generateId());
        books.add(book);
        saveBook();
    }

    //todo:get book by id
    public Book getBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    private int generateId() {
        Random random = new Random();
        int randomId = random.nextInt(1000) + 1;
        while (this.getBookById(randomId) != null) {
            randomId = random.nextInt(1000) + 1;
        }
        return randomId;
    }

    //todo:getBookByName
    public Book getBookByName(String name) {
        for(int i=0;i<books.size();i++) {
            if (books.get(i).getName().equals(name)) {
                return books.get(i);
            }
        }
        return null;
    }
    public void deleteBookByName(String name) {
        if (this.getBookByName(name) != null) {
            books.remove(this.getBookByName(name));
        }
    }


    public void editBook(int id,String nume,String data) {
        for (Book book1 : books) {
            if (book1.getId() == id) {
                book1.setName(nume);
                book1.setAddedDate(data);
            }
        }
    }

    public List<Book> getBooksByStudentId(int id) {
        List<Book> filteredBooks = new ArrayList<>();
        for (Book book  :books) {
            if (book.getStudentId() == id) {
                filteredBooks.add(book);
            }
        }
        return filteredBooks;
    }
}

