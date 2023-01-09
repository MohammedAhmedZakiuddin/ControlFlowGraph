import org.junit.jupiter.api.Test;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class SymTableTest {

    private SymTable symTable;
    private Argdecl argdecl;

    // Case 1
    @Test
    void getVarTR1() throws Exception {
        symTable = new SymTable();
        argdecl = new Argdecl("int","0",false);
        symTable.createScope();
        symTable.add("no_method","function", SymTable.Type.INT,null);
        symTable.add("method","function", SymTable.Type.INT,null);

//        SymTable.Var var = new SymTable().new Var("method","function", SymTable.Type.INT,null);


        SymTable.Var var = symTable.getVar("method");

        assertEquals("method", var.name);

    }

    // Case 2
    @Test
    void getVarTR2() throws Exception {

        symTable = new SymTable();
        argdecl = new Argdecl("int","0",false);
        symTable.createScope();
        symTable.add("no_method","function", SymTable.Type.INT,null);

//        SymTable.Var var = new SymTable().new Var("method","function", SymTable.Type.INT,null);


        SymTable.Var var = symTable.getVar("no_method");

        assertEquals("no_method", var.name);
    }

    // case 3
    @Test
    void getVarTR3() throws Exception {

        symTable = new SymTable();
        argdecl = new Argdecl("int","0",false);

        SymTable.Var var = symTable.getVar("third_method");

        assertEquals("third_method", var.name);
    }

    // Case 4
    @Test
    void getVarTR4() throws Exception {

        symTable = new SymTable();
        argdecl = new Argdecl("int","0",false);
        symTable.createScope();
        symTable.add("first","function", SymTable.Type.INT,null);
        symTable.add("second","function", SymTable.Type.INT,null);
        symTable.add("third","function", SymTable.Type.INT,null);
        symTable.add("fourth","function", SymTable.Type.INT,null);


        SymTable.Var var = symTable.getVar("fourth");

        assertEquals("fourth", var.name);
    }

    // Case 5
    @Test
    void getVarTR5() throws Exception {

        symTable = new SymTable();
        argdecl = new Argdecl("int","0",false);
        symTable.createScope();
        symTable.add("first","function", SymTable.Type.INT,null);
        symTable.add("second","function", SymTable.Type.INT,null);
        symTable.add("third","function", SymTable.Type.INT,null);
        symTable.add("fourth","function", SymTable.Type.INT,null);


        SymTable.Var var = symTable.getVar("fourth");

        assertEquals("fourth", var.name);
    }

    // Case 6
    @Test
    void getVarTR6() throws Exception {

        symTable = new SymTable();
        argdecl = new Argdecl("int","0",false);
        symTable.createScope();
        symTable.add("first","function", SymTable.Type.INT,null);
        symTable.add("second","function", SymTable.Type.INT,null);
        symTable.add("third","function", SymTable.Type.INT,null);
        symTable.add("fourth","function", SymTable.Type.INT,null);


        SymTable.Var var = symTable.getVar("Sixth");

        assertEquals("Sixth", var.name);
    }

}