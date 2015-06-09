/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internalWindow;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Ademilson
 */
public class Aplicacao extends Application {

    private InternalWindow constructWindow() {
        // content
        ImageView imageView = new ImageView("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a9/Cheetah4.jpg/250px-Cheetah4.jpg");
        // title bar
        BorderPane titleBar = new BorderPane();
        titleBar.setStyle("-fx-background-color: green; -fx-padding: 3");
        Label label = new Label("header");
        titleBar.setLeft(label);
        Button closeButton = new Button("x");
        titleBar.setRight(closeButton);
        // title bat + content
        BorderPane windowPane = new BorderPane();
        windowPane.setStyle("-fx-border-width: 1; -fx-border-color: black");
        windowPane.setTop(titleBar);
        windowPane.setCenter(imageView);

        //apply layout to InternalWindow
        InternalWindow internalWindow = new InternalWindow();
        internalWindow.setRoot(windowPane);
        //drag only by title
        internalWindow.makeDragable(titleBar);
        internalWindow.makeDragable(label);
        internalWindow.makeResizable(20);
        internalWindow.makeFocusable();
        return internalWindow;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();
        root.getChildren().add(constructWindow());
        root.getChildren().add(constructWindow());
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
