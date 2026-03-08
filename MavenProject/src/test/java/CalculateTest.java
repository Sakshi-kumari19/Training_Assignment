import cg.Calculator;
import org.junit.jupiter.api.*;

import javax.lang.model.element.Name;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;



public class CalculateTest {
    static Calculator cal;
//    @BeforeEach
//    public void init(){
//           cal = new Calculator();
//           System.out.println("obj Created");
//    }
//    @AfterEach
//    public void destroy(){
//        cal = new Calculator();
//        System.out.println("obj destroyed");
//    }

    @BeforeAll
    public static void init(){
        cal = new Calculator();
        System.out.println("obj Created");
    }
    @AfterAll
    public static void destroy(){
        cal = new Calculator();
        System.out.println("obj destroyed");
    }

    //use BeforeAll and BeforeEach according to use.
    //BeforeAll runs only one time before all functions.

    @Test
    @DisplayName(value="Testing cal test")
    public void calTest(){
//        Calculator cal = new Calculator();
        assertEquals(11,cal.calc(5,6));

    }
    //@Test
    //@Timeout(value = 77,unit = TimeUnit.SECONDS)
    //@Disabled
    @ParameterizedTest
    @ValueSource(ints = {13,17,19,53})
    public void isPrimeTest(int num){
        Calculator cal = new Calculator();

        assertTrue(cal.isPrime(num));
        assertFalse(cal.isPrime(1));
        assertFalse(cal.isPrime(16));
        assertFalse(cal.isPrime(0));



    }

    @DisplayName(value = "Testing calculate")
    @ParameterizedTest
    @CsvSource({"2,3,5","5,6,11","8,1,9"})
    public void addTest(int n1,int n2,int result){
        assertEquals(result,cal.calc(n1,n2));
    }
}
