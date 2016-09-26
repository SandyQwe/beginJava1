package Diary;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/*
 документация к Jsoup - https://jsoup.org/cookbook/extracting-data/selector-syntax
 погодный архив http://www.pogodaiklimat.ru/weather.php?id=28440&bday=1&fday=31&amonth=8&ayear=2016
 ещё один погодный архив - http://pogoda-service.ru/archive_gsod.php

ещё парсеры (ссылки внизу) - http://jericho.htmlparser.net/docs/index.html
 */

public class TestParseHTML {
    public static void main(String[] args) {

        File input = new File("weather_sample.htm");
        Document html = null;
        try {
            html = Jsoup.parse(input, "UTF-8");
//            html = Jsoup.connect("http://www.pogodaiklimat.ru/weather.php?id=28440&bday=1&fday=31&amonth=8&ayear=2016").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements body = html.getElementsByAttributeValueContaining("height", "30");

        for (Element element:body) {
            System.out.println(element.child(10).getElementsByTag("nobr").text().replaceAll("\\+",""));
        }
        ArrayList<WeatherEvent> weather = new ArrayList<>();
        //System.out.println(body);

    }
}
