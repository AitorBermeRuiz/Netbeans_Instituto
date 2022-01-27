package Package;
import java.util.Scanner;
public class CMainOca {
	static  Scanner poTeclado = new Scanner(System.in);   	 

	public static void main(String[] args) {
    	CJuegoOca woJuegoOca = new CJuegoOca(4);
		woJuegoOca.mvJugarUnaPartida();  
	}// main()    
} //CMainJuegoOca

class CJuegoOca{ int piNumJugadores; CJugador [] paoJugador;  CTablero poTablero; int piTurno; boolean pbFinalDePartida;  
    CJuegoOca(int iiNumJugadores){ piNumJugadores = iiNumJugadores;}//CJuegoOca()
    
    public void mvInicializar(){
   	 paoJugador = new CJugador[piNumJugadores];
   	 for (int i=0; i<paoJugador.length; i++){ paoJugador[i]= new CJugador(i+1); paoJugador[i].mvInicializar();}    
   	 
   	 poTablero = new CTablero(30); poTablero.mvInicializar();   	 
    }//mvInicializar()
    
    public void mvJugarUnaPartida(){
       	mvInicializar();  
        pbFinalDePartida= false;
        piTurno= 0; // el primer turno es el cero para coincidir con el array  			 

		while(true){
			System.out.print("\nValor del dado de "+paoJugador[piTurno].psNombre+": ");  
			int wiDado = CMainOca.poTeclado.nextInt(); CMainOca.poTeclado.nextLine();
			 
			int wiNuevaPosicion = paoJugador[piTurno].piPosicion + wiDado;    
			int wiTipoDeCasilla = poTablero.paiCasilla[wiNuevaPosicion];
			 
			if ( wiNuevaPosicion < 30) {
								if (wiTipoDeCasilla== poTablero.CASILLA_INICIAL)
									paoJugador[piTurno].piPosicion = wiNuevaPosicion;                            	 
								if (wiTipoDeCasilla== poTablero.CASILLA_NORMAL)
									paoJugador[piTurno].piPosicion = wiNuevaPosicion;                            	 
								if (wiTipoDeCasilla== poTablero.CASILLA_MUERTE)
									paoJugador[piTurno].piPosicion = 1;
								if (wiTipoDeCasilla== poTablero.CASILLA_CIELO)
									paoJugador[piTurno].piPosicion = 30;
								if (wiTipoDeCasilla== poTablero.CASILLA_OCA)
									paoJugador[piTurno].piPosicion = poTablero.miCasillaSiguienteOca(wiNuevaPosicion);   			 
			}else
								/** repetir dado **/;
			if (paoJugador[piTurno].piPosicion == 30) {pbFinalDePartida= true; break;}   		 
			mvMostrarPosicionJugadores();
			if (piTurno==3) piTurno=0; else piTurno++;
		}//while(true)
		System.out.println("Fin de la partida. Ha ganado: "+paoJugador[piTurno].psNombre);
    }//mvJugarUnaPartida
    
    public void mvJugarUnaPartidaV2(){
       		 mvInicializar();  
            	pbFinalDePartida= false;
            	piTurno= 0; // el primer turno es el cero para coincidir con el array  			 

   	 while(true){
   		 System.out.print("\nValor del dado de "+paoJugador[piTurno].psNombre+": ");  
   		 int wiDado = CMainOca.poTeclado.nextInt(); CMainOca.poTeclado.nextLine();
   		 
   		 paoJugador[piTurno].piPosicion = miCasillaSiguiente(paoJugador[piTurno].piPosicion, wiDado);   		 

   		 if (paoJugador[piTurno].piPosicion == 30) {pbFinalDePartida= true; break;}   		 
   		 mvMostrarPosicionJugadores();
        	if (piTurno==3) piTurno=0; else piTurno++;
   	 }//while(true)
   	 System.out.println("Fin de la partida. Ha ganado: "+paoJugador[piTurno].psNombre);
    }//mvJugarUnaPartidaV2    
    
    void mvMostrarPosicionJugadores(){
        	System.out.print("\nPosiciones: ");
        	for (CJugador paoJugador1 : paoJugador) System.out.print(paoJugador1.piPosicion + "-");    
    }//mvMostrarPosicionJugadores()
}//CJuegoOca

class CTablero{ int piTotalDeCasillas; int [] paiCasilla;

    CTablero(int iiTotalDeCasillas) {piTotalDeCasillas= iiTotalDeCasillas; }//CTablero
    
    public final int CASILLA_NORMAL    	= 0;
    public final int CASILLA_INICIAL	= 1;
    public final int CASILLA_FINAL     	= 2;    
    public final int CASILLA_MUERTE    	= 3;
    public final int CASILLA_CIELO     	= 4;
    public final int CASILLA_OCA    	= 5;

    void mvInicializar(){
        	paiCasilla = new int[piTotalDeCasillas+1];
        	for(int i=1; i<paiCasilla.length; i++) paiCasilla[i]= CASILLA_NORMAL;
        	paiCasilla[1] = CASILLA_INICIAL;    
        	paiCasilla[30]= CASILLA_FINAL;
        	for (int i=5; i<paiCasilla.length; i=i+5) paiCasilla[i]= CASILLA_OCA;

        	System.out.print("Dime la casilla de MUERTE: ");
        	paiCasilla[ CMainOca.poTeclado.nextInt() ] = CASILLA_MUERTE; CMainOca.poTeclado.nextLine();
        	System.out.print("Dime la casilla de CIELO : ");
        	paiCasilla[ CMainOca.poTeclado.nextInt() ] = CASILLA_CIELO;  CMainOca.poTeclado.nextLine();
    }//mvInicializar
    
    int miValorDeLaCasilla(int iiCasilla){ return paiCasilla[iiCasilla];}//miValorDeLaCasilla()
    int miCasillaSiguienteOca(int iiCasilla) { if (iiCasilla + 5 >= 30) return iiCasilla; else return (iiCasilla+5); }//miCasillaSiguienteOca()    
   	 
    int miCasillaSiguiente(int iiCasillaActual, int iiDado) {
   	 int wiNuevaPosicion = iiCasillaActual + iiDado;    
    	int wiTipoDeCasilla = paiCasilla[wiNuevaPosicion];
   		 
   		 if ( wiNuevaPosicion < 30) {
   			 if (wiTipoDeCasilla== CASILLA_INICIAL)
   				 return  wiNuevaPosicion;                            	 
   			 if (wiTipoDeCasilla== CASILLA_NORMAL)
   				 return  wiNuevaPosicion;                            	 
   			 if (wiTipoDeCasilla== CASILLA_MUERTE)
   				 return 1;
   			 if (wiTipoDeCasilla== CASILLA_CIELO)
   				 return 30;
   			 if (wiTipoDeCasilla== CASILLA_OCA)
   				 return miCasillaSiguienteOca(wiNuevaPosicion);   			 
   		 }else{
            	int wiExceso = wiNuevaPosicion - 30;
   			 wiNuevaPosicion = 30 - wiExceso;
   		 }
    }// miCasillaSiguienteV2()

}//CTablero

class CJugador{ int piOrdenDelJugador; String psNombre; int piPosicion;
    CJugador(int iiOrdenDelJugador){piOrdenDelJugador= iiOrdenDelJugador; }//CJugador()
    
    void mvInicializar(){
        	piPosicion = 0;
        	System.out.print("Nombre Del Jugador "+ piOrdenDelJugador+": "); psNombre= CMainOca.poTeclado.nextLine();
    	}//mvInicializar
}//CJugador