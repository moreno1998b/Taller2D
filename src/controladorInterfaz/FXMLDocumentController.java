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
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
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
    private Integer contadorH = 0;
    private Integer contadorP = 0;
    private Integer contadorR = 0;
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
    private void crearRombo(MouseEvent event) {
        LinkedList<Puntos2D> lista = new LinkedList<>();
        LinkedList<Figura2D> listaf = new LinkedList<>();

        arrayx = new double[4];
        arrayy = new double[4];

        lienzo.setLineWidth(3);

        int radio = 50;

        arrayx[0] = (coordx + radio);
        arrayy[0] = (coordy);

        arrayx[1] = coordx + radio * Math.cos(2 * Math.PI / 4);
        arrayy[1] = coordy + radio * Math.sin(2 * Math.PI / 4);

        arrayx[2] = coordx + radio * Math.cos(2 * 2 * Math.PI / 4);
        arrayy[2] = coordy + radio * Math.sin(2 * 2 * Math.PI / 4);

        arrayx[3] = coordx + radio * Math.cos(3 * 2 * Math.PI / 4);
        arrayy[3] = coordy + radio * Math.sin(3 * 2 * Math.PI / 4);

//        arrayx[4] = coordx + radio * Math.cos(4 * 2 * Math.PI / 6);
//        arrayy[4] = coordy + radio * Math.sin(4 * 2 * Math.PI / 6);
//        
//        arrayx[5] = coordx + radio * Math.cos(5 * 2 * Math.PI / 6);
//        arrayy[5] = coordy + radio * Math.sin(5 * 2 * Math.PI / 6);
        lienzo.setStroke(c);
        lienzo.strokePolygon(arrayx, arrayy, 4);
        BackgroundFill bgfill = new BackgroundFill(c, CornerRadii.EMPTY, Insets.EMPTY);
        lienzo.setFill(c);
        lienzo.setFill(c);
        lienzo.setStroke(c2);
        lienzo.setLineWidth(1);
//
        lienzo.fillPolygon(arrayx, arrayx, 4);
        lienzo.setFill(c2);
        for (int i = 0; i < arrayx.length; i++) {
            listapuntosFigura.add(new Puntos2D(arrayx[i], arrayy[i], c, c2));
            mapFiguras.put("Rombo" + contadorR, listapuntosFigura);
            contadorR++;

        }

    }

    @FXML
    private void crearOctagono(MouseEvent event) {
        LinkedList<Puntos2D> lista = new LinkedList<>();
        LinkedList<Figura2D> listaf = new LinkedList<>();

        arrayx = new double[8];
        arrayy = new double[8];

        lienzo.setLineWidth(3);

        int radio = 50;

        arrayx[0] = (coordx + radio);
        arrayy[0] = (coordy);

        arrayx[1] = coordx + radio * Math.cos(2 * Math.PI / 8);
        arrayy[1] = coordy + radio * Math.sin(2 * Math.PI / 8);

        arrayx[2] = coordx + radio * Math.cos(2 * 2 * Math.PI / 8);
        arrayy[2] = coordy + radio * Math.sin(2 * 2 * Math.PI / 8);

        arrayx[3] = coordx + radio * Math.cos(3 * 2 * Math.PI / 8);
        arrayy[3] = coordy + radio * Math.sin(3 * 2 * Math.PI / 8);

        arrayx[4] = coordx + radio * Math.cos(4 * 2 * Math.PI / 8);
        arrayy[4] = coordy + radio * Math.sin(4 * 2 * Math.PI / 8);

        arrayx[5] = coordx + radio * Math.cos(5 * 2 * Math.PI / 8);
        arrayy[5] = coordy + radio * Math.sin(5 * 2 * Math.PI / 8);

        arrayx[6] = coordx + radio * Math.cos(6 * 2 * Math.PI / 8);
        arrayy[6] = coordy + radio * Math.sin(6 * 2 * Math.PI / 8);

        arrayx[7] = coordx + radio * Math.cos(7 * 2 * Math.PI / 8);
        arrayy[7] = coordy + radio * Math.sin(7 * 2 * Math.PI / 8);

        lienzo.setStroke(c);
        lienzo.strokePolygon(arrayx, arrayy, 8);
        lienzo.setFill(c);
        lienzo.setFill(c);
        lienzo.setStroke(c2);
        lienzo.setLineWidth(1);
//
        lienzo.fillPolygon(arrayx, arrayx, 8);
        lienzo.setFill(c2);
        for (int i = 0; i < arrayx.length; i++) {
            listapuntosFigura.add(new Puntos2D(arrayx[i], arrayy[i], c, c2));
            mapFiguras.put("Octagono" + contadorP, listapuntosFigura);
            contadorR++;

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//       btnRombo.getStylesheets().add("button");
        listapuntosFigura = new LinkedList<>();
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
//        lienzo.setStroke(c);
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

        lienzo.setLineWidth(3);

        int radio = 50;

        arrayx[0] = (coordx + radio);
        arrayy[0] = (coordy);

        arrayx[1] = coordx + radio * Math.cos(2 * Math.PI / 6);
        arrayy[1] = coordy + radio * Math.sin(2 * Math.PI / 6);

        arrayx[2] = coordx + radio * Math.cos(2 * 2 * Math.PI / 6);
        arrayy[2] = coordy + radio * Math.sin(2 * 2 * Math.PI / 6);

        arrayx[3] = coordx + radio * Math.cos(3 * 2 * Math.PI / 6);
        arrayy[3] = coordy + radio * Math.sin(3 * 2 * Math.PI / 6);

        arrayx[4] = coordx + radio * Math.cos(4 * 2 * Math.PI / 6);
        arrayy[4] = coordy + radio * Math.sin(4 * 2 * Math.PI / 6);

        arrayx[5] = coordx + radio * Math.cos(5 * 2 * Math.PI / 6);
        arrayy[5] = coordy + radio * Math.sin(5 * 2 * Math.PI / 6);
        lienzo.setStroke(c);
        lienzo.strokePolygon(arrayx, arrayy, 6);
        lienzo.setFill(c);
        lienzo.setFill(c2);
        lienzo.setStroke(c2);
        lienzo.setLineWidth(1);
//
        lienzo.fillPolygon(arrayx, arrayx, 6);
        lienzo.setFill(c2);
        for (int i = 0; i < arrayx.length; i++) {
            listapuntosFigura.add(new Puntos2D(arrayx[i], arrayy[i], c, c2));
            mapFiguras.put("Hexagono" + contadorH, listapuntosFigura);
            contadorH++;

        }

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
