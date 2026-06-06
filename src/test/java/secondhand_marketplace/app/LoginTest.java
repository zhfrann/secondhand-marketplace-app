package secondhand_marketplace.app;

import org.junit.Test;

import secondhand_marketplace.akun.ManajerAkun;
import secondhand_marketplace.exception.LoginException;
import secondhand_marketplace.pengguna.Pengguna;

import static org.junit.Assert.*;

public class LoginTest {

    @Test
    public void shouldLoginSuccessfullyWithValidCredentials() throws Exception {

        ManajerAkun manajer = new ManajerAkun();

        Pengguna pengguna =
                manajer.login("user1", "user1");

        assertNotNull(pengguna);
        assertEquals("user1", pengguna.getUsername());
    }

    @Test(expected = LoginException.class)
    public void shouldThrowExceptionForWrongPassword() throws Exception {

        ManajerAkun manajer = new ManajerAkun();

        manajer.login(
                "user1",
                "passwordSalah"
        );
    }

    @Test(expected = LoginException.class)
    public void shouldThrowExceptionForUnknownUser() throws Exception {

        ManajerAkun manajer = new ManajerAkun();

        manajer.login(
                "tidakAda",
                "123"
        );
    }

    @Test
    public void shouldLoginAfterRegisteringNewUser() throws Exception {

        ManajerAkun manajer = new ManajerAkun();

        manajer.register(
                "bintang",
                "password123",
                "bintang@mail.com",
                "081222222222"
        );

        Pengguna pengguna =
                manajer.login(
                        "bintang",
                        "password123"
                );

        assertNotNull(pengguna);
        assertEquals("bintang", pengguna.getUsername());
    }
}