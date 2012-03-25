package net.slipp.user;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {
	@Test
	public void loginSuccess() throws Exception {
		User expected = new User("userId", "password", "name", "javajigi@slipp.net", true);
		assertThat(expected.isMatchPassword("password"), is(true));
	}
	
	@Test
	public void loginFailure() throws Exception {
		User expected = new User("userId", "password", "name", "javajigi@slipp.net", true);
		assertThat(expected.isMatchPassword("password2"), is(false));
	}
}
