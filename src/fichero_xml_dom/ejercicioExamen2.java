package fichero_xml_dom;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

 /*<Almacen>
    <lote id="1">
       <numcajas>3</numcajas>
       <componente>Fuentes</componente>
       <numserie>3A</numserie>
       <unidades>50</unidades>
       <peso>75Kg</peso>
    </lote>
</Almacen>*/
public class ejercicioExamen2 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException,TransformerConfigurationException, TransformerException {

        leerSax();
        
    }
    private static void crearFichero(){
        
        Datos2 producto1 = new Datos2(1, 3, "fuentes", "3A", 50, 75);
        Datos2 producto2 = new Datos2(2, 23, "fregona", "2$", 200, 2);
        Datos2 producto3 = new Datos2(3, 5, "alfombras", "4H", 150, 4);
        
        ArrayList<Datos2> productos = new ArrayList<>();
        productos.add(producto1);productos.add(producto2);productos.add(producto3);
        
        try {
            
            DocumentBuilder db = (DocumentBuilderFactory.newInstance()).newDocumentBuilder();
            Document doc = db.newDocument();
            
            Element almacen = doc.createElement("Almacen");
            doc.appendChild(almacen);
            
            for(int i =0;i<productos.size();++i){
                Element lote = doc.createElement("lote");
                almacen.appendChild(lote);
                lote.setAttribute("id", productos.get(i).getId()+"");
                
                Element numCajas = doc.createElement("numCajas");
                lote.appendChild(numCajas);
                numCajas.setTextContent(productos.get(i).getNumCajas()+"");
                
                Element componentes = doc.createElement("componentes");
                lote.appendChild(componentes);
                componentes.setTextContent(productos.get(i).getComponentes());
                
                Element numSerie = doc.createElement("numSerie");
                lote.appendChild(numSerie);
                numSerie.setTextContent(productos.get(i).getNumSerie());   
                
                Element unidades = doc.createElement("unidades");
                lote.appendChild(unidades);
                unidades.setTextContent(productos.get(i).getUnidades()+"");     
                
                Element peso = doc.createElement("peso");
                lote.appendChild(peso);
                peso.setTextContent(productos.get(i).getPeso()+"");
            }
            
            
            Transformer t = (TransformerFactory.newInstance()).newTransformer();
            DOMSource ds =new DOMSource(doc);
            StreamResult sr = new StreamResult("Almacen.xml");
            t.transform(ds, sr);
            
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Datos2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(ejercicioExamen2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(ejercicioExamen2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public static void leerSax() throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerException{
        File f = new File("Almacen.xml");
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();
        
        Manejador m = new Manejador();
        sp.parse(f, m);
        ArrayList<Datos2> lista = m.getLista();
        DocumentBuilder db = (DocumentBuilderFactory.newInstance()).newDocumentBuilder();
        Document doc = db.newDocument();
        
        Element resumen = doc.createElement("resumen");
        doc.appendChild(resumen);
        for(int i = 0;i<lista.size();++i){
            Element articulo = doc.createElement("articulo");
            resumen.appendChild(articulo);
            articulo.setAttribute("nombre", lista.get(i).getComponentes());
            
            Element cajas = doc.createElement("cajas");
            articulo.appendChild(cajas);
            cajas.setTextContent(lista.get(i).getNumCajas()+"");
            
            Element cantidad = doc.createElement("cantidad");
            articulo.appendChild(cantidad);
            cantidad.setTextContent(lista.get(i).getUnidades()+"");
            
            int numeroCajas =lista.get(i).getNumCajas();
            int numeroCantidades = lista.get(i).getUnidades();
            int totalCajasyCantidades = numeroCajas*numeroCantidades;
            
            Element total = doc.createElement("total");
            articulo.appendChild(total);
            total.setTextContent(totalCajasyCantidades+"");
            
            Element peso = doc.createElement("peso");
            articulo.appendChild(peso);
            peso.setTextContent(lista.get(i).getPeso()+"Kg");
        }
        
        Transformer t = (TransformerFactory.newInstance()).newTransformer();
        
        DOMSource ds = new DOMSource(doc);
        StreamResult sr = new StreamResult("resumen.xml");
        t.transform(ds, sr);
        
    }
}


























