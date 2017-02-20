package ivan.concurrent.learn;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Ivan.Luo
 * Date: 2/17/2017 3:25 PM
 */
public class DateParser
{
	// SimpleDateFormat is not thread safe, will get exception in multi-thread context.
	// should create new instance each time OR use ThreadLocal to share within a Thread
	private static final DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 *
	 * @param s
	 * @return
	 * @throws ParseException
	 */
	static public Date parse(String s) throws ParseException
	{
		return format.parse(s);
	}
}
