package ConsumidorProducto;
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Datos datos=new Datos();
		
		Thread productor=new Thread(new HiloProductor(datos));
		Thread consumidor=new Thread(new HiloConsumidor(datos));
		productor.start();
		consumidor.start();
		
		try {
			productor.join();
			consumidor.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("FIN");
		
	}

}
