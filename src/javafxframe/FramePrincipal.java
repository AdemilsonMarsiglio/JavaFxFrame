/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxframe;

import cadastro.FXMLCadastroClienteController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import padroes.InternalWindow;

/**
 *
 * @author Ademilsom
 */
public class FramePrincipal extends BorderPane {

    private static AnchorPane anchorPane = new AnchorPane();

    public FramePrincipal() {

        super();

        MenuBar mb = new MenuBar();

        Menu menuSistema = new Menu("Sistema");
        Menu menuProgramas = new Menu("Programas");

        MenuItem menuItemSair = new MenuItem("Sair");
        MenuItem menuItemPrograma1 = new MenuItem("Cadastro");

        menuSistema.getItems().add(menuItemSair);
        menuProgramas.getItems().add(menuItemPrograma1);

        mb.getMenus().addAll(menuSistema, menuProgramas);

        Button btnPrograma1 = new Button("Cadastro");

        btnPrograma1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    criaPrograma();
                } catch (IOException ex) {
                    Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        ToolBar toolBar = new ToolBar(btnPrograma1);

        BorderPane pnlSuperior = new BorderPane(toolBar, mb, null, null, null);

        super.setTop(pnlSuperior);
        super.setCenter(new BorderPane(anchorPane));
    }

    private void criaPrograma() throws IOException {
        InternalWindow internalWindow = new InternalWindow("Cadastro", "cadastro", FXMLLoader.load(FXMLCadastroClienteController.class.getResource("FXMLCadastroCliente.fxml")));

        
        if (verifica()) {
            anchorPane.getChildren().add(internalWindow);
        }
    }

    private boolean verifica() {

        ObservableList<Node> listRaiz = anchorPane.getChildren();

        for (Node node : listRaiz) {
            if (node instanceof InternalWindow) {

                if (((InternalWindow) node).getNome().equalsIgnoreCase("cadastro")) {
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setHeaderText("A janela já existe");
                    a.showAndWait();

                    ((InternalWindow) node).setMoveToFront(true);

                    return false;
                }
            }
        }

        return true;
    }
    
    public static double widthPanel(){
        return anchorPane.getWidth();
    }
    public static double heithPanel(){
        return anchorPane.getHeight();
    }

}
