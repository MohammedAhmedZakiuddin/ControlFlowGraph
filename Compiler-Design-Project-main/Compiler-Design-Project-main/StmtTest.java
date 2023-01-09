//import org.junit.jupiter.api.Test;
import org.junit.Test;

import java.util.ArrayList;
import java.util.function.UnaryOperator;

import static org.junit.jupiter.api.Assertions.*;

public class StmtTest
{
    private Expr expr;
    private Stmt stmt;
    private Stmt elsest;

    // TR1
    @Test
    public void testToStringTR1()
    {
        expr = new Expr(1);

        ArrayList<Fielddecl> fs1 = new ArrayList<>();
        ArrayList<Stmt> sts1 = new ArrayList<>();
        boolean semi1 = true;
        stmt = new Stmt(fs1,sts1,semi1);



        ArrayList<Fielddecl> fs2 = new ArrayList<>();
        ArrayList<Stmt> sts2 = new ArrayList<>();
        boolean semi2 = true;

        elsest = new Stmt(fs2,sts2,semi2);


        Stmt stmt1 = new Stmt(expr,stmt,elsest);
        String result = stmt1.toString(0);

        assertEquals("if (1)\n" +
                "{\n" +
                "}\n" +
                "else\n" +
                "{\n" +
                "}",result);
    }

    // TR2
    @Test
    public void testToStringTR2() {
        expr = new Expr(1);


        ArrayList<Fielddecl> fs1 = new ArrayList<>();
        ArrayList<Stmt> sts1 = new ArrayList<>();
        boolean semi1 = true;
        stmt = new Stmt(fs1, sts1, semi1);


        Name n = new Name("1");

        elsest = new Stmt(n, expr);


        Stmt stmt1 = new Stmt(expr, stmt, elsest);
        String result = stmt1.toString(0);

        assertEquals("if (1)\n" +
                "{\n" +
                "}\n" +
                "else\n" +
                "{\n" +
                "\t1 = 1;\n" +
                "}",result);

    }

    // TR3
    @Test
    public void testToStringTR3()
    {
        expr = new Expr(1);


        ArrayList<Fielddecl> fs1 = new ArrayList<>();
        ArrayList<Stmt> sts1 = new ArrayList<>();
        boolean semi1 = true;
        stmt = new Stmt(fs1, sts1, semi1);


        Name n = new Name("1");

        elsest = null;


        Stmt stmt1 = new Stmt(expr, stmt, elsest);
        String result = stmt1.toString(0);

        assertEquals("if (1)\n" +
                "{\n" +
                "}",result);
    }

    // TR4
    @Test
    public void testToStringTR4()
    {
        expr = new Expr(1);

        Stmt st = new Stmt();

        stmt = new Stmt(expr, st);


        Name n = new Name("1");

        ArrayList<Fielddecl> fs2 = new ArrayList<>();
        ArrayList<Stmt> sts2 = new ArrayList<>();
        boolean semi2 = true;

        elsest = new Stmt(fs2,sts2,semi2);


        Stmt stmt1 = new Stmt(expr, stmt, elsest);
        String result = stmt1.toString(0);
        assertEquals("if (1)\n" +
                "{\n" +
                "\twhile (1)\n" +
                "\t\treturn;\n" +
                "\n" +
                "}\n" +
                "else\n" +
                "{\n" +
                "}",result);


    }

    // TR5
    @Test
    public void testToStringTR5()
    {
        expr = new Expr(1);

        Stmt st = new Stmt();

        stmt = new Stmt(expr, st);


        Name n = new Name("1");



        elsest = new Stmt(expr,st);


        Stmt stmt1 = new Stmt(expr, stmt, elsest);
        String result = stmt1.toString(0);
        assertEquals("if (1)\n" +
                "{\n" +
                "\twhile (1)\n" +
                "\t\treturn;\n" +
                "\n" +
                "}\n" +
                "else\n" +
                "{\n" +
                "\twhile (1)\n" +
                "\t\treturn;\n" +
                "\n" +
                "}",result);
    }
    // TR6
    @Test
    public void testToStringTR6()
    {
        expr = new Expr(1);

        Stmt st = new Stmt();

        stmt = new Stmt(expr, st);


        Name n = new Name("1");



        elsest = null;


        Stmt stmt1 = new Stmt(expr, stmt, elsest);
        String result = stmt1.toString(0);
        assertEquals("if (1)\n" +
                "{\n" +
                "\twhile (1)\n" +
                "\t\treturn;\n" +
                "\n" +
                "}",result);
    }

    // TR7
    @Test
    public void testToStringTR7()
    {
        String id = "Hi";
        ArrayList<Expr> ag = new ArrayList<>();
        ag.add(new Expr(1));
        ag.add(new Expr(2));
        ag.add(new Expr(3));
        boolean func = true;

        stmt= new Stmt(id,ag,func);

        String result = stmt.toString(0);
        assertEquals("Hi(1, 2, 3);",result);
    }


    // TR8
    @Test
    public void testToStringTR8()
    {
        String id = "foo";
        ArrayList<Expr> ag = new ArrayList<>();
        ag.add(new Expr("ab",'c'));
        boolean func = true;

        stmt= new Stmt(id,ag,func);

        String result = stmt.toString(0);

        assertEquals("foo(ab);",result);
    }

    // TR9
    @Test
    public void testToStringTR9()
    {
        String id = "Hi";
        ArrayList<Expr> ag = new ArrayList<>();
        ag.add(new Expr(new Name("foo",new Expr(1))));
        boolean func = true;

        stmt= new Stmt(id,ag,func);

        String result = stmt.toString(0);
        assertEquals("Hi(foo[1]);",result);
    }

    // TR10
    @Test
    public void testToStringTR10()
    {
        String id = "Hi";
        ArrayList<Expr> ag = new ArrayList<>();
        ag.add(new Expr(1));
        ag.add(new Expr(2));
        ag.add(new Expr(3));
        boolean func = true;

        stmt= new Stmt(id,ag,func);

        String result = stmt.toString(0);
        assertEquals("Hi(1, 2, 3);",result);
    }

    // TR11
    @Test
    public void testToStringTR11()
    {
        String id = "Hi";
        ArrayList<Expr> ag = new ArrayList<>();
        ag.add(new Expr(1));
        ag.add(new Expr(2));
        ag.add(new Expr(3));
        boolean func = true;

        stmt= new Stmt(id,ag,func);

        String result = stmt.toString(0);
        assertEquals("Hi(1, 2, 3);",result);
    }

    // TR12
    @Test
    public void testToStringTR12()
    {
        String id = "Hi";
        ArrayList<Expr> ag = new ArrayList<>();
        ag.add(new Expr("foo",'s'));
        ag.add(new Expr("foo1",'s'));
        ag.add(new Expr("foo2",'s'));
        boolean func = true;

        stmt= new Stmt(id,ag,func);

        String result = stmt.toString(0);
        assertEquals("Hi(foo, foo1, foo2);",result);
    }

    // TR13
    @Test
    public void testToStringTR13()
    {
        String id = "Hi";
        ArrayList<Expr> ag = new ArrayList<>();
        ag.add(new Expr("foo",'s'));
        ag.add(new Expr("ct",new Expr(1)));
        boolean func = true;

        stmt= new Stmt(id,ag,func);

        String result = stmt.toString(0);
        assertEquals("Hi(foo, (ct)1);",result);
    }

    // TR14
    @Test
    public void testToStringTR14()
    {
        ArrayList<Fielddecl> fs = new ArrayList<>();
        fs.add(new Fielddecl("int","1", 1));
        ArrayList<Stmt> sts = new ArrayList<>();
        boolean semi = true;

        stmt = new Stmt(fs,sts,semi);


        String result = stmt.toString(0);

        assertEquals("{\n" +
                "\tint 1[1];\n" +
                "}",result);
    }

    // TR15
    @Test
    public void testToStringTR15()
    {
        ArrayList<Fielddecl> fs = new ArrayList<>();
        ArrayList<Stmt> sts = new ArrayList<>();
        boolean semi = true;

        stmt = new Stmt(fs,sts,semi);


        String result = stmt.toString(0);
        assertEquals("{\n" +
                "}",result);
    }

    // TR16
    @Test
    public void testToStringTR16()
    {
        ArrayList<Fielddecl> fs = new ArrayList<>();
        fs.add(new Fielddecl("int","1", 1));
        ArrayList<Stmt> sts = new ArrayList<>();
        sts.add(new Stmt("foo"));
        boolean semi = true;

        stmt = new Stmt(fs,sts,semi);


        String result = stmt.toString(0);
        assertEquals("{\n" +
                "\tint 1[1];\n" +
                "\tfoo();\n" +
                "}",result);
    }
    // TR17
    @Test
    public void testToStringTR17()
    {
        ArrayList<Fielddecl> fs = new ArrayList<>();
        fs.add(new Fielddecl("int","1", 1));
        fs.add(new Fielddecl("String","11", 1));

        ArrayList<Stmt> sts = new ArrayList<>();
        boolean semi = true;

        stmt = new Stmt(fs,sts,semi);


        String result = stmt.toString(0);

        assertEquals("{\n" +
                "\tint 1[1];\n" +
                "\tString 11[1];\n" +
                "}",result);
    }

    // TR18
    @Test
    public void testToStringTR18()
    {
        ArrayList<Fielddecl> fs = new ArrayList<>();
        fs.add(new Fielddecl("int","1", 1));
        fs.add(new Fielddecl("String","11", 1));

        ArrayList<Stmt> sts = new ArrayList<>();
        boolean semi = true;

        stmt = new Stmt(fs,sts,semi);


        String result = stmt.toString(0);

        assertEquals("{\n" +
                "\tint 1[1];\n" +
                "\tString 11[1];\n" +
                "}",result);
    }

    // TR19
    @Test
    public void testToStringTR19()
    {
        ArrayList<Fielddecl> fs = new ArrayList<>();
        fs.add(new Fielddecl("int","1", 1));
        fs.add(new Fielddecl("String","11", 1));

        ArrayList<Stmt> sts = new ArrayList<>();
        sts.add(new Stmt("foo"));
        sts.add(new Stmt("boo"));


        boolean semi = true;

        stmt = new Stmt(fs,sts,semi);


        String result = stmt.toString(0);

        assertEquals("{\n" +
                "\tint 1[1];\n" +
                "\tString 11[1];\n" +
                "\tfoo();\n" +
                "\tboo();\n" +
                "}",result);
    }

    // TR20
    @Test
    public void testToStringTR20()
    {
        ArrayList<Fielddecl> fs = new ArrayList<>();
        fs.add(new Fielddecl("int","1", 1));
        fs.add(new Fielddecl("String","11", 1));

        ArrayList<Stmt> sts = new ArrayList<>();
        sts.add(new Stmt("foo"));
        sts.add(new Stmt("boo"));


        boolean semi = true;

        stmt = new Stmt(fs,sts,semi);


        String result = stmt.toString(0);

        assertEquals("{\n" +
                "\tint 1[1];\n" +
                "\tString 11[1];\n" +
                "\tfoo();\n" +
                "\tboo();\n" +
                "}",result);
    }

    // TR21
    @Test
    public void testToStringTR21()
    {
        ArrayList<Fielddecl> fs = new ArrayList<>();
        fs.add(new Fielddecl("int","1", 1));
        fs.add(new Fielddecl("String","11", 1));

        ArrayList<Stmt> sts = new ArrayList<>();
        sts.add(new Stmt("foo"));
        sts.add(new Stmt("boo"));


        boolean semi = true;

        stmt = new Stmt(fs,sts,semi);


        String result = stmt.toString(0);

        assertEquals("{\n" +
                "\tint 1[1];\n" +
                "\tString 11[1];\n" +
                "\tfoo();\n" +
                "\tboo();\n" +
                "}",result);
    }

    // TR22
    @Test
    public void testToStringTR22()
    {
        ArrayList<Fielddecl> fs = new ArrayList<>();
        fs.add(new Fielddecl("int","1", 1));
        fs.add(new Fielddecl("String","11", 1));

        ArrayList<Stmt> sts = new ArrayList<>();
        sts.add(new Stmt("foo"));
        sts.add(new Stmt("boo"));


        boolean semi = true;

        stmt = new Stmt(fs,sts,semi);


        String result = stmt.toString(0);

        assertEquals("{\n" +
                "\tint 1[1];\n" +
                "\tString 11[1];\n" +
                "\tfoo();\n" +
                "\tboo();\n" +
                "}",result);
    }

    // TR23
    @Test
    public void testToStringTR23()
    {
        ArrayList<Fielddecl> fs = new ArrayList<>();
        fs.add(new Fielddecl("int","1", 1));
        fs.add(new Fielddecl("String","11", 1));

        ArrayList<Stmt> sts = new ArrayList<>();
        sts.add(new Stmt("foo"));
        sts.add(new Stmt("boo"));


        boolean semi = true;

        stmt = new Stmt(fs,sts,semi);


        String result = stmt.toString(0);

        assertEquals("{\n" +
                "\tint 1[1];\n" +
                "\tString 11[1];\n" +
                "\tfoo();\n" +
                "\tboo();\n" +
                "}",result);
    }

    // TR24
    @Test
    public void testToStringTR24()
    {
        Expr expr1 = new Expr(23);
        ArrayList<Fielddecl> fs = new ArrayList<>();
        ArrayList<Stmt> sts = new ArrayList<>();
        boolean semi = true;

        Stmt st1 = new Stmt(fs,sts,semi);
        stmt = new Stmt(expr1,st1);

        String result = stmt.toString(0);
        assertEquals("while (23)\n" +
                "{\n" +
                "}\n",result);
    }

    // TR25
    @Test
    public void testToStringTR25()
    {
        Expr expr1 = new Expr(23);
        Stmt st1 = new Stmt("Boo");
        stmt = new Stmt(expr1,st1);

        String result = stmt.toString(0);

        assertEquals("while (23)\n" +
                "\tBoo();\n",result);
    }

    // Case 4 - Test ID 26
    @Test
    public void testToString_Case_4()
    {
        Name n = new Name("2");
        Expr expr = new Expr(2);

        Stmt stmtMain = new Stmt(n,expr);
        String result = stmtMain.toString(0);
        String res = "2 = 2;";
        assertEquals(res, result);
    }


    //Case 5 - Test ID 27, 28, 29 ,31
    @Test
    public void testToString_Case_5()
    {
        String func = "Func";
        Name n = new Name("Read");

        Stmt stmtMain = new Stmt(n,func);
        String result = stmtMain.toString(0);
        String res = "ReadFunc;";
        assertEquals(res, result);
    }

    //Case 5 - Test ID 30
    @Test
    public void testToString_Case_5_1()
    {
        String func = "Func";
        Name n = new Name(null);

        Stmt stmtMain = new Stmt(n,func);
        String result = stmtMain.toString(0);
        String res = "nullFunc;";
        assertEquals(res, result);
    }

    // Case 6 - Test ID 32, 33, 34, 35, 36
    @Test
    public void testToString_Case_6()
    {
        String func = "Func";
        ArrayList arr = new ArrayList();

        Stmt stmtMain = new Stmt(func,arr);
        String result = stmtMain.toString(0);
        String res = "Func();";
        assertEquals(res, result);
    }

    //Case 7 - Test ID 37, 38, 39, 40, 41
    @Test
    public void testToString_Case_7()
    {
        String func = "Func";
        ArrayList arr = new ArrayList();

        Stmt stmtMain = new Stmt(func,arr);
        String result = stmtMain.toString(0);
        String res = "Func();";
        assertEquals(res, result);
    }

    //Case 8 - Test ID 42
    @Test
    public void testToString_Case_8()
    {
        Name n = new Name("John");
        String un = "hi";

        Stmt stmtMain = new Stmt(n,un);
        String result = stmtMain.toString(0);
        String res = "Johnhi;";
        assertEquals(res, result);
    }

    //Case 9 - Test ID 43
    @Test
    public void testToString_Case_9()
    {
        Expr expr = new Expr(2);

        Stmt stmtMain = new Stmt(expr);
        String result = stmtMain.toString(0);
        String res = "return 2;";
        assertEquals(res, result);
    }

    //Case 10 - Test ID 44
    @Test
    public void testToString_Case_10()
    {
        Stmt stmtMain = new Stmt("ID");
        String result = stmtMain.toString(0);
        String res = "ID();";
        assertEquals(res, result);
    }

    //Case 11 Test ID 45
    @Test
    public void testToString_Case_11()
    {
        Stmt stmtMain = new Stmt("return");
        String result = stmtMain.toString(0);
        String res = "return();";
        assertEquals(res, result);
    }

    //Default Case Test ID 46
    @Test
    public void testToString_Default_Case()
    {
        Stmt stmtMain = new Stmt("");
        String result = stmtMain.toString(0);
        String res = "();";
        assertEquals(res, result);
    }
}