package com.tw.bibilioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UsersTest {
    @Test
    public void shouldNotReturnUserInformationForInValidUserToken() {
        assertTrue(new Users().getUserInformationFromToken("11404444") == null);
    }

    @Test
    public void shouldReturnUserInformationForValidUserToken() {
        assertTrue(new Users().getUserInformationFromToken("34404444") != null);
    }

    @Test
    public void shouldReturnUserInformationForValidGuestToken() {
        assertTrue(new Users().getUserInformationFromToken(new GuestUser().authenticate()) != null);
    }
    @Test
    public void shouldReturnAdminRoleInformationForValidAdminUserToken() {
        assertEquals(new Users().getUserRole("34404444").getClass(), Admin.class);
    }

    @Test
    public void shouldReturnUserRoleInformationForValidNonAdminUserToken() {
        assertEquals(new Users().getUserRole("35505555").getClass(), NonAdminUser.class);
    }

    @Test
    public void shouldReturnGuestRoleInformationForValidGuestToken() {
        assertEquals(new Users().getUserRole(new GuestUser().authenticate()).getClass(), Guest.class);
    }

    @Test
    public void shouldReturnLibraryNumberForUsers() {
        assertEquals(new Users().getUserLibraryNumber("35505555"), "022-2222");
    }


}