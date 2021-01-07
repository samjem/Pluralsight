/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.pluralsight.client.ActivityClient;
import com.pluralsight.model.Activity;
import org.junit.Test;
import static org.testng.Assert.*;

/**
 *
 * @author sambailey
 */
public class ActivityClientTest {

    @Test
    public void testGet() {
        ActivityClient client = new ActivityClient();
        
        Activity activity = client.get("1234");
        
        System.out.println(activity);
        
        assertNotNull(activity);
    }

}
