/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author Administrador
 */
public class GuardadoXml {
     static Document doc;

    public static boolean crearArchivoXML(HashMap<String, LinkedList<Puntos2D>> mp, Stage stage) {
        /**
         * crearArchivoXML.
         *
         * Método para crear un archivo XML con los puntos x e y que se han
         * creado en el lienzo.
         */
        boolean t = false;

        Element figurasgeometricas = new Element("FigurasGeometricas");
        doc = new Document(figurasgeometricas);

        Iterator<Map.Entry<String, LinkedList<Puntos2D>>> it = mp.entrySet().iterator();

        int cont = 0;

        while (it.hasNext()) {
            Map.Entry<String, LinkedList<Puntos2D>> pair = it.next();
            Element figura = new Element("figura");
            figura.setAttribute("nombre", pair.getKey());
            LinkedList<Puntos2D> lp = pair.getValue();

            figura.addContent(new Element("Colores").setAttribute("Color de Relleno", String.valueOf(lp.get(cont).colorRelleno)));
            figura.addContent(new Element("Colores").setAttribute("Color de Resaltado", String.valueOf(lp.get(cont).colorResaltado)));
            Puntos2D get = lp.get(cont);

            doc.getRootElement().addContent(figura);
            cont++;

        }
        XMLOutputter xmlOutput = new XMLOutputter();
        xmlOutput.setFormat(Format.getPrettyFormat());
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files(*XML)", "*xml");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showSaveDialog(stage);

        try {
            if (file != null) {
                xmlOutput.output(doc, new FileWriter(file));
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar archivo" + ex.toString());
        }

        t = true;

        return t;
    }

    public static LinkedList leerArchivoXML(File file) throws JDOMException {
        /**
         * leerArchivoXML.
         *
         * Lee el archivo XML con los puntos en x , y para luego poder
         * construirlo y mostrarlo en el lienzo.
         */
        

        SAXBuilder saxBuilder = new SAXBuilder();
        File xmlFile = new File(file.toURI());
        LinkedList<Puntos2D> Puntos = new LinkedList<>();
        Puntos2D Figura;

        try {

            Document document = (Document) saxBuilder.build(xmlFile);
            Element rootElement = document.getRootElement();
            List ListPuntos = rootElement.getChildren("figura");

            for (int j = 0; j < ListPuntos.size(); j++) {

                Element figura = (Element) ListPuntos.get(j);
                ListPuntos = figura.getChildren("Puntos");
                List Colores = figura.getChildren("Colores");
                double[] fx = new double[ListPuntos.size()];
                double[] fy = new double[ListPuntos.size()];

                Element Color1 = (Element) Colores.get(0);
                Element Color2 = (Element) Colores.get(1);
                String CRelleno = Color1.getAttributeValue("Color de Relleno");
                String CResaltado = Color2.getAttributeValue("Color de Resaltado");

                for (int k = 0; k < ListPuntos.size(); k++) {

                    Element Punto = (Element) ListPuntos.get(k);
                    String x = Punto.getAttributeValue("x");
                    String y = Punto.getAttributeValue("y");
                    fx[k] = Double.parseDouble(x);
                    fy[k] = Double.parseDouble(y);
                }

            }

        } catch (IOException | JDOMException io) {
            JOptionPane.showMessageDialog(null, "Error al abrir archivo: " + io.getMessage());
        }

        return Puntos;
    }
}
