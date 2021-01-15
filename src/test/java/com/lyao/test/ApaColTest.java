package com.lyao.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author lyao
 * @date 2018/5/14 17:17
 */
public class ApaColTest {

    @Before
    public void setUp() throws Exception {
        System.out.println("before");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("after");
    }

    @Test
    public void testDo() {
        String cardId = "37011901230202199410";
        System.out.println(cardId.substring(0,4));
        System.out.println(cardId.substring(4,20));
    }
}