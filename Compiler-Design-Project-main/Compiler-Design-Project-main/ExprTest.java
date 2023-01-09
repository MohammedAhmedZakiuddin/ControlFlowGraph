import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

import java.security.KeyStore;
import java.util.ArrayList;

public class ExprTest
{
    // Case 0
    @Test
    public void testToString_case0()
    {
        var char_1 = new Expr("0", 'a');
        String num = char_1.toString();
        assertEquals("0", num);
    }

    // Case 1
    @Test
    public void testToString_case1()
    {
        var char_2 = new Expr(2);
        var num = char_2.toString();
        assertEquals("2", num);
    }

    // Case 2
    @Test
    public void testToString_case2()
    {
        var char_3 = new Expr((float) 2.1);
        var num = char_3.toString();
        assertEquals("2.1", num);
    }

    // Case 3
    @Test
    public void testToString_case3()
    {
        var char_4 = new Expr(new Name("Jack"));
        var num = char_4.toString();
        assertEquals("Jack", num);
    }

    // Case 4
    @Test
    public void testToString_case4()
    {
        var char_5 = new Expr(true);
        var num = char_5.toString();
        assertEquals("true", num);
    }

    //Case 5
    @Test
    public void testToString_case5()
    {
        var char_6 = new Expr(new Expr(1));
        var num = char_6.toString();
        assertEquals("1", num);
    }

    //Case 6
    @Test
    public void testToString_case6()
    {
        var char_7 = new Expr(new Expr(2),"+");
        var num = char_7.toString();
        assertEquals("(+ 2)", num);
    }

    //Case7
    @Test
    public void testToString_case7()
    {
        var char_8 = new Expr("", new Expr(1));
        var num = char_8.toString();
        assertEquals("()1", num);
    }

    //Case 8
    @Test
    public void testToString_case8()
    {
        var char_9 = new Expr(new Expr(1),new BinaryOp("+"), new Expr(2));
        var num = char_9.toString();
        assertEquals("(1 + 2)", num);
    }

    @Test
    //Case 9
    public void testToString_case9()
    {
        var char_10 = new Expr(new Expr(1),new Expr(2), new Expr(3));
        var num = char_10.toString();
        assertEquals("( 1 ? 2 : 3 )", num);
    }

    @Test
    //Case 10 - Test ID 1
    public void testToString_case10_1()
    {
        var char_11_1 = new Expr("2", new Expr(1));
        var num = char_11_1.toString();
        assertEquals("(2)1", num);
    }

    @Test
    //Case 10 - Test ID 2
    public void testToString_case10_2()
    {
        var char_11_2 = new Expr("2",new Expr(0));
        var num = char_11_2.toString();
        assertEquals(num,"(2)0");
    }

    @Test
    //Case 10 - Test ID 3
    public void testToString_case10_3()
    {
        var char_11_3 = new Expr("0",new Expr(2));
        var num = char_11_3.toString();
        assertEquals(num,"(0)2");
    }

    @Test
    //Case 10 - Test ID 4
    public void testToString_case10_4()
    {
        var char_11_4 = new Expr("2",new Expr(0));
        var num = char_11_4.toString();
        assertEquals(num,"(2)0");
    }

    @Test
    //Case 10 - Test ID 5
    public void testToString_case10_5()
    {
        var char_11_5 = new Expr("0",new Expr(2));
        var num = char_11_5.toString();
        assertEquals(num,"(0)2");
    }

    @Test
    //Case 10 - Test ID 6
    public void testToString_case10_6()
    {
        var char_11_6 = new Expr("2",new Expr(2));
        var num = char_11_6.toString();
        assertEquals(num,"(2)2");
    }

    @Test
    //Case 10 - Test ID 7
    public void testToString_case10_7()
    {
        var char_11_7 = new Expr("0",new Expr(3));
        var num = char_11_7.toString();
        assertEquals(num,"(0)3");
    }

    @Test
    //Case 10 - Test ID 8
    public void testToString_case10_8()
    {
        var char_11_8 = new Expr("2",new Expr(2));
        var num = char_11_8.toString();
        assertEquals(num,"(2)2");
    }

    @Test
    //Case 10 - Test ID 9
    public void testToString_case10_9()
    {
        var char_11_9 = new Expr("0",new Expr(3));
        var num = char_11_9.toString();
        assertEquals(num,"(0)3");
    }

    @Test
    //Case 10 - Test ID 10
    public void testToString_case10_10()
    {
        var char_11_10 = new Expr("2",new Expr(2));
        var num = char_11_10.toString();
        assertEquals(num,"(2)2");
    }

    @Test
    //Case 10 - Test ID 11
    public void testToString_case10_11()
    {
        var char_11_11 = new Expr("0",new Expr(3));
        var num = char_11_11.toString();
        assertEquals(num,"(0)3");
    }


    @Test
    //Case 11
    public void testToString_case11()
    {
        var char_12 = new Expr("2", new Expr(true));
        var num = char_12.toString();
        assertEquals("(2)true", num);
    }

    @Test
    //Case 12
    public void testToString_case12()
    {
        var char_13 = new Expr("2", 'b');
        String num = char_13.toString();
        assertEquals("2", num);
    }
}