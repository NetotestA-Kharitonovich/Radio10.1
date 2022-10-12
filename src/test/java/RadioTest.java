import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import ru.netology.Radio;

public class RadioTest {

    @ParameterizedTest
    @CsvSource(value = {
            "Проверка выбранной станции, 5, 5",
            "Проверка выбора станции до нижней границы(-25), -25, 0",
            "Проверка выбора станции до нижней границы(-1), -1, 0",
            "Проверка выбора станции/нижняя грацица(0), 0, 0",
            "Проверка выбора станции/нижняя грацица(1), 1, 1",
            "Проверка выбора станции/верхняя грацица(8), 8, 8",
            "Проверка выбора станции/верхняя грацица(9), 9, 9",
            "Проверка выбора станции/выше верхней грацицы(10), 10, 0",
            "Проверка выбора станции/выше верхней грацицы(25), 25, 0",
    }, delimiter = ',')
    void setSelectStation(String nameTest, int inputSelectStation, int expectedStation) {
        Radio radio = new Radio();
        radio.setSelectStation(inputSelectStation);
        assertEquals(radio.getCurrentStation(), expectedStation);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Проверка переключения станций вперёд, 5, 6",
            "Проверка нижней границы(0), 0, 1",
            "Проверка нижней границы(1), 1, 2",
            "Проверка верхней границы(8), 8, 9",
            "Проверка верхней границы(9), 9, 0",
    }, delimiter = ',')
    void setNextStation(String nameTest, int oldCurrentStation, int expectedStation) {
        Radio radio = new Radio();
        radio.setCurrentStation(oldCurrentStation);
        radio.setNextStation();
        assertEquals(radio.getCurrentStation(), expectedStation);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Проверка переключения станций назад, 5, 4",
            "Проверка нижней границы(0), 0, 9",
            "Проверка нижней границы(1), 1, 0",
            "Проверка верхней границы(8), 8, 7",
            "Проверка верхней границы(9), 9, 8",
    }, delimiter = ',')
    void setPrevCurrentStation(String nameTest, int oldCurrentStation, int expectedStation) {
        Radio radio = new Radio();
        radio.setCurrentStation(oldCurrentStation);
        radio.setPrevStation();
        assertEquals(radio.getCurrentStation(), expectedStation);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Проверка средних значений повышения громкости, 5, 6",
            "Проверка нижней границы(0), 0, 1",
            "Проверка нижней границы(1), 1, 2",
            "Проверка верхней границы(9), 9, 10",
            "Проверка верхней границы(10), 10, 10",
    }, delimiter = ',')
    void setVolumeUp(String nameTest, int oldCurrentVolume, int expectedVolume) {
        Radio radio = new Radio();
        radio.setCurrentVolume(oldCurrentVolume);
        radio.setVolumeUp();
        assertEquals(radio.getCurrentVolume(), expectedVolume);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Проверка средних значений понижения громкости, 5, 4",
            "Проверка нижней границы(0), 0, 0",
            "Проверка нижней границы(1), 1, 0",
            "Проверка верхней границы(9), 9, 8",
            "Проверка верхней границы(10), 10, 9",
    }, delimiter = ',')
    void setVolumeDown(String nameTest, int oldCurrentVolume, int expectedVolume) {
        Radio radio = new Radio();
        radio.setCurrentVolume(oldCurrentVolume);
        radio.setVolumeDown();
        assertEquals(radio.getCurrentVolume(), expectedVolume);
    }
}