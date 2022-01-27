/*
<?xml version="1.0"?> 
<Curso> 
  <alumno id="jj"> 
      <nombre> Juan Carlos Jimenez </nombre> 
      <nota1>5</nota1> 
      <nota2>7</nota2> 
      <proyecto>8</proyecto> 
      <practica>9</practica> 
  </alumno> 
  <alumno id="cp"> 
      <nombre> Christian Perez </nombre> 
      <nota1>7</nota1> 
      <nota2>8</nota2> 
      <proyecto>7</proyecto> 
      <practica>4</practica> 
  </alumno> 
  <alumno id="sf"> 
      <nombre> Sonia Fernandez </nombre> 
      <nota1>6</nota1> 
      <nota2>9</nota2> 
      <proyecto>10</proyecto> 
      <practica>10</practica> 
    </alumno> 
</Curso>
*/
package fichero_xml_dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;



public class CEjercicio1 {
    public static void main(String[] args) {
      crearXML();
    }// main
    private static void crearXML(){
        Datos1[] Alumnos = new Datos1[3];
        Datos1 Alumno0 = new Datos1("jj","Juan Carlos Jimenez",5,6,8,9); Alumnos[0]=Alumno0;
        Datos1 Alumno1 = new Datos1("cp","Christian Perez",7,8,7,4);Alumnos[1] = Alumno1;
        Datos1 Alumno2 = new Datos1("sf","Sonia Fernandez",6,9,10,10);Alumnos[2] = Alumno2;
        
        
        try {
            DocumentBuilderFactory dbf =DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder(); 
            Document doc = db.newDocument();
            //Crear el nodo Raiz <Curso>
            Element Curso = doc.createElement("Curso");
            doc.appendChild(Curso);
            
            for (int i = 0;i<3;++i){
                
                //Creamos el elemento <alumno> que cuelga de <curso>
                Element alumno = doc.createElement("alumno");
                Curso.appendChild(alumno);
                //Se le añade al atributi id=xx
                
                //Attr attr = doc.createAttribute("id");
                //attr.setValue(Alumnos[i].getId());
                //alumno.setAttributeNode(attr);
                alumno.setAttribute("id", Alumnos[i].getId());

                //Creamos el elemento <nombre> que cuelga de <alumno>
                Element nombre = doc.createElement("Nombre");
                alumno.appendChild(nombre);
                //Añadimos el Texto
                Text texto = doc.createTextNode(Alumnos[i].getNombre());
                nombre.appendChild(texto);
                //Creamos el elemento <nota1> que cuelga de <alumno>
                Element nota1 = doc.createElement("nota1");
                alumno.appendChild(nota1);
                
                texto = doc.createTextNode(Alumnos[i].getNota1()+"");
                nota1.appendChild(texto);
                //Creamos el elemento <nota2> que cuelga de <alumno>
                Element nota2 = doc.createElement("nota2");
                alumno.appendChild(nota2);
                texto = doc.createTextNode(Alumnos[i].getNota2()+"");
                nota2.appendChild(texto);
                //Creamos el elemento <proyecto> que cuelga de <alumno>
                Element proyecto = doc.createElement("Proyecto");
                alumno.appendChild(proyecto);
                texto = doc.createTextNode(Alumnos[i].getProyecto()+"");
                proyecto.appendChild(texto);
                //Creamos el elemento <practica> que cuelga de <alumno>
                Element practica = doc.createElement("Practica");
                alumno.appendChild(practica);
                texto = doc.createTextNode(Alumnos[i].getPractica()+"");
                practica.appendChild(texto);
            }
            
            //Generar el transformador para obtener el XML en un fichero
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            DOMSource ds = new DOMSource(doc);
            StreamResult sr = new StreamResult("notas.xml");
            t.transform(ds, sr);
           
        } catch (ParserConfigurationException ex) {System.out.println("No se a podido crear el generador de documentos");
        } catch (TransformerException te){System.out.println("No se a podido crear la salida del documento XML");}
        
    }// crearXML()
    private static void leerFichero(){
        try {
            //DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = db.parse("notas.xml");
            
            //Obtener el elemento raiz del documento
            Element curso = doc.getDocumentElement();
            //Obtener la lista de nodos que tiene alumno
            NodeList listaAlumnos = curso.getElementsByTagName("alumno");
            //Recorremos la lista de libros
            for (int i = 0;i<listaAlumnos.getLength();++i){
                System.out.println("=====================");
                System.out.println("Libro "+i);
            //De la lista de alumnos cogemos alumno por alumno
                Node alumnoX =listaAlumnos.item(i);
            //Obtenemos la lista de los datos que tiene ese alumno
                NodeList datosAlumno = alumnoX.getChildNodes();
            }
            
        } catch (Exception e) {
        }

    }// leerFichero()
}
