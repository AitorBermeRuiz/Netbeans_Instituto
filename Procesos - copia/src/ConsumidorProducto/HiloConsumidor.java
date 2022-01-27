package ConsumidorProducto;

public class HiloConsumidor implements Runnable {

	private Datos datos;
	
	public HiloConsumidor(Datos datos) {
		this.datos=datos;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i=0;i<10;++i) {
			//Nos traemos la informaci�n de datos
			int info=datos.consumir();
			//Simulamos tiempo de proceso
			try {
				Thread.sleep((long)(Math.random()*500));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Consumidor. He consumido "+info);
		}
	}

}
