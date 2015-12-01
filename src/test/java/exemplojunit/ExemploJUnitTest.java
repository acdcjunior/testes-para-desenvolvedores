package exemplojunit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ExemploJUnitTest {

    private String minhaString = "minhaString Inicial";

    public ExemploJUnitTest() {
        System.out.println("Construtor");
    }

    @BeforeClass
    public static void oneTimeSetUp() {
        System.out.println("@BeforeClass - inicializacao uma ves para todos os testes");
    }

    @AfterClass
    public static void oneTimeTearDown() {
        System.out.println("@AfterClass - finalizacao uma vez para todos os testes");
    }

    @Before
    public void setUp() {
        System.out.println("@Before - inicializa pra cada teste");
    }

    @After
    public void tearDown() {
        System.out.println("@After - finaliza pra cada teste");
    }

    @Test
    public void testeUm() {
        System.out.println("@Test - testeUm");
        minhaString = "testeUm";
        System.out.println("    Valor 'minhaString': "+minhaString);
    }

    @Test
    public void testeDois() {
        System.out.println("@Test - testeDois");
        System.out.println("    Valor 'minhaString': "+minhaString);
    }

}