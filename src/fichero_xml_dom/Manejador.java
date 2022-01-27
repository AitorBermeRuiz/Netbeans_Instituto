package fichero_xml_dom;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Manejador extends DefaultHandler {

    ArrayList<Datos2> lista = new ArrayList<Datos2>();
    Datos2 em;
    StringBuilder buffer = new StringBuilder();

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case "numCajas":
                em.setNumCajas(Integer.parseInt(buffer.toString()));
                break;
            case "componentes":
                em.setComponentes(buffer.toString());
                break;
            case "numSerie":
                em.setNumSerie(buffer.toString());
                break;
            case "unidades":
                em.setUnidades(Integer.parseInt(buffer.toString()));
                break;
            case "peso":
                em.setPeso(Integer.parseInt(buffer.toString()));
                break;
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        switch (qName) {
            case "lote":
                em = new Datos2();
                lista.add(em);
                em.setId(Integer.parseInt(attributes.getValue("id")));
                break;
            case "numCajas":
            case "componentes":
            case "numSerie":
            case "unidades":
            case "peso":
                buffer.delete(0, buffer.length());
                break;
        }
    }

    public ArrayList<Datos2> getLista() {
        return lista;
    }
}
