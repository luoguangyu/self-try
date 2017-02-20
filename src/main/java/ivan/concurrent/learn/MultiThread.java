package ivan.concurrent.learn;

import java.text.ParseException;

/**
 * Created by Ivan.Luo
 * Date: 2/13/2017 4:09 PM
 */
public class MultiThread extends Thread
{
	public static void main(String arg[])
	{
		// test SimpleDateFromat exception in Multi-thread
		// http://www.cnblogs.com/peida/archive/2013/05/31/3070790.html
		for(int i=0;i<3;i++)
		{
			new MultiThread().start();
		}
	}

	@Override
	public void run()
	{
		while (true)
		{
			try
			{
				// 让调用主体完全执行run方法里面的功能之后再进行join方法后的功能
				this.join(2000);
			}
			catch (InterruptedException e1)
			{
				e1.printStackTrace();
			}
			try
			{
				System.out.println(this.getName() + ":" + DateParser.parse("2013-05-24"));
			}
			catch (ParseException e)
			{
				e.printStackTrace();
			}
		}
	}
}
