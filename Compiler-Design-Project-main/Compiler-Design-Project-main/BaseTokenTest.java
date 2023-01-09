import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseTokenTest {

    private SymTable symTable;
    private Argdecl argdecl;

    // Case 1
    @Test
    void getTypeTR1()
    {
        symTable = new SymTable();
        argdecl = new Argdecl("type","0",false);

        SymTable.Type expected = SymTable.Type.INT;

        SymTable.Type actual = argdecl.getType("int");

        assertEquals(expected,actual);
    }

    // Case 2
    @Test
    void getTypeTR2()
    {
        symTable = new SymTable();
        argdecl = new Argdecl("type","0",false);

        SymTable.Type expected = SymTable.Type.INT;

        SymTable.Type actual = argdecl.getType("bool");

        assertTrue(expected != actual);
    }

    // Case 3
    @Test
    void getTypeTR3()
    {
        symTable = new SymTable();
        argdecl = new Argdecl("type","0",false);

        SymTable.Type expected = SymTable.Type.BOOL;

        SymTable.Type actual = argdecl.getType("bool");

        assertTrue(expected == actual);
    }

    // Case 4
    @Test
    void getTypeTR4()
    {
        symTable = new SymTable();
        argdecl = new Argdecl("type","0",false);

        SymTable.Type expected = SymTable.Type.BOOL;

        SymTable.Type actual = argdecl.getType("char");

        assertTrue(expected != actual);
    }

    // Case 5
    @Test
    void getTypeTR5()
    {
        symTable = new SymTable();
        argdecl = new Argdecl("type","0",false);

        SymTable.Type expected = SymTable.Type.CHAR;

        SymTable.Type actual = argdecl.getType("char");

        assertTrue(expected == actual);
    }

    // Case 6
    @Test
    void getTypeTR6()
    {
        symTable = new SymTable();
        argdecl = new Argdecl("type","0",false);

        SymTable.Type expected = SymTable.Type.CHAR;

        SymTable.Type actual = argdecl.getType("float");

        assertTrue(expected != actual);
    }

    // Case 7
    @Test
    void getTypeTR7()
    {
        symTable = new SymTable();
        argdecl = new Argdecl("type","0",false);

        SymTable.Type expected = SymTable.Type.FLOAT;

        SymTable.Type actual = argdecl.getType("float");

        assertTrue(expected == actual);
    }

    // Case 8
    @Test
    void getTypeTR8()
    {
        symTable = new SymTable();
        argdecl = new Argdecl("type","0",false);

        SymTable.Type expected = SymTable.Type.FLOAT;

        SymTable.Type actual = argdecl.getType("string");

        assertTrue(expected != actual);
    }


    // Case 9
    @Test
    void getTypeTR9()
    {
        symTable = new SymTable();
        argdecl = new Argdecl("type","0",false);

        SymTable.Type expected = SymTable.Type.STRING;

        SymTable.Type actual = argdecl.getType("string");

        assertTrue(expected == actual);
    }

    // Case 10
    @Test
    void getTypeTR10()
    {
        symTable = new SymTable();
        argdecl = new Argdecl("type","0",false);

        SymTable.Type expected = SymTable.Type.STRING;

        SymTable.Type actual = argdecl.getType("void");

        assertTrue(expected != actual);

    }

    // Case 11
    @Test
    void getTypeTR11()
    {
        symTable = new SymTable();
        argdecl = new Argdecl("type","0",false);

        SymTable.Type expected = SymTable.Type.VOID;

        SymTable.Type actual = argdecl.getType("void");

        assertTrue(expected == actual);
    }

    // Case 12
    @Test
    void getTypeTR12()
    {
        symTable = new SymTable();
        argdecl = new Argdecl("type","0",false);

        SymTable.Type expected = SymTable.Type.VOID;

        SymTable.Type actual = argdecl.getType("LOL");

        assertTrue(expected != actual);
    }
}