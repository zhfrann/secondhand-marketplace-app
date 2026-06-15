package secondhand_marketplace.app;

import org.junit.Test;

import secondhand_marketplace.akun.ManajerAkun;
import secondhand_marketplace.exception.LoginException;
import secondhand_marketplace.pengguna.Pengguna;

import static org.junit.Assert.*;

public class LoginTest {

    @Test
    public void testLoginSuccess() throws LoginException {
        ManajerAkun manajer = new ManajerAkun();
        Pengguna user = manajer.login("user1", "user1");
        assertNotNull(user);
        assertEquals("user1", user.getUsername());
    }

    @Test(expected = LoginException.class)
    public void testLoginWrongPassword() throws LoginException {
        ManajerAkun manajer = new ManajerAkun();
        manajer.login("user1", "wrongpass");
    }

    @Test(expected = LoginException.class)
    public void testLoginUnknownUser() throws LoginException {
        ManajerAkun manajer = new ManajerAkun();
        manajer.login("noone", "nopass");
    }
}
