https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import com.fasterxml.jackson.databind.*;

/**
 * This version employs NIO (to stream the json file)
 * and stream pipeline processing (uses Java SE 8)
 */

public class JacksonSamplerStream {
	
	public static void main(String[] args) throws IOException {
		assert args != null & args.length > 0;
		ObjectMapper mapper = new ObjectMapper();
		Map<String,Object> record = new HashMap<>();
		
		Stream<String> lines = Files.lines(Paths.get(""),//you need to 
				//specify position of json file
			StandardCharsets.UTF_8);
		lines.forEach(s -> {
			try {
				record.putAll(mapper.readValue(s, Map.class));
				record.forEach((k,v) -> 
					System.out.printf("%s: %s%n", k, v));
				System.out.println("=================");
			record.clear();
			} catch (IOException ioe) {
				System.out.printf("Bad json record %s%n", ioe);
			}
		});

		
	}
}