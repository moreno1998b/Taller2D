/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorInterfaz;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author 57311
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button btnRombo;

    @FXML
    private Label label;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @FXML
    public void saludar(ActionEvent event) {
//        System.out.println("You clicked me!");
        System.out.println("hola mundo");
//        label.setText("Hello World!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//       btnRombo.getStylesheets().add("button");
        // TODO
    }

}
