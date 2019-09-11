package co.com.sofka.products;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class TestMainApplication {

    @Test
    public void testMain(){
        MainApplication.main(new String[]{});
    }
}
