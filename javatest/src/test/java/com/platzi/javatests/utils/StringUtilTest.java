package com.platzi.javatests.utils;


import com.platzi.javatests.util.StringUtil;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringUtilTest {

    @Test
    public void repeat_string_once(){
        Assert.assertEquals("hola", StringUtil.repeat("hola",1));
    }

    @Test
    public void repeat_string_multiple_times(){
        Assert.assertEquals("holaholahola",StringUtil.repeat("hola",3));
    }

    @Test
    public void repeat_string_zero_times(){
        Assert.assertEquals("",StringUtil.repeat("hola",0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void repeat_string_negative_times(){
        StringUtil.repeat("hola",-1);
    }

    @Test
    public void any_string_is_not_empty() {
        assertFalse(StringUtil.isEmpty("Hola Mundo"));
    }
    @Test
    public void any_string_is_empty() {
        assertTrue(StringUtil.isEmpty(""));
    }
    @Test
    public void null_string_is_empty() {
        assertTrue(StringUtil.isEmpty(null));
    }
    @Test
    public void blank_string_is_empty() {
        assertTrue(StringUtil.isEmpty(" "));
    }

}