package ivan.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ivan.Luo
 * Date: 11/2/2015 1:24 PM
 */
@RestController @EnableAutoConfiguration public class SampleController
{

	@RequestMapping("/") @ResponseBody String home()
	{

		System.out.println("returning: hello world @");
		return "Hello World!";
	}

	/**
	 * get games headers
	 *
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "games/{gameId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK) HttpHeaders getGames(@PathVariable(value = "gameId") String gameId)
	{
		HttpHeaders headers = new HttpHeaders();
		headers.set("gameId: ", gameId);
		return headers;
	}

	/**
	 * get games
	 *
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "games", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK) Map<String, String> getGame()
	{
		Map<String, String> map = new HashMap();
		map.put("Status", "active");
		return map;
	}

	public static void main(String[] args) throws Exception
	{
		SpringApplication.run(SampleController.class, args);
		//test
	}
}
