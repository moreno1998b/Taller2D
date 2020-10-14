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
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author Administrador
 *
 * GuardadoXml: Tiene los métodos para guardar y cargar el archivo xml.
 *
 * @author Jairo Vergara Portocarrero 2151714
 * @author Jorge Moreno 2175321
 * @author Sebastian Bejarano 2190853
 *
 *
 * @date 9 Octubre 2020
 * @version 1.0
 */
public class GuardadoXml {

    static Document doc;

    public static boolean crearArchivoXML(HashMap<String, LinkedList<Puntos2D>> mp) {
        boolean t = false;
        try {
            /**
             * crearArchivoXML.
             *
             * Método para crear un archivo XML con los puntos arrayx e arrayy
             * que se han creado en el lienzo.
             */

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
            XMLOutputter xmloutput = new XMLOutputter();
            xmloutput.setFormat(Format.getPrettyFormat());
            xmloutput.output(doc, new FileWriter("figurasgeometricas.xml"));
            t = true;
        } catch (IOException io) {
            t = false;
            System.out.println("Error " + io.toString());
        }

        return t;
    }

    public static boolean guardarArchivoXML(HashMap<String, LinkedList<Puntos2D>> mpfg) {
        boolean t = false;
        try {
            Element primario = new Element("figurasgeometricas");
            Document doc = new Document(primario);
            Iterator<Map.Entry<String, LinkedList<Puntos2D>>> entries = mpfg.entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry<String, LinkedList<Puntos2D>> elemento = entries.next();
                Element figurageometrica = new Element("figurageometrica");
                figurageometrica.setAttribute(new Attribute("nombre", elemento.getKey()));
                figurageometrica.setAttribute(new Attribute("color", elemento.getValue().get(0).getColorResaltado().toString()));
                for (int i = 0; i < elemento.getValue().size(); i++) {
                    double valuex = elemento.getValue().get(i).getX();
                    double valuey = elemento.getValue().get(i).getY();
                    figurageometrica.addContent(new Element("Coordenadas" + (i + 1)).
                            setAttribute(new Attribute("x", String.valueOf(valuex))).
                            setAttribute(new Attribute("y", String.valueOf(valuey))));
//                            setAttribute(new Attribute("colorRelleno", elemento.getValue().get(i).getColorRelleno().toString())).
//                            setAttribute(new Attribute("colorResaltado", elemento.getValue().get(i).getColorResaltado().toString())));
                }
                doc.getRootElement().addContent(figurageometrica);
            }

            XMLOutputter xmloutput = new XMLOutputter();
            xmloutput.setFormat(Format.getPrettyFormat());
            xmloutput.output(doc, new FileWriter("figurasgeometricas.xml"));
            t = true;
        } catch (IOException io) {
            t = false;
            System.out.println("Error " + io.toString());
        }

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

    public static HashMap<String, LinkedList<Puntos2D>> leerArchivo() {
        HashMap<String, LinkedList<Puntos2D>> map = new HashMap<>();
        LinkedList<Puntos2D> listap;
        SAXBuilder builder = new SAXBuilder();

        try {
            File xmlfile = new File("figurasgeometricas.xml");
            Document documento = (Document) builder.build(xmlfile);
            Element root = documento.getRootElement();
            List list = root.getChildren("figurageometrica");

            for (int i = 0; i < list.size(); i++) {
                listap = new LinkedList<>();
                Element datos = (Element) list.get(i);
                String nombreFigura = datos.getAttributeValue("nombre");
                System.out.println("Tabla: " + nombreFigura);
                Color c2 = Color.valueOf(datos.getAttributeValue("color"));
                List listapuntos = datos.getChildren();
                for (int j = 0; j < listapuntos.size(); j++) {
                    Element campo = (Element) listapuntos.get(j);
                    double x = Double.parseDouble(campo.getAttributeValue("x"));
                    double y = Double.parseDouble(campo.getAttributeValue("y"));
//                    Color c=campo.getAttributeValue("colorRelleno");
//                    Color c2 = Color.valueOf(campo.getAttributeValue("colorRelleno").toString());
                    System.out.println(c2);
                    Puntos2D p = new Puntos2D(x, y, c2, c2);
                    listap.add(p);
                }
                map.put(nombreFigura, listap);
                System.out.println(nombreFigura + "     " + listap);

            }

        } catch (IOException io) {
            System.out.println("error " + io.toString());
        } catch (JDOMException jde) {
            System.out.println("error " + jde.toString());
        }

        return map;
    }
}
