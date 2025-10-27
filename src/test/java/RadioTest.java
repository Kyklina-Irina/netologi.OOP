import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @Test
    void shouldSetValidStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    void shouldNotSetInvalidStationAbove9() {
        Radio radio = new Radio();
        radio.setCurrentStation(15);
        assertEquals(0, radio.getCurrentStation()); // осталось 0
    }

    @Test
    void shouldNotSetInvalidStationBelow0() {
        Radio radio = new Radio();
        radio.setCurrentStation(-3);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldSwitchToNextStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(3);
        radio.next();
        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    void shouldWrapFrom9To0OnNext() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldSwitchToPrevStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(7);
        radio.prev();
        assertEquals(6, radio.getCurrentStation());
    }

    @Test
    void shouldWrapFrom0To9OnPrev() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);
        radio.prev();
        assertEquals(9, radio.getCurrentStation());
    }

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
        radio.decreaseVolume(); // текущий 0
        assertEquals(0, radio.getCurrentVolume());
    }
    @Test
    void shouldNotSetStationBelow0() {
        Radio radio = new Radio();
        radio.setCurrentStation(-1);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldNotSetStationAbove9() {
        Radio radio = new Radio();
        radio.setCurrentStation(10);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldNotSetVolumeBelow0() {
        Radio radio = new Radio();
        radio.setCurrentVolume(-10);
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void shouldNotSetVolumeAbove100() {
        Radio radio = new Radio();
        radio.setCurrentVolume(150);
        assertEquals(0, radio.getCurrentVolume());
    }

    // Доп.: проверка начального состояния
    @Test
    void shouldStartAtStation0AndVolume0() {
        Radio radio = new Radio();
        assertEquals(0, radio.getCurrentStation());
        assertEquals(0, radio.getCurrentVolume());
    }
}