package com.platzi.javatests.utils;

import com.platzi.javatests.util.PasswordUtil;
import org.junit.Assert;
import org.junit.Test;

public class PasswordUtilTest {

    @Test
    public void weak_when_has_less_than_8_letters(){
        Assert.assertEquals(PasswordUtil.SecurityLevel.WEAK, PasswordUtil.assessPassword("1234567"));
    }
    @Test
    public void weak_when_has_only_letters(){
        Assert.assertEquals(PasswordUtil.SecurityLevel.WEAK, PasswordUtil.assessPassword("abcdefghi"));
    }
    @Test
    public void weak_when_has_letters_numbers(){
        Assert.assertEquals(PasswordUtil.SecurityLevel.MEDIUM, PasswordUtil.assessPassword("abcd1234"));
    }
    @Test
    public void weak_when_has_letters_numbers_and_symbols(){
        Assert.assertEquals(PasswordUtil.SecurityLevel.STRONG, PasswordUtil.assessPassword("abcd123!"));
    }

}