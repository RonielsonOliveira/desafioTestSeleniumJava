import org.junit.After;
import org.junit.Before;

public class TestBase {
    protected TestBase(){

    }
    @Before
    public void setUp(){
        Driver.initDriver();
    }
    @After
    public void tearDown(){
        Driver.quiDriver();
    }
}
