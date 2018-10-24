package org.primefaces.test;

import org.apache.http.*;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;


@ManagedBean(eager = true, name = "httpcalls")
@ViewScoped
public class Httpcalls implements Serializable {
    private String ikebana;

    //must have init for string values
    @PostConstruct
    public void init() {
        ikebana = "prva";
    }

    //must have getters and setters
    public void setIkebana(String ikebana) {
        this.ikebana = ikebana;
    }
    public String getIkebana() {
        return ikebana;
    }

    public String hpp() {
        ikebana = "nova nova";

        DefaultHttpClient httpclient = new DefaultHttpClient();
        try {
            HttpHost target = new HttpHost("jsonplaceholder.typicode.com", 80, "http");
            HttpGet getRequest = new HttpGet("/todos/1");

            HttpResponse httpResponse = httpclient.execute(target, getRequest);
            HttpEntity entity = httpResponse.getEntity();

            if (entity != null) {
                String temp =  EntityUtils.toString(entity);
                ikebana = temp;
                System.out.println(temp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpclient.getConnectionManager().shutdown();
        }
        return "";
    }
}