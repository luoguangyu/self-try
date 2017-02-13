package ivan.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Ivan.Luo
 * Date: 11/11/2015 9:54 AM
 */
public class LoggerTest
{
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggerTest.class);
	public static void main(String[] args)
	{
		String userId="",euId="",serviceProvider="",tenancyId="",serviceId="",role="";

		LOGGER.info("Start adding user role: userId = {}, euId = {}, serviceProvider = {}, tenancyId = {}, "
				+ "serviceId = {}, role = {}",userId,euId,serviceProvider,tenancyId,serviceId,role);
		LOGGER.info("Start adding user role: userId = {}, euId = {}, serviceProvider = {}, tenancyId = {}, "
				+ "serviceId = {}, role = {}",new Object[]{userId,euId,serviceProvider,tenancyId,serviceId,role});
		System.out.println(HTTPStatus.OK);
		System.out.println(addTest(100,1));
		System.out.println(addTest(100,1,2));
		System.out.println(addTest(100,1,2,3));

	}
	static int addTest(int a, Integer ...args)
	{
		for(Integer i : args)
		{
			a=a+i;
		}
		return a;
	}
}
enum HTTPStatus{
	CONTINUE(100, "Continue"),
	SWITCHING_PROTOCOLS(101, "Switching Protocols"),
	PROCESSING(102, "Processing"),
	CHECKPOINT(103, "Checkpoint"),
	OK(200, "OK");
	private final int value;
	private final String reasonPhrase;

	private HTTPStatus(int value, String reasonPhrase) {
		this.value = value;
		this.reasonPhrase = reasonPhrase;
	}

	public int value() {
		return this.value;
	}

	public String getReasonPhrase() {
		return this.reasonPhrase;
	}
}
