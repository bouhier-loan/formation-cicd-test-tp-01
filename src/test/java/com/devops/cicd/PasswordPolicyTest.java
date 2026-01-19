package com.devops.cicd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordPolicyTest {

    @Test
    public void validPassword(){
        assertTrue(PasswordPolicy.isStrong("Azerty1!"));
    }

    @Test
    public void validPassword2(){
        assertTrue(PasswordPolicy.isStrong("Aze57745ssdfSS445$$$$rt547455445y1!"));
    }

    @Test
    public void tooShortPassword(){
        assertFalse(PasswordPolicy.isStrong("Aer"));
    }

    @Test
    public void tooShortPassword2(){
        assertFalse(PasswordPolicy.isStrong("Ae0!"));
    }

    @Test
    public void noUppercase(){
        assertFalse(PasswordPolicy.isStrong("eeee"));
    }

    @Test
    public void noUppercase2(){
        assertFalse(PasswordPolicy.isStrong("eddfdf0!"));
    }

    @Test
    public void noLowercase(){
        assertFalse(PasswordPolicy.isStrong("AAAAAAAA"));
    }

    @Test
    public void noLowercase2(){
        assertFalse(PasswordPolicy.isStrong("AAAAAA0!"));
    }

    @Test
    public void noDigits(){
        assertFalse(PasswordPolicy.isStrong("a!afDDad!ad"));
    }

    @Test
    public void noSpecialChars(){
        assertFalse(PasswordPolicy.isStrong("a0afDDad0ad"));
    }

}
