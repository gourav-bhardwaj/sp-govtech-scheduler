package com.sp.spgovtechscheduler;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
@WebMvcTest(MyCustomScheduler.class)
class MyCustomSchedulerTest {

    @SpyBean
    MyCustomScheduler myCustomScheduler;

    @Test
    void scheduledTaskTest() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        /**
         * Here you can put any additional logic to check the functionality.
         * As of now we just check method running at least once or not.
         * **/
        Mockito.verify(myCustomScheduler, Mockito.atLeastOnce()).scheduledTask();
    }

}
