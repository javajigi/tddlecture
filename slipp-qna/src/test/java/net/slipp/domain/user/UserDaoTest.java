package net.slipp.domain.user;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import net.slipp.domain.user.User;
import net.slipp.domain.user.UserDao;

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
		User expected = new User("userId", "password", "name", "javajigi@slipp.net");
		dut.remove(expected.getUserId());

		dut.create(expected);
		
		User actual = dut.findUser(expected.getUserId());
		assertThat(actual, is(expected));
	}
}
