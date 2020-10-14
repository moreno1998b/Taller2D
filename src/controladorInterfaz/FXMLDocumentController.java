/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrador
 *
 *
 *
 * @author Jairo Vergara Portocarrero 2151714
 * @author Jorge Moreno 2175321
 * @author Sebastian Bejarano 2190853
 *
 *
 * @date 9 Octubre 2020
 * @version 1.0
 */
package controladorInterfaz;

import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.shape.ArcType;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import modelo.Figura2D;
import modelo.GuardadoXml;
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
    private Integer contadorPentagono = 0;
    private Integer contadorO = 0;
    private Integer contadorHeptagono = 0;
    private Integer contadorPacman = 0;
    HashMap<String, LinkedList<Puntos2D>> mapFiguras;
    LinkedList<Puntos2D> listapuntosFigura;
    double coordx;
    double coordy;
    double[] arrayx;
    double[] arrayy;
    private String comodin;

    @FXML
    private void handleButtonAction(ActionEvent event) {

    }

    @FXML
    private void leerArchivo(ActionEvent event) {

    }

//    @FXML
    private void crearRombo() {
        LinkedList<Puntos2D> lista = new LinkedList<>();
        LinkedList<Figura2D> listaf = new LinkedList<>();
        listapuntosFigura = new LinkedList<>();
        arrayx = new double[4];
        arrayy = new double[4];

        int radio = 50;

        lienzo.setLineWidth(3);
        arrayx[0] = (coordx + radio);
        arrayy[0] = (coordy);

        arrayx[1] = coordx + radio * Math.cos(2 * Math.PI / 4);
        arrayy[1] = coordy + radio * Math.sin(2 * Math.PI / 4);

        arrayx[2] = coordx + radio * Math.cos(2 * 2 * Math.PI / 4);
        arrayy[2] = coordy + radio * Math.sin(2 * 2 * Math.PI / 4);

        arrayx[3] = coordx + radio * Math.cos(3 * 2 * Math.PI / 4);
        arrayy[3] = coordy + radio * Math.sin(3 * 2 * Math.PI / 4);
        if (c == null) {
//            Color color = new Color(1.0, 1.0, 0.3019608, 1.0);
            Color c3 = Color.CORAL;
            c = c3;
        }
        lienzo.setStroke(c);

        lienzo.fillPolygon(arrayx, arrayx, 4);
        lienzo.strokePolygon(arrayx, arrayy, 4);
//
        lienzo.fillPolygon(arrayx, arrayx, 4);
        for (int i = 0; i < arrayx.length; i++) {
            listapuntosFigura.add(new Puntos2D(arrayx[i], arrayy[i], c, c));

        }
        mapFiguras.put("Rombo" + contadorR, listapuntosFigura);
        contadorR++;

    }

    private void crearOctagono() {
        LinkedList<Puntos2D> lista = new LinkedList<>();
        LinkedList<Figura2D> listaf = new LinkedList<>();
        listapuntosFigura = new LinkedList<>();
        arrayx = new double[8];
        arrayy = new double[8];

        int radio = 50;
        lienzo.setLineWidth(3);
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
        if (c == null) {
//            Color color = new Color(1.0, 1.0, 0.3019608, 1.0);
            Color c3 = Color.CORAL;
            c = c3;
        }
        lienzo.setStroke(c);
        lienzo.fillPolygon(arrayx, arrayx, 8);
        lienzo.strokePolygon(arrayx, arrayy, 8);
//
        lienzo.setFill(c);
        for (int i = 0; i < arrayx.length; i++) {
            listapuntosFigura.add(new Puntos2D(arrayx[i], arrayy[i], c, c));

        }
        mapFiguras.put("Octagono" + contadorO, listapuntosFigura);
        contadorO++;

    }

    @FXML
    private void llenarvarRombo(ActionEvent event) {
        comodin = "Rombo";
    }

    @FXML
    private void llenarvarOctagono(ActionEvent event) {
        comodin = "Octagono";
    }

    @FXML
    private void llenarvarPentagono(ActionEvent event) {
        comodin = "Pentagono";
    }

    @FXML
    private void llenarvarHexagono(ActionEvent event) {
        comodin = "Hexagono";
    }

    @FXML
    private void llenarvarHeptagono(ActionEvent event) {
        comodin = "Heptagono";
    }

    @FXML
    private void llenarvarPacman(ActionEvent event) {
        comodin = "Pacman";
    }

//    @FXML
    private void dibujarFigura() {
        if (comodin == null) {
            JOptionPane.showMessageDialog(null, "Por favor seleccione  una figura");
        } else {
            switch (comodin) {
                case "Rombo":
                    crearRombo();
                    break;
                case "Octagono":
                    crearOctagono();
                    break;
                case "Pentagono":
                    crearPentagono();
                    break;
                case "Hexagono":
                    crearHexagono();
                    break;
                case "Heptagono":
                    crearHeptagono();

                    break;
                case "Pacman":
                    crearPacman();
                    break;

                // code block
            }
        }

    }

    private void crearPentagono() {
        LinkedList<Puntos2D> lista = new LinkedList<>();
        LinkedList<Figura2D> listaf = new LinkedList<>();
        listapuntosFigura = new LinkedList<>();
        arrayx = new double[5];
        arrayy = new double[5];

        int radio = 50;
        lienzo.setLineWidth(3);
        arrayx[0] = (coordx + radio);
        arrayy[0] = (coordy);

        arrayx[1] = coordx + radio * Math.cos(2 * Math.PI / 5);
        arrayy[1] = coordy + radio * Math.sin(2 * Math.PI / 5);

        arrayx[2] = coordx + radio * Math.cos(2 * 2 * Math.PI / 5);
        arrayy[2] = coordy + radio * Math.sin(2 * 2 * Math.PI / 5);

        arrayx[3] = coordx + radio * Math.cos(3 * 2 * Math.PI / 5);
        arrayy[3] = coordy + radio * Math.sin(3 * 2 * Math.PI / 5);

        arrayx[4] = coordx + radio * Math.cos(4 * 2 * Math.PI / 5);
        arrayy[4] = coordy + radio * Math.sin(4 * 2 * Math.PI / 5);
        if (c == null) {
            Color c3 = Color.CORAL;
            c = c3;
        }
        lienzo.setStroke(c);
        lienzo.setLineWidth(3);
        lienzo.strokePolygon(arrayx, arrayy, 5);
        lienzo.fillPolygon(arrayx, arrayx, 5);

        for (int i = 0; i < arrayx.length; i++) {
            listapuntosFigura.add(new Puntos2D(arrayx[i], arrayy[i], c, c));

        }
        mapFiguras.put("Pentagono" + contadorPentagono, listapuntosFigura);
        contadorPentagono++;

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listapuntosFigura = new LinkedList<>();
        lienzo = canvas.getGraphicsContext2D();
        mapFiguras = new HashMap<>();
        // TODO
    }

    @FXML
    private void changeColorLineado(ActionEvent event) {
        c = colorLineado.getValue();

    }

    @FXML
    private void changeColorRelleno(ActionEvent event) {
        c2 = colorRelleno.getValue();

    }

    public void crearPacman() {
        listapuntosFigura = new LinkedList<>();
        int radio = 50;
        lienzo.setStroke(c);
        lienzo.setLineWidth(3);

        lienzo.strokeArc(coordx, coordy, radio * 2, radio * 2, 45, 290, ArcType.ROUND);

        int radio2 = 5;
        if (c == null) {
            Color c3 = Color.CORAL;
            c = c3;
        }
        lienzo.setStroke(Color.BLACK);
        lienzo.setFill(Color.BLACK);
        lienzo.setLineWidth(3);
        lienzo.fillOval(coordx + 50, coordy + 20, radio2 * 2, radio2 * 2);
        lienzo.strokeOval(coordx + 50, coordy + 20, radio2 * 2, radio2 * 2);

        Puntos2D punto = new Puntos2D(coordx + 50, coordy + 20, c, c);
        listapuntosFigura.add(punto);

        mapFiguras.put("Pacman" + contadorPacman, listapuntosFigura);
        contadorPacman++;
    }

    @FXML
    private void guardarArchivo(ActionEvent event) {

        boolean t = GuardadoXml.guardarArchivoXML(mapFiguras);
        if (t) {
            JOptionPane.showMessageDialog(null, "Archivo Creado con exito");
        } else {
            JOptionPane.showMessageDialog(null, "Archivo No Creado");
        }
    }

    @FXML
    private void leerArchivoxml(ActionEvent event) {

        HashMap<String, LinkedList<Puntos2D>> mapF = GuardadoXml.leerArchivo();

        Iterator<Map.Entry<String, LinkedList<Puntos2D>>> entries = mapF.entrySet().iterator();
        Color color = null;
        while (entries.hasNext()) {
            Map.Entry<String, LinkedList<Puntos2D>> elemento = entries.next();
            double[] coordenadasx = new double[elemento.getValue().size()];
            double[] coordenadasy = new double[elemento.getValue().size()];

            for (int i = 0; i < elemento.getValue().size(); i++) {
                Puntos2D punto = elemento.getValue().get(i);
                color = elemento.getValue().get(i).getColorResaltado();
                coordenadasx[i] = punto.getX();
                coordenadasy[i] = punto.getY();
            }
            lienzo.setLineWidth(3);
            lienzo.setStroke(color);
//            lienzo.setFill(color);
//            lienzo.fillPolygon(coordenadasx, coordenadasy, elemento.getValue().size());
            lienzo.strokePolygon(coordenadasx, coordenadasy, elemento.getValue().size());

            if (elemento.getValue().size() == 1) {
                int radio = 50;
                lienzo.strokeArc(coordenadasx[0], coordenadasy[0], radio * 2, radio * 2, 45, 290, ArcType.ROUND);
                int radio2 = 5;
                lienzo.setLineWidth(3);
                lienzo.setStroke(Color.BLACK);
                lienzo.setFill(Color.BLACK);
                lienzo.strokeOval(coordenadasx[0] + 50, coordenadasy[0] + 20, radio2 * 2, radio2 * 2);
                lienzo.fillOval(coordenadasx[0] + 50, coordenadasy[0] + 20, radio2 * 2, radio2 * 2);
            }
        }
    }

    @FXML
    private void guardarPNG(ActionEvent event) throws IOException {

        WritableImage image = canvas.snapshot(null, null);
        String desktopPath = System.getProperty("user.home").replace("\\", "/") + "/Desktop/image.png";

        ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", new File(desktopPath));
    }

    @FXML
    private void guardarJPG(ActionEvent event) throws IOException {
        WritableImage image = canvas.snapshot(null, null);
        String desktopPath = System.getProperty("user.home").replace("\\", "/") + "/Desktop/image.jpg";
        ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", new File(desktopPath));
    }

    private void crearHexagono() {
        LinkedList<Puntos2D> lista = new LinkedList<>();
        LinkedList<Figura2D> listaf = new LinkedList<>();
        listapuntosFigura = new LinkedList<>();
        arrayx = new double[6];
        arrayy = new double[6];

// 
        int radio2 = 50;

        arrayx[0] = (coordx + radio2);
        arrayy[0] = (coordy);

        arrayx[1] = coordx + radio2 * Math.cos(2 * Math.PI / 6);
        arrayy[1] = coordy + radio2 * Math.sin(2 * Math.PI / 6);

        arrayx[2] = coordx + radio2 * Math.cos(2 * 2 * Math.PI / 6);
        arrayy[2] = coordy + radio2 * Math.sin(2 * 2 * Math.PI / 6);

        arrayx[3] = coordx + radio2 * Math.cos(3 * 2 * Math.PI / 6);
        arrayy[3] = coordy + radio2 * Math.sin(3 * 2 * Math.PI / 6);

        arrayx[4] = coordx + radio2 * Math.cos(4 * 2 * Math.PI / 6);
        arrayy[4] = coordy + radio2 * Math.sin(4 * 2 * Math.PI / 6);

        arrayx[5] = coordx + radio2 * Math.cos(5 * 2 * Math.PI / 6);
        arrayy[5] = coordy + radio2 * Math.sin(5 * 2 * Math.PI / 6);
        if (c == null) {
            Color c3 = Color.CORAL;
            c = c3;
        }
        lienzo.setStroke(c);
        lienzo.fillPolygon(arrayx, arrayx, 6);
        lienzo.strokePolygon(arrayx, arrayy, 6);

        for (int i = 0; i < arrayx.length; i++) {
            listapuntosFigura.add(new Puntos2D(arrayx[i], arrayy[i], c, c));

        }
        mapFiguras.put("Hexagono" + contadorH, listapuntosFigura);
        contadorH++;
    }

    private void crearHeptagono() {
        listapuntosFigura = new LinkedList<>();
        LinkedList<Puntos2D> lista = new LinkedList<>();
        LinkedList<Figura2D> listaf = new LinkedList<>();

        arrayx = new double[7];
        arrayy = new double[7];

        int radio = 50;
        lienzo.setLineWidth(3);
        arrayx[0] = (coordx + radio);
        arrayy[0] = (coordy);

        arrayx[1] = coordx + radio * Math.cos(2 * Math.PI / 7);
        arrayy[1] = coordy + radio * Math.sin(2 * Math.PI / 7);

        arrayx[2] = coordx + radio * Math.cos(2 * 2 * Math.PI / 7);
        arrayy[2] = coordy + radio * Math.sin(2 * 2 * Math.PI / 7);

        arrayx[3] = coordx + radio * Math.cos(3 * 2 * Math.PI / 7);
        arrayy[3] = coordy + radio * Math.sin(3 * 2 * Math.PI / 7);

        arrayx[4] = coordx + radio * Math.cos(4 * 2 * Math.PI / 7);
        arrayy[4] = coordy + radio * Math.sin(4 * 2 * Math.PI / 7);

        arrayx[5] = coordx + radio * Math.cos(5 * 2 * Math.PI / 7);
        arrayy[5] = coordy + radio * Math.sin(5 * 2 * Math.PI / 7);

        arrayx[6] = coordx + radio * Math.cos(6 * 2 * Math.PI / 7);
        arrayy[6] = coordy + radio * Math.sin(6 * 2 * Math.PI / 7);
        if (c == null) {
            Color c3 = Color.CORAL;
            c = c3;
        }
        lienzo.setStroke(c);
        lienzo.fillPolygon(arrayx, arrayx, 7);
        lienzo.strokePolygon(arrayx, arrayy, 7);

        for (int i = 0; i < arrayx.length; i++) {
            listapuntosFigura.add(new Puntos2D(arrayx[i], arrayy[i], c, c));

        }
        contadorHeptagono++;
        mapFiguras.put("Heptagono" + contadorHeptagono, listapuntosFigura);
    }

    @FXML
    private void obtenerCoordenadas(MouseEvent event) {
        coordx = event.getX();
        coordy = event.getY();
        dibujarFigura();
        //System.out.println(coordx + "-" + coordy);
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

    public String getComodin() {
        return comodin;
    }

    public void setComodin(String comodin) {
        this.comodin = comodin;
    }

}
