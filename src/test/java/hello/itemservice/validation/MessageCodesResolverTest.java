package hello.itemservice.validation;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;

public class MessageCodesResolverTest {

	MessageCodesResolver codesResolver = new DefaultMessageCodesResolver();

	@Test
	void messageCodesResolverObject() {
		//given
		String[] messageCodes = codesResolver
			.resolveMessageCodes("required", "item");
		assertThat(messageCodes).containsExactly("required.item", "required");
	}

	@Test
	void messageCodesResolverField() {
		String[] messageCodes = codesResolver.resolveMessageCodes("require", "item", "itemName", String.class);

		for (String messageCode : messageCodes) {
			System.out.println("messageCode = " + messageCode);
		}
		assertThat(messageCodes).containsExactly(
			"require.item.itemName",
			"require.itemName",
			"require.java.lang.String",
			"require"
		);
	}

}
