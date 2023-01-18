package firstCodeClass;

import org.junit.After;
import org.junit.Test;

public class Tests {
    WaitTypes waitTypes = new WaitTypes();
    @Test
    public void testWaitImplicit(){
        waitTypes.testWaitImplicit(7);
    }

    @Test
    public void testWaitExplicit(){
        waitTypes.testWaitExplicit(30);
    }

    @Test
    public void testFluentWait(){
        waitTypes.testFluentWait(30, 5000);
    }
    @After
    public void finish(){
        waitTypes.finishTesting();
    }

}
