package com.wrongkey.pos.model;

import junit.framework.TestCase;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({RegularItemTest.class,
        SecondHalfPriceItemTest.class,
        DiscountItemTest.class,
        FullHundredMinusItemTest.class,
        CartTest.class,
        ItemTest.class,
        CalculateTest.class,
        CartStatementTest.class})
public class PosTestSuite extends TestCase {

}

