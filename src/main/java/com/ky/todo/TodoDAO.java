package com.ky.todo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TodoDAO {
    public static ArrayList<Todo> getTodos() {
        ArrayList<Todo> todos = new ArrayList<>();
        try {
            Connection cn = ConnectDB.connect();
            String sql = "SELECT * FROM todolist";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Todo todo = new Todo();
                todo.setId(rs.getInt("id"));
                todo.setItem(rs.getString("items"));
                todo.setStatus((rs.getBoolean("status")));
                todo.setCreatedDate(rs.getString("created_date"));
                todos.add(todo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return todos;
    }
    public static void addTodo(Todo todo) {
        try {
            Connection cn = ConnectDB.connect();
            String sql = "INSERT INTO todolist (items) values(?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,todo.getItem());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteTodo(int id) {
        try {
            Connection cn = ConnectDB.connect();
            String sql = "DELETE  FROM todolist WHERE id=?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
