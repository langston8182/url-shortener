package example;

import com.github.javafaker.Faker;
import com.notarius.urlshortener.urlshortener.domain.UrlShortener;
import com.notarius.urlshortener.urlshortener.util.Builder;

/**
 * Construct an Url example for tests
 * 
 * @author cyril
 *
 */
public class UrlShortenerExample {

	public static Builder<UrlShortener> aUrlShortener() {
		Faker faker = new Faker();
		
		return Builder.build(UrlShortener.class)
				.with(u -> u.setUrl(faker.internet().url()));
	}
	
}
