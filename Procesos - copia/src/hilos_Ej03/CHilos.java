package hilos_Ej03;

public class CHilos implements Runnable{
    String texto;
    char vocal;
    CDatos datos;
    int contador = 0;
    @Override
    public void run(){
        for(int i=0;i<texto.length();++i){
            if(texto.charAt(i)==vocal)
                contador++;
        }
        datos.setContador(contador);
    }
    public CHilos(String wiTexto, char wcvocal,CDatos woDatos){
        texto = wiTexto;
        vocal = wcvocal;
        datos = woDatos;
    }
}
