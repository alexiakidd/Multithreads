import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class ColecoesParaConcorrencia {

	//private static List<String> lista = new ArrayList<>();
	//private static Map<Integer, String> mapa = new ConcurrentHashMap<>();
	private static BlockingQueue<String> fila = new LinkedBlockingQueue<>();
	
	public static void main(String[] args) throws InterruptedException {
		// Coleções que são Thread-safe
		// LinkedBlockingDeque<E> outra opcao interessante
		
		MeuRunnable runnable = new MeuRunnable();
		Thread t0 = new Thread(runnable);
		Thread t1 = new Thread(runnable);
		Thread t2 = new Thread(runnable);
		t0.start();
		t1.start();
		t2.start();
		Thread.sleep(500);//nao é uma boa pratica. É so pra ilustrar
		//System.out.println(lista);
		//System.out.println(mapa);
		System.out.println(fila);
	}
	public static class MeuRunnable implements Runnable {
		@Override
		public void run() {
			//lista.add("Inscreva-se no canal");
			//mapa.put(new Random().nextInt(), "Curta esse video!");
			fila.add("Se tiver condições, torne-se um apoiador do canal!");
			String name = Thread.currentThread().getName();
			System.out.println(name + " inseriu na lista");
		}	
	}
}
