package ivan.test;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Ivan.Luo
 * Date: 12/15/2016 2:32 PM
 */
public class SemaphoreTest
{
	public static void main(String[] args)
	{
		// 线程池
		ExecutorService exec = Executors.newCachedThreadPool();
		// 只能5个线程同时访问
		final Semaphore semp = new Semaphore(10);
		// 模拟50个客户端访问
		for (int index = 0; index < 50; index++)
		{
			System.out.println("in loop index="+index);
			final int NO = index;
			Runnable run = new Runnable()
			{
				public void run()
				{
					try
					{
						// 获取许可
						semp.acquire();
						System.out.println("Accessing: " + NO);
						Thread.sleep((long) (Math.random() * 6000));
						// 访问完后，释放
						semp.release();
						//availablePermits()指的是当前信号灯库中有多少个可以被使用
						System.out.println("---available Semaphore number----" + semp.availablePermits());
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
			};
			// 起50个线程
			exec.execute(run);
			int threadCount = ((ThreadPoolExecutor)exec).getActiveCount();
			System.out.println("total threads :"+threadCount);
		}
		// 退出线程池
		exec.shutdown();
	}
}
