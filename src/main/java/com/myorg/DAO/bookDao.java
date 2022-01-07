package com.myorg.DAO;

import com.myorg.Model.Book;
import com.myorg.util.DButil;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class bookDao {

    public static void insert(Book book) {
        DButil dButil = DButil.getInstance();
        Connection connection = dButil.getConn();
        String sql = "insert into webserver.book values (?,?,?,?,?) ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, book.getBookId());
            preparedStatement.setString(2, book.getBookName());
            preparedStatement.setString(3, book.getType());
            preparedStatement.setString(4, book.getWriter());
            preparedStatement.setBytes(5, book.getBookPicture());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Book> select() {
        DButil dButil = DButil.getInstance();
        Connection connection = dButil.getConn();
        List<Book> list = new ArrayList<>();
        String sql = "select * from webserver.book";
        try {
            Statement statement = connection.createStatement();
            ResultSet rst = statement.executeQuery(sql);
            while (rst.next()) {
                int BookId = rst.getInt(1);
                String BookName = rst.getString(2);
                String BookType = rst.getString(3);
                String Writer = rst.getString(4);
                byte[] BookPicture = rst.getBytes(5);
                Book book = new Book(BookId, BookName, BookType, Writer, BookPicture);
                list.add(book);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
