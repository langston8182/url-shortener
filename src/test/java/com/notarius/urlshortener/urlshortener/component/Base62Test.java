package com.notarius.urlshortener.urlshortener.component;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Base62Test {

	@Autowired
	private Base62 base62;
	
	@Test
	public void toBase62() {
		long value = 1000000l;
		String encoded = base62.toBase62(value);
		assertThat(encoded).isEqualTo("emjc");
	}
	
	@Test
	public void toBase10() {
		String str = "emjc";
		long encoded = base62.toBase10(str);
		assertThat(encoded).isEqualByComparingTo(1000000l);
	}
}
