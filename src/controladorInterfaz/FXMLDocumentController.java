/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorInterfaz;

import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import modelo.Figura2D;
import modelo.Puntos2D;

/**
 *
 * @author 57311
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Canvas canvas;
    @FXML
    private Button btnRombo;

    @FXML
    private Button btnOctagono;

    @FXML
    private Button btnPentagono;
    @FXML
    private Button btnHexagono;
    @FXML
    private Button btnHeptagono;
    @FXML
    private Button btnPacman;
    @FXML
    private ColorPicker colorLineado;
    @FXML
    private ColorPicker colorRelleno;

    @FXML
    private Label labelLineado;

    @FXML
    private Label labelRelleno;
    private GraphicsContext lienzo;
    private Color c;
    private Color c2;
    HashMap<String, LinkedList<Puntos2D>> mapFiguras;
    LinkedList<Puntos2D> listapuntosFigura;
    double coordx;
    double coordy;
    double[] arrayx;
    double[] arrayy;

    @FXML
    private void handleButtonAction(ActionEvent event) {

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
        lienzo = canvas.getGraphicsContext2D();
        mapFiguras = new HashMap<>();
        // TODO
    }

    @FXML
    private void changeColorLineado(ActionEvent event) {
        c = colorLineado.getValue();
//        c2 = colorRelleno.getValue();
//       Color blue = new Color(c.getRed(), c.getGreen(), c.getBlue(), c.getOpacity());
        System.out.println(c);
    }

    @FXML
    private void changeColorRelleno(ActionEvent event) {
//        c = colorLineado.getValue();
        c2 = colorRelleno.getValue();
        System.out.println(c2);
    }

    @FXML
    private void crearHexagono(MouseEvent event) {
        LinkedList<Puntos2D> lista = new LinkedList<>();
        LinkedList<Figura2D> listaf = new LinkedList<>();

        arrayx = new double[6];
        arrayy = new double[6];

//
//        listapuntosFigura = new LinkedList<>();
//        double[] coordenadasx = {coordx + 200, x + 400, x + 450, x + 400, x + 200, x + 150};
//        double[] coordenadasy = {y + 50, y + 50, y + 150, y + 250, y + 250, y + 150};
//
//        lienzo.setLineWidth(1);
//        lienzo.setStroke(c);
//        lienzo.strokePolygon(coordenadasx, coordenadasy, 6);
//        lienzo.setStroke(c2);
//
//        for (int i = 0; i < coordenadasy.length; i++) {
//            listapuntosFigura.add(new Puntos2D(coordenadasx[i], coordenadasy[i], colorRelleno.getValue(), colorLineado.getValue()));
//
//        }
//        mapFiguras.put("Hexagono", listapuntosFigura);
    }

    @FXML
    private void obtenerCoordenadas(MouseEvent event) {
        coordx = event.getX();
        coordy = event.getY();
        System.out.println(coordx + "-" + coordy);
    }

    public double getCoordx() {
        return coordx;
    }

    public void setCoordx(double coordx) {
        this.coordx = coordx;
    }

    public double getCoordy() {
        return coordy;
    }

    public void setCoordy(double coordy) {
        this.coordy = coordy;
    }

}
