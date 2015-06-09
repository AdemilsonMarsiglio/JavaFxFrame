/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxframe;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import jfxtras.labs.scene.control.window.CloseIcon;
import jfxtras.labs.scene.control.window.MinimizeIcon;
import jfxtras.labs.scene.control.window.Window;

/**
 *
 * @author Ademilson
 */
public class FXMLDocumentController implements Initializable {

    private Integer counter = 0;

    @FXML
    private Group grupo;
    
    @FXML
    private Button button;

    private String regiao;

    @FXML
    private void exibeAlert(ActionEvent event) {

        /*// o primeiro parâmetro é a escola padrão e os outros são os valores da Choice Box
        ChoiceDialog dialogoRegiao = new ChoiceDialog("Sul", "Sul", "Leste", "Oeste", "Norte");
        dialogoRegiao.setTitle("Entrada de Região");
        dialogoRegiao.initOwner(JavaFxFrame.getScene().getWindow());
        dialogoRegiao.setHeaderText("Informe sua região abaixo");
        dialogoRegiao.setContentText("Região:");

        Optional result = dialogoRegiao.showAndWait();
        
        if(result.isPresent()){
            result.ifPresent(t -> regiao = t.toString());
            
            Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.initOwner(JavaFxFrame.getScene().getWindow());
            dialogoInfo.setTitle("Diálogo de informação");
            dialogoInfo.setHeaderText("Esse é o cabeçalho...");
            dialogoInfo.setContentText("Regiao: " + regiao);
            dialogoInfo.showAndWait();
        }*/
        
        Window w = new Window("My Window#" + counter);
        // set the window position to 10,10 (coordinates inside canvas)
        w.setLayoutX(10);
        w.setLayoutY(10);
        // define the initial window size
        w.setPrefSize(300, 200);
        // either to the left
        w.getLeftIcons().add(new CloseIcon(w));
        // .. or to the right
        w.getRightIcons().add(new MinimizeIcon(w));
        // add some content
        w.getContentPane().getChildren().add(new Label("Content... \nof the window#" + counter++));
        // add the window to the canvas
        grupo.getChildren().add(w);
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        pnlAnchor.getChildren().add(new Label("Inserir um Desktop"));
//        pnlAnchor.setBackground(Background.EMPTY);
//        pnlAnchor.setStyle("-fx-background-color:white");
    }

}
