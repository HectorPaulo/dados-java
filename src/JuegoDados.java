import java.util.Random;

class Jugador implements Runnable {
    private String nombre;
    private int puntos;
    private Random random;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntos = 0;
        this.random = new Random();
    }

    public void run() {
        while (puntos < 50) {
            tirarDados();
            try {
                Thread.sleep(2000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(nombre + " ha ganado con " + puntos + " puntos!");
    }

    private void tirarDados() {
        int dado1 = random.nextInt(6) + 1; 
        int dado2 = random.nextInt(6) + 1; 
        int total = dado1 + dado2; 
        puntos += total;
        System.out.println(nombre + " ha tirado " + dado1 + " y " + dado2 + ". Total de puntos: " + puntos);
    }
}

public class JuegoDados {
    public static void main(String[] args) {
        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");

        Thread hiloJugador1 = new Thread(jugador1);
        Thread hiloJugador2 = new Thread(jugador2);

        hiloJugador1.start();
        hiloJugador2.start();
    }
}
