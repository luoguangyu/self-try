package ivan.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by p0060266 on 10/30/2015.
 */
public class ThreadTest
{
	public static void main(String arg[])
	{
		String abc = null, def;
		System.out.println(abc);
		int a = 0;
		int b = 0;
		System.out.println(b);
		List<String> list = new ArrayList<> ();
		list.add("a");
		list.add("b");
		list.add("c");
		System.out.println(list);
		Map<Integer, Integer> map = new HashMap<>();
		map.put(1, 2);
		map.put(2, 3);
		System.out.println(map.toString());
		//new

		synchronized(new String())
		{

		}
	}
}
