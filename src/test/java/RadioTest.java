import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    // === Тесты для стандартного радио (10 станций) ===

    @Test
    void shouldStartAtStation0AndVolume0() {
        Radio radio = new Radio();
        assertEquals(0, radio.getCurrentStation());
        assertEquals(0, radio.getCurrentVolume());
        assertEquals(10, radio.getTotalStations());
    }

    @Test
    void shouldSetValidStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    void shouldNotSetInvalidStationAboveMax() {
        Radio radio = new Radio();
        radio.setCurrentStation(15);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldNotSetInvalidStationBelow0() {
        Radio radio = new Radio();
        radio.setCurrentStation(-1);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldNextFrom9To0() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldPrevFrom0To9() {
        Radio radio = new Radio();
        radio.prev();
        assertEquals(9, radio.getCurrentStation());
    }

    // === Тесты для радио с другим количеством станций ===

    @Test
    void shouldSupportCustomStationCount() {
        Radio radio = new Radio(5);
        assertEquals(5, radio.getTotalStations());
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldNextOnCustomRadio() {
        Radio radio = new Radio(3);
        radio.setCurrentStation(2);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldPrevOnCustomRadio() {
        Radio radio = new Radio(4);
        radio.prev();
        assertEquals(3, radio.getCurrentStation());
    }

    @Test
    void shouldSetValidStationOnCustomRadio() {
        Radio radio = new Radio(20);
        radio.setCurrentStation(15);
        assertEquals(15, radio.getCurrentStation());
    }

    @Test
    void shouldNotSetInvalidStationOnCustomRadio() {
        Radio radio = new Radio(6);
        radio.setCurrentStation(10);
        assertEquals(0, radio.getCurrentStation());
    }

    // === Тесты громкости (без изменений) ===

    @Test
    void shouldIncreaseVolume() {
        Radio radio = new Radio();
        radio.increaseVolume();
        assertEquals(1, radio.getCurrentVolume());
    }

    @Test
    void shouldNotExceedMaxVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(100);
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    void shouldDecreaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50);
        radio.decreaseVolume();
        assertEquals(49, radio.getCurrentVolume());
    }

    @Test
    void shouldNotGoBelowMinVolume() {
        Radio radio = new Radio();
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    // === Тест на недопустимое количество станций ===

    @Test
    void shouldThrowExceptionOnZeroStations() {
        assertThrows(IllegalArgumentException.class, () -> new Radio(0));
    }

    @Test
    void shouldThrowExceptionOnNegativeStations() {
        assertThrows(IllegalArgumentException.class, () -> new Radio(-5));
    }
}