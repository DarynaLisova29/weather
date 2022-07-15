package com.example.weather;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttom;

    @FXML
    private TextField city_field;

    @FXML
    private TextField feel_temp;

    @FXML
    private TextField max;

    @FXML
    private TextField min;

    @FXML
    private TextField temp;



    @FXML
    void initialize() throws IOException {


        buttom.setOnAction(event->{
            String city_str=city_field.getText();
            String link_1="https://www.meteoprog.ua/ua/weather/";
            String link=link_1+city_str+"/";
            Document doc= null;
            try {
                doc = Jsoup.connect(link).get();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String temp1=doc.getElementsByClass("today-temperature").text();
            temp.setText(temp1);
            String temp_feeling=doc.getElementsByClass("feels-like").text();
            String [] temp_feel=temp_feeling.split(" ");
            for(String word:temp_feel){
                System.out.println(word);
            }
            feel_temp.setText(temp_feel[2]);
            String max_temp=doc.getElementsByClass("temperature-max").text();
            String [] max_te=max_temp.split(" ");
            for(String temp:max_te){
                System.out.println(temp);
            }
            max.setText(max_te[2]);
            String min_temp=doc.getElementsByClass("temperature-min").text();
            String [] min_te=min_temp.split(" ");
            for(String temp:min_te){
                System.out.println(temp);
            }
            min.setText(max_te[2]);
            max.setText(min_te[2]);

            System.out.println(temp_feeling);
//            System.out.println(temp2);
            System.out.println(temp1);
            System.out.println("Привіт світ");
            System.out.println(city_str);
            System.out.println(min_temp);
            System.out.println(max_temp);
//            System.out.println(doc.title());
//            System.out.println(doc.toString());

        });
    }



}