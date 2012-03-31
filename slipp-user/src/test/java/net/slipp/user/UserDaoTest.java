package net.slipp.user;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserDaoTest {
	private UserDao dut;

	@Before
	public void setup() {
		dut = new UserDao();
	}

	@Test
	public void crud() throws Exception {
		User expected = new User("userId", "password", "name", "javajigi@slipp.net", true);
		dut.remove(expected.getUserId());

		dut.insert(expected);

		User actual = dut.findUser(expected.getUserId());
		assertThat(actual, is(expected));
	}
}
