package com.papel.higienico;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.After;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PapelHigienicoApplicationTests {
    @Before
    @Test //
    public void postTest(){
        int ResponseCode = 0;
        try {
            URL url = new URL("http://localhost:8080/api/paper");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            String input = "{\"id\":\"100\",\"brand\":\"PapelDePrueba\",\"description\":\"Papel\"}";
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();
            ResponseCode = conn.getResponseCode();
            BufferedReader br = new BufferedReader(new InputStreamReader(
            (conn.getInputStream())));
            String output;
            System.out.println("Output POST request");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            conn.disconnect();
            } catch (MalformedURLException e) {
                    e.printStackTrace();
            } catch (IOException e) {
		e.printStackTrace();
	}
        Assert.assertFalse("Error: "+ResponseCode , ResponseCode!=200);
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
                Assert.assertFalse("Error: "+ResponseCode , ResponseCode!=200);
    }
    
    @Test // UPDATE
    public void putTest() {
        int ResponseCode = 0;
        try {
            URL url = new URL("http://localhost:8080/api/paper/100");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            String input = "{\"brand\":\"PapelDePruebaUpdated\",\"description\":\"PapelUpdated\"}";
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();
            ResponseCode = conn.getResponseCode();
            BufferedReader br = new BufferedReader(new InputStreamReader(
            (conn.getInputStream())));
            String output;
            System.out.println("Output PUT request");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            conn.disconnect();
            } catch (MalformedURLException e) {
                    e.printStackTrace();
            } catch (IOException e) {
		e.printStackTrace();
	}
        Assert.assertFalse("Error: "+ResponseCode , ResponseCode!=200);
    }
    
    @Test // READ
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
        Assert.assertFalse("Error: "+ResponseCode , ResponseCode!=200);
    }
    
}
