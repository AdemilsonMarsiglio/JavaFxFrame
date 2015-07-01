/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxframe;

import cadastro.FXMLCadastroClienteController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import jfxtras.labs.scene.control.window.Window;
import padroes.InternalWindow;

/**
 *
 * @author Ademilson
 */
public class FXMLDocumentController implements Initializable {

    private Integer counter = 0;

    @FXML
    private AnchorPane anchor;

    @FXML
    private Button button;

    private String regiao;
    
    Window w;

    @FXML
    private void exibeAlert(ActionEvent event) throws IOException {

        InternalWindow internalWindow = new InternalWindow("Cadastro", "cadastro", FXMLLoader.load(FXMLCadastroClienteController.class.getResource("FXMLCadastroCliente.fxml")));
        
        if(verifica()){
            anchor.getChildren().add(internalWindow);
        }
    }
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        pnlAnchor.getChildren().add(new Label("Inserir um Desktop"));
//        pnlAnchor.setBackground(Background.EMPTY);
//        pnlAnchor.setStyle("-fx-background-color:white");
    }
    
    private boolean verifica(){
        
        ObservableList<Node> listRaiz =  anchor.getChildren();
        
        for (Node node : listRaiz) {
            if(node instanceof InternalWindow){
                
                if(((InternalWindow)node).getNome().equalsIgnoreCase("cadastro")){
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setHeaderText("A janela já existe");
                    a.showAndWait();

                    ((InternalWindow)node).setMoveToFront(true);
                    
                    return false;
                }       
            }
        }
     
        return true;
    }

}
