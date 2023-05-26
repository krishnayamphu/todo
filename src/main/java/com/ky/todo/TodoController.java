package com.ky.todo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.Optional;

public class TodoController {
    @FXML
    private TableColumn<Todo, Integer> id;

    @FXML
    private TableColumn<Todo, String> item;

    @FXML
    private TableView<Todo> tbl;

    @FXML
    private TextField txtbox;

    @FXML
    public void initialize(){
        loadData();
    }

    public void loadData(){
        ArrayList<Todo> todos=TodoDAO.getTodos();
        ObservableList<Todo> todolist = FXCollections.observableList(todos);
        id.setCellValueFactory(new PropertyValueFactory<Todo, Integer>("id"));
        item.setCellValueFactory(new PropertyValueFactory<Todo, String>("item"));
        tbl.setItems(todolist);
    }

    @FXML
    void addData(ActionEvent event) {
        if(!txtbox.getText().isEmpty()){
            String item=txtbox.getText();
            Todo todo=new Todo();
            todo.setItem(item);
            TodoDAO.addTodo(todo);
            loadData();
        }

    }

    @FXML
    void getData(MouseEvent event) {
        if(event.getButton().equals(MouseButton.PRIMARY)){
            if(event.getClickCount()==2){
              Todo todo= tbl.getSelectionModel().getSelectedItem();
                Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Are you sure delete this item?");
                alert.setContentText(String.valueOf(todo.getId()));
                Optional<ButtonType> result=alert.showAndWait();
                if(!result.isPresent()){
                    // alert is exited, no button has been pressed.
                }
                else if(result.get() == ButtonType.OK){
                   TodoDAO.deleteTodo(todo.getId());
                   loadData();
                }
                else if(result.get() == ButtonType.CANCEL){
                    System.out.println("cancel button is pressed");
                }


            }
        }
    }

}
