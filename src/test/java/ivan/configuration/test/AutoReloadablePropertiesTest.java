package ivan.configuration.test;

import ivan.configuration.ApplicationProperties;
import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author ashraf
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/app-context.xml")
public class AutoReloadablePropertiesTest extends TestCase
{
	
	private static final int MAIN_THREAD_SLEEP_TIME = 1000;
	
	private static final int PROP_READER_THREAD_SLEEP_TIME = 1000;
	
	private static final int PROP_EDITOR_THREAD_SLEEP_TIME = 3000;
	
	@Autowired
	private ApplicationProperties applicationProperties;
	
	@Test
	public void testAppProperties()
	{
		
		try
		{
			while (true)
			{
				new PropertiesReadTest("PropertiesReadTest", applicationProperties);
				System.out.println("sleeping for 3 seconds for next thread");
				Thread.sleep(MAIN_THREAD_SLEEP_TIME * 3);
			}
			
			// Start three PropEditorThread to update the mode property using ApplicationProperties
			// new PropEditorThread("PropEditor", PROP_EDITOR_THREAD_SLEEP_TIME, applicationProperties);
			
			// This main will sleep for one minute then it will exit.
			// Thread.sleep(MAIN_THREAD_SLEEP_TIME * 60);
			
		}
		catch (Exception e)
		{
			System.out.println("Main thread Interrupted");
		}
		
		System.out.println("Main thread was finished!");
	}
	
}
