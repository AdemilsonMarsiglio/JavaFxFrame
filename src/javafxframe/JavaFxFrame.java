package javafxframe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Ademilson
 */
public class JavaFxFrame extends Application {
    
    private static Scene scene;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Aplicação JavaFx");
        stage.setMinHeight(600);
        stage.setMinWidth(800);
        
        stage.getIcons().add(new Image(this.getClass().getResource("logo.png").toString()));
        
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public static Scene getScene() {
        return scene;
    }    
}
