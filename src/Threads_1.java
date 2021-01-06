
public class Threads_1 {

	public static void main(String[] args) {
		//Thread atual
		Thread t = Thread.currentThread();
		System.out.println(t.getName());
		
		MeuRunnable meuRunnable = new MeuRunnable();
		
		//Nova Thread
		Thread t1 = new Thread(meuRunnable);
		//t1.run();
		
		
		//Runnable como lambda(bem mais conciso)
		Thread t2 = new Thread(
				() -> System.out.println(Thread.currentThread().getName()));
				//() -> System.out.println("Inscreva-se no canal"));
		
		//t2.start(); // VAI LANÇAR EXCEÇÃO! A THREAD JA STARTOU ANTERIORMENTE
		
		//Varias threads
		Thread t3 = new Thread(meuRunnable);
		
		t1.start();
		t2.start();
		t3.start();
	}

}
