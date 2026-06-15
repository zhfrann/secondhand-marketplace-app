package secondhand_marketplace.app;

import org.junit.Test;

import secondhand_marketplace.akun.ManajerAkun;
import secondhand_marketplace.pengguna.Pengguna;

import static org.junit.Assert.*;

public class ManajerAkunTest {

    @Test
    public void testRegisterAndGetUser() {
        ManajerAkun manajer = new ManajerAkun();
        manajer.register("newUser", "pass123", "new@mail.com", "081234");
        Pengguna user = manajer.getDaftarPengguna().get("newUser");
        assertNotNull(user);
        assertEquals("newUser", user.getUsername());
        assertEquals("new@mail.com", user.getEmail());
    }
}
