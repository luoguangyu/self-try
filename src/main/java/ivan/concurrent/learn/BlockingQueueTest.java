package ivan.concurrent.learn;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Ivan.Luo
 * Date: 2/13/2017 4:31 PM
 */
public class BlockingQueueTest
{
	public static void main(String[] args) throws InterruptedException {

		// 声明一个容量为10的缓存队列
		BlockingQueue<String> queue = new LinkedBlockingQueue<String>(10);

		Producer producer1 = new Producer(queue);
		Producer producer2 = new Producer(queue);
		Producer producer3 = new Producer(queue);
		Consumer consumer = new Consumer(queue);

		ExecutorService service = Executors.newCachedThreadPool();

		// 启动线程
		service.execute(producer1);
		service.execute(producer2);
		service.execute(producer3);
		service.execute(consumer);

		// 执行10s
		Thread.sleep(10 * 1000);
		producer1.stop();
		producer2.stop();
		producer3.stop();

		// 让消费者再执行2秒
		Thread.sleep(2000);

		service.shutdown();
	}
}
