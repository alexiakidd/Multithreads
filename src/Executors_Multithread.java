
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Executors_Multithread {
	public static void main(String[] args) throws Exception {
		ExecutorService executor = null;
		
		try {
			executor = Executors.newFixedThreadPool(3);
			//executor = Executors.newCachedThreadPool();
			
			List<Tarefa> lista = new ArrayList<>();
			for(int i = 0; i < 10; i++) {
				lista.add(new Tarefa());
			}
					
//			String  string = executor.invokeAny(lista);
//			System.out.println(string);
			
			//List<Future<String>> list = executor.invokeAll(List.of(t1,t2,t3,t4));
			List<Future<String>> list = executor.invokeAll(lista);
			
			for (Future<String> future : list) {
				System.out.println(future.get());
			}
			
		}catch(Exception e) {
			throw e;
		}finally {
			if(executor != null) {
				executor.shutdownNow();
			}
		}
		
	}
	public static class Tarefa implements Callable<String>{
		@Override
		public String call() throws Exception {
			//Thread.sleep(1000);
			String name = Thread.currentThread().getName();
			int nextInt = new Random().nextInt(1000);
			return name + ": Inscreva-se no canal! " + nextInt;
		}
		 
	 }
}
