package Diary;

import java.util.Date;

public class WeatherEvent {
    private int time; //время измерения (часы)
    private Date date; //дата измерения
    private String windDirection; //направление ветра
    private int windStrenght; //сила ветра
    private String visibility;  //Видимость - горизонтальная дальность видимости в метрах или километрах.
                                // При видимости от 1 до 10 км при отсутствии осадков обычно наблюдается дымка,
                                // при ухудшении видимости до 1 км и менее - туман. В сухую погоду видимость
                                // может ухудшаться дымом, пылью или мглою.
    private String rain; //Явления - указаны атмосферные явления, наблюдавшиеся в срок или в последний час
                         //перед сроком; фигурными скобками обозначены явления, наблюдавшиеся между сроками
                         //(за 1-3 часа до срока); квадратными скобками обозначены град или гололедные
                         //отложения с указанием их диаметра в мм.
    private String clouds; //Облачность - указаны через наклонную черту общая и нижняя облачность в баллах
                           // и высота нижней границы облаков в метрах; квадратными скобками обозначены формы облаков:
                           // Ci - перистые, Cs - перисто-слоистые, Cc - перисто-кучевые, Ac - высококучевые,
                           // As - высокослоистые, Sc - слоисто-кучевые, Ns - слоисто-дождевые, Cu - кучевые,
                           // Cb - кучево-дождевые. Подробнее классификацию облаков см. в Атласе облаков (PDF).
                           // http://www.pogodaiklimat.ru/doc/atlas_oblakov.pdf
    private float temperature; //Температура воздуха - температура, измеренная на высоте 2 м над землей.
    private float tempD; //Температура точки росы - температура, при понижении до которой содержащийся
                         //в воздухе водяной пар достигнет насыщения.
    private int humidity; //относительная влажность в % измеренная в 2 метрах над землёй
    private int tempEffective;  //Температура, которую ощущает одетый по сезону человек в тени.
                                // Характеристика душности погоды. При расчете учитывается
                                // влияние влажности воздуха и скорости ветра на теплоощущения человека.
    private int tempOnSun;  //Эффективная температура на солнце - температура, которую ощущает человек,
                            // с поправкой на солнечный нагрев. Характеристика знойности погоды. Зависит
                            // от высоты солнца над горизонтом, облачности и скорости ветра. Ночью, в пасмурную
                            // погоду, а также при ветре 12 м/с и более поправка равна нулю.
    private String comfortLevel; //Уровень комфортности для человека
    private float pAtmSeaLevel; //приведенное к уровню моря атмосферное давление, мм рт. ст.
    private float pAtmReal; //измеренное на уровне метеостанции атмосферное давление
    private float tMin; //Минимальная температура - минимум температуры воздуха на высоте 2 м над землей
    private float tMax; //Максимальная температура - максимум температуры воздуха на высоте 2 м над землей.
    private float osadki; //Количество осадков - Количество выпавших осадков, мм.
    private float snow; //Снежный покров - Высота снежного покрова, см.
                        // При наведении курсора мыши на число - состояние снежного покрова и степень покрытия местности в баллах.


    public void setTime(int time) {
        this.time = time;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public void setWindStrenght(int windStrenght) {
        this.windStrenght = windStrenght;
    }
}
