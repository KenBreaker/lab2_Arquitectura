/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.papel.higienico;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kevin
 */
public class deleteTest {
    
    public deleteTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test // DELETE
    public void deleteTest() {
        int ResponseCode = 0;
        try {
            URL url = new URL("http://localhost:8080/api/paper/100");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("DELETE");
            ResponseCode = conn.getResponseCode();
            conn.disconnect();
            } catch (MalformedURLException e) {
                    e.printStackTrace();
            } catch (IOException e) {
		e.printStackTrace();
	}
        Assert.assertFalse("Codigo de Error: "+ResponseCode , ResponseCode!=200);
    }
}
