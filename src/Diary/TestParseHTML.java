package Diary;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


public class TestParseHTML {
    public static void main(String[] args) {

        Document html = null;
        try {
            html = Jsoup.connect("http://www.pogodaiklimat.ru/weather.php?id=28440&bday=1&fday=31&amonth=8&ayear=2016").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements body = html.getElementsByAttributeValueContaining("height", "30");
        System.out.println(body);

    }
}
