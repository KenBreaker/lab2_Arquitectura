/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.papel.higienico;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
public class getTest {
    
    public getTest() {
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

    @Test // READ
    public void getTest() {
        int ResponseCode = 0;
	try {
		URL url = new URL("http://localhost:8080/api/paper");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
                ResponseCode = conn.getResponseCode();
		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		String output;
		System.out.println("Output GET request");
		while ((output = br.readLine()) != null) {
                    System.out.println(output);
		}
                conn.disconnect();
		} catch (MalformedURLException e) {
                    e.printStackTrace();
		} catch (IOException e) {
                    e.printStackTrace();
		}
                Assert.assertFalse("Codigo de Error: "+ResponseCode , ResponseCode!=200);
    }
}
