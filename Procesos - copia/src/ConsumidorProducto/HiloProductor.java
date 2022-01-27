package ConsumidorProducto;

public class HiloProductor implements Runnable {

	private Datos datos;
	
	public HiloProductor(Datos datos) {
		this.datos=datos;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

		for (int i=0;i<10;++i) {
			//Producimos un n�mero
			int numero=(int)(Math.random()*100);
			//Simulamos un tiempo de producci�n
			try {
				Thread.sleep((long)(Math.random()*500));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Inserto en datos el n�mero producido
			System.out.println("Productor: acabo de producir: "+numero);
			datos.producir(numero);
		}
	}

}
