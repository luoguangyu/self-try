package ivan.test;

/**
 * Created by Ivan.Luo
 * Date: 9/12/2016 10:22 AM
 */
public class CharTest
{
	public static void  main(String arg[])
	{
		String s ="$%7BtenantId%7D";
		System.out.println(s.replaceAll("[^0-9a-zA-Z\\-%]",""));
	}
}
