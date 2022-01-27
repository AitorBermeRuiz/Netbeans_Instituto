package ConsumidorProducto;
public class Datos {

	private int informacion = -1;
	
	public synchronized void producir(int info) {
		//Suponemos que los valores v�lidos son
		//mayores o iguales que 0. De lo contrario,
		//informaci�n est� vac�o
		while(informacion>=0) {
			try {
				System.out.println("Productor: quiero producir, pero consumidor no ha consumido");
				
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//Rellenamos la informaci�n
		informacion=info;
		//Despertamos al consumidor
		notifyAll();
	}
	
	public synchronized int consumir() {
		//Esperamos a que haya datos
		while(informacion<0) {
			try {
				System.out.println("Consumidor: quiero consumir, pero productor no ha producido");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//Vaciamos los datos (nos tenemos que quedar
		//con una copia en una variable auxiliar)
		int aux=informacion;
		informacion=-1;
		//Despertamos al productor
		notifyAll();
		return aux;
	}
	
	
}
