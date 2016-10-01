package Diary;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

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
            html = Jsoup.parse(input, "Windows-1251");
//            html = Jsoup.connect("http://www.pogodaiklimat.ru/weather.php?id=28440&bday=1&fday=31&amonth=8&ayear=2016").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements body = html.getElementsByAttributeValueContaining("height", "30");

        // временное объявление коллекции погодных данных, для проекта эта коллекция должна объявляться в основном классе
        ArrayList<WeatherEvent> weather = new ArrayList<>();

        for (Element element:body) {
            WeatherEvent newWeather = new WeatherEvent();

            //парсинг часов
            newWeather.setTime(Integer.parseInt(element.child(0).getElementsByTag("b").text()));

            //парсинг даты, пока установка даты на 2016 году
            GregorianCalendar date = new GregorianCalendar();
            String dateS = element.child(1).getElementsByTag("b").text().replaceAll("\\.","_");
            String[] dateStr = dateS.split("_");
            date.set(2016, (Integer.parseInt(dateStr[1])-1), (Integer.parseInt(dateStr[0])));
            newWeather.setDate(date.getTime());

            //парсинг направления ветра
            newWeather.setWindDirection(element.child(2).text());

            //парсинг силы ветра
            newWeather.setWindStrenght(Integer.parseInt(element.child(3).text()));



        }

        //System.out.println(body);

    }
}
