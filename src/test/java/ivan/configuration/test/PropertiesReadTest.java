package ivan.configuration.test;

import ivan.configuration.ApplicationProperties;
import ivan.configuration.PropertiesConstants;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ashraf
 *
 */
public class PropertiesReadTest implements Runnable
{
	@Autowired
	private ApplicationProperties applicationProperties;
	// Thread name
	private String name;
	private Thread t;
	
	public PropertiesReadTest(String threadname, ApplicationProperties applicationProperties)
	{
		this.name = threadname;
		this.applicationProperties = applicationProperties;
		t = new Thread(this, name);
		System.out.println(t);
		// Start the thread
		t.start();
	}
	
	public void run()
	{
		System.out.println(name + "[ host: " + applicationProperties.getProperty(PropertiesConstants.HOST) + ", port: "
				+ applicationProperties.getProperty(PropertiesConstants.PORT) + ", user: "
				+ applicationProperties.getProperty(PropertiesConstants.USER) + ", password: "
				+ applicationProperties.getProperty(PropertiesConstants.PASSWORD) + " ]");
	}
	
}
