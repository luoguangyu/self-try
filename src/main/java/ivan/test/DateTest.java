package ivan.test;

import org.springframework.util.DigestUtils;
import sun.security.jca.GetInstance;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by Ivan.Luo
 * Date: 2/15/2016 5:16 PM
 */
public class DateTest
{
	public static void main(String arg[]) throws ParseException
	{
	/*	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String dateOfLOA = formatter.format(new Date());
		System.out.println("dateOfLOA:" + dateOfLOA);
		String timestampString="1467194092412";
		int duration = 5;
		// start time
		Long timestamp = Long.parseLong(timestampString);
		Date startDateTime = new Date(timestamp);

		// end time
		Calendar c = Calendar.getInstance();
		c.setTime(startDateTime);
		c.add(Calendar.HOUR, duration);
		Date endDateTime = c.getTime();

		SimpleDateFormat timeFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		timeFormatter.setTimeZone(TimeZone.getTimeZone("Australia/Melbourne"));

		System.out.println("startTimestamp:" + timeFormatter.format(startDateTime));
		System.out.println("endTimestamp:" + timeFormatter.format(endDateTime));

		long t = c.getTimeInMillis() / 1000L;
		System.out.println(t);
		Date myDate = new Date(t);
		System.out.println(String.valueOf(t));
		System.out.println(myDate);

		System.out.println(new Date().toString());*/

/*		double d = 0.0;
		System.out.println(d == 1);*/

		LocalDateTime ldt = LocalDateTime.parse("01-08-2016 00:00:00",
				DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		System.out.println(ldt.toString());
/*		ZoneId zone = ZoneId.systemDefault();
		Instant instant = ldt.atZone(zone).toInstant();
		Date dt = Date.from(ldt.atZone(ZoneId.of("Australia/Melbourne")).toInstant());
		System.out.println(dt);*/
		try
		{
			Date dt = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("18-08-2016 09:54:01");
			System.out.println(dt);
			System.out.println(new Date());
			System.out.println(System.currentTimeMillis() - dt.getTime()>Long.valueOf(24)*3600*1000);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}


/*
		double d = 122223.45678978782;
		DecimalFormat df = new DecimalFormat("#.####");
		System.out.println(df.format(d));*/

//		Date tempCancelTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2016-08-17 15:45:44");
//		System.out.println(tempCancelTime);
//		LocalDateTime cancelTime = LocalDateTime.ofInstant(
//				tempCancelTime.toInstant(), ZoneId.of("Australia/Melbourne"));
//		LocalDateTime minusTime = cancelTime.minusHours(-24);
//		LocalDateTime now = LocalDateTime.now(ZoneId.of("Australia/Melbourne"));
//		System.out.println(minusTime);
//		System.out.println(now);
//		System.out.println(minusTime.isBefore(now));
//		System.out.println(System.currentTimeMillis()-tempCancelTime.getTime());
//		System.out.println(24*3600*1000);

/*		List<User> users = new ArrayList();
		User u3 = new User();
		u3.setId(3);
		u3.setName("3");
		users.add(u3);
		User u1 = new User();
		u1.setId(1);
		u1.setName("1");
		users.add(u1);
		User u2 = new User();
		u2.setId(2);
		u2.setName("2");
		users.add(u2);


		System.out.println(users);
		Collections.sort(users, new Comparator<User>()
		{
			@Override
			public int compare(User o1, User o2)
			{
				if (o1.getId() < o2.getId())
					return 1;
				if (o1.getId() == o2.getId())
					return 0;
				return -1;
			}
		});
		System.out.println(users);*/
	}


}
class User{
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	public String toString()
	{
		return "id: "+this.id+", name:"+this.name;
	}
	int id;
	String name;
}