package com.example.dictionary;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


import java.io.IOException;

public class HelloApplication extends Application {


    DictionaryUsingHashMap  dictionaryUsingHashMap= new DictionaryUsingHashMap();
    ListView<String> suggestionList;

    Pane createContent(){
        Pane root = new Pane();
        root.setPrefSize(400,600);   // size of search box

        TextField wordTextField = new TextField();
        wordTextField.setTranslateX(20);
        wordTextField.setTranslateY(30);

        Label meaningLabel = new Label("I am meaning");
        meaningLabel.setTranslateX(20);
        meaningLabel.setTranslateY(60);

        Button searchButton = new Button("Search");
        searchButton.setTranslateX(200);
        searchButton.setTranslateY(30);
       searchButton.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent actionEvent) {
//               meaningLabel.setText("Button is clicked");
//               wordTextField.getText();
               String word = wordTextField.getText();
               if (word.isBlank() || word.isEmpty()) {
                   meaningLabel.setText("Please enter a word!");
                   meaningLabel.setTextFill(Color.RED);
               } else {
                   String meaning = dictionaryUsingHashMap.getMeaning(word);
                   meaningLabel.setText(meaning);
                   meaningLabel.setTextFill(Color.BLACK);    // it is for color of label
               }
           }
       });

      ListView<String> suggestionList = new ListView<>();
        suggestionList.setTranslateX(20);
        suggestionList.setTranslateY(100);
        suggestionList.setMinSize(330,50);
        suggestionList.setMaxSize(400,50);
        String[] WordList= {"complex","project","phase", "whole"};
        // fetch from a trie or database or list and bind to ListView as below.

        suggestionList.getItems().addAll(WordList);
        suggestionList.setOrientation(Orientation.HORIZONTAL);  // for orientation of suggestion list

        suggestionList.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                String selectedWord = suggestionList.getSelectionModel().getSelectedItem();
                meaningLabel.setText(selectedWord);
                // on click find the meaning and display it.
            }
        });
        root.getChildren().addAll(wordTextField,searchButton,meaningLabel,suggestionList);

        return root;
    }
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(createContent());
        stage.setTitle("Dictionary!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}