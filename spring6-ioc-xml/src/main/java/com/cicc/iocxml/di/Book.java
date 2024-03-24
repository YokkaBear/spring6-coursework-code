package com.cicc.iocxml.di;

public class Book {
    private String bookName;
    private String author;

    public Book() {
        System.out.println("无参构造方法执行了...");
    }
    public Book(String bookName, String author) {
        System.out.println("有参构造方法执行了...");
        this.bookName = bookName;
        this.author = author;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookName() {
        return this.bookName;
    }

    public String getAuthor() {
        return this.author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public static void main(String[] args) {
        /** 对象属性赋值（注入） Java原生写法 **/
        // 通过setter注入
        Book book = new Book();
        book.setBookName("Java");
        book.setAuthor("wyj");
        System.out.println(book.bookName + " " + book.author);

        // 通过constructor注入
        Book book1 = new Book("Kotlin", "wyj");
        System.out.println(book1.bookName + " " + book.author);

    }

}
