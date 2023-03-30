package yasinhoca.day07;

import org.junit.*;

public class C04_BeforeClassAfterClass {

    /*
    @BeforeClass ve @AfterClass notasyonlari
    sadece statik methodlar ile calisir
     */

    @BeforeClass
    public static  void setUp() {
        System.out.println("tüm testlerden önce bir kez calisir ");
        System.out.println("==================");
    }

    @AfterClass
    public static  void tearDown() {
        System.out.println("tüm testlerden sonra bir kez calisir ");
        System.out.println("==================");
    }
    @Before
    public   void setUp2() {
        System.out.println("her testen önce bir kez calisir ");
        System.out.println("==================");
    }

    @After
    public  void tearDown2() {
        System.out.println("her testen sonra bir kez calisir ");
        System.out.println("==================");
    }
    @Test
    public void test01(){
        System.out.println("ilk test");
        System.out.println("=============");
    }
    @Test
    public void test02(){
        System.out.println("ikinci test");
        System.out.println("=============");
    }
    @Test
    public void test03(){
        System.out.println("ücüncü test");
        System.out.println("=============");
    }

}
