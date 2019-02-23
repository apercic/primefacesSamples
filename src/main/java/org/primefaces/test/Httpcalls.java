package org.primefaces.test;

import model.Plant;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
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

    /**
     * Get json object from test server and displays it in field ikebana
     *
     * @return
     */
    public void hppRequest() {
        ikebana = "nova nova";

        HttpClient client = HttpClientBuilder.create().build();
        try {
            HttpGet request = new HttpGet("http://jsonplaceholder.typicode.com/todos/1");
            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String temp = EntityUtils.toString(entity);
                ikebana = temp;
                System.out.println(temp);
                EntityUtils.consume(entity);  //relesea entity
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void asignObject() {
        Plant myFirstPlant = new Plant("marjetica", "bela");


    }
}