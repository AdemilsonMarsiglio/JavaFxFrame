package padroes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafxframe.FramePrincipal;
import jfxtras.labs.scene.control.window.CloseIcon;
import jfxtras.labs.scene.control.window.Window;
import jfxtras.labs.scene.control.window.WindowIcon;

/**
 *
 * @author Ademilsom
 */
public class InternalWindow extends Window{
    
    private String nome;
    private Node controle;

    private final double BEGIN_WIDTH;
    private final double BEGIN_HEIGTH;
    private boolean maximizado = false;
    
    public InternalWindow(String title, String nome, Node controle) {
        super(title);
        
        this.nome = nome;
        this.controle = controle;
        
        WindowIcon maximizeIcon = new WindowIcon();
        maximizeIcon.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                maximizeAction();
            }
        });
        
        WindowIcon minimizeIcon = new WindowIcon();
        minimizeIcon.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                boolean min = isMinimized();
                
                setMinimized(!min);
                getContentPane().setVisible(!min);
                
            }
        });
        
        setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        
        getRightIcons().addAll(minimizeIcon, maximizeIcon, new CloseIcon(this));
        
        
        
        super.setContentPane(new BorderPane(controle));
        
            
        
        BEGIN_WIDTH = super.getWidth();
        BEGIN_HEIGTH = super.getHeight();
        
        
        
    }

    public String getNome() {
        return nome;
    }
    
    private void maximizeAction(){
        
        double w = FramePrincipal.widthPanel();
        double h = FramePrincipal.heithPanel();
        if (getWidth() < w || getHeight() < h) {
            setPrefSize(w, h);
            setLayoutX(0);
            setLayoutY(0);
        } else {
            setPrefSize(BEGIN_WIDTH, BEGIN_HEIGTH);
            setLayoutX(0);
            setLayoutY(0);
        }
    }

    
    
    /**
     * w.getStylesheets().add("internalWindow.css");
        
        w.setTitleBarStyleClass("custom-window-titlebar");
     */
    
}
