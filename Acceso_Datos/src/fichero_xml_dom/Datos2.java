 package fichero_xml_dom;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;

 /*<Almacen>
    <lote id="1">
       <numcajas>3</numcajas>
       <componente>Fuentes</componente>
       <numserie>3A</numserie>
       <unidades>50</unidades>
       <peso>75Kg</peso>
    </lote>
</Almacen>*/
public class Datos2 {
    
    private int id,numCajas;
    private String componentes,numSerie;
    private int unidades,peso;

    public Datos2(int id, int numCajas, String componentes, String numSerie, int unidades, int peso) {
        this.id = id;
        this.numCajas = numCajas;
        this.componentes = componentes;
        this.numSerie = numSerie;
        this.unidades = unidades;
        this.peso = peso;
    }

    public Datos2() {
    }
    public int getId() {
        return id;
    }

    public int getNumCajas() {
        return numCajas;
    }

    public String getComponentes() {
        return componentes;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public int getUnidades() {
        return unidades;
    }

    public int getPeso() {
        return peso;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumCajas(int numCajas) {
        this.numCajas = numCajas;
    }

    public void setComponentes(String componentes) {
        this.componentes = componentes;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return  "id=" + id + ", numCajas=" + numCajas + ", componentes=" + componentes + ", numSerie=" + numSerie + ", unidades=" + unidades + ", peso=" + peso ;
    }
    
    
}
