package com.myorg.Model;

import java.sql.Blob;

public class Book {

    private int bookId;
    private String bookName;
    private String Type;
    private String Writer;
    private byte[] BookPicture;

    public Book(int bookId, String bookName, String Type, String Writer, byte[] BookPicture) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.Type = Type;
        this.Writer = Writer;
        this.BookPicture = BookPicture;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getType() {
        return Type;
    }

    public String getWriter() {
        return Writer;
    }

    public byte[] getBookPicture() {
        return BookPicture;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setType(String type) {
        Type = type;
    }

    public void setWriter(String writer) {
        Writer = writer;
    }

    public void setBookPicture(byte[] bookPicture) {
        BookPicture = bookPicture;
    }
}