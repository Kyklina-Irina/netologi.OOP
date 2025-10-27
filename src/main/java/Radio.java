public class Radio {
    private int currentStation;
    private int currentVolume;
    private final int totalStations;

    // Конструктор по умолчанию — 10 станций
    public Radio() {
        this(10);
    }

    // Конструктор с заданием количества станций
    public Radio(int totalStations) {
        if (totalStations <= 0) {
            throw new IllegalArgumentException("Количество станций должно быть больше 0");
        }
        this.totalStations = totalStations;
        this.currentStation = 0; // начальная станция — всегда 0
        this.currentVolume = 0;  // начальная громкость — 0
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public int getTotalStations() {
        return totalStations;
    }

    // Сеттер станции с валидацией
    public void setCurrentStation(int station) {
        if (station >= 0 && station < totalStations) {
            this.currentStation = station;
        }
    }

    // Переключение на следующую станцию
    public void next() {
        if (currentStation == totalStations - 1) {
            currentStation = 0;
        } else {
            currentStation++;
        }
    }

    // Переключение на предыдущую станцию
    public void prev() {
        if (currentStation == 0) {
            currentStation = totalStations - 1;
        } else {
            currentStation--;
        }
    }

    // Увеличение громкости
    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume++;
        }
    }

    // Уменьшение громкости
    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume--;
        }
    }
    public void setCurrentVolume(int volume) {
        if (volume >= 0 && volume <= 100) {
            this.currentVolume = volume;
        }
    }
}