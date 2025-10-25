public class Radio {
    private int currentStation; // 0–9
    private int currentVolume;  // 0–100

    public int getCurrentStation() {
        return currentStation;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentStation(int station) {
        if (station >= 0 && station <= 9) {
            this.currentStation = station;
        }
    }

    public void setCurrentVolume(int volume) {
        if (volume >= 0 && volume <= 100) {
            this.currentVolume = volume;
        }
    }

    public void next() {
        currentStation = (currentStation == 9) ? 0 : currentStation + 1;
    }

    public void prev() {
        currentStation = (currentStation == 0) ? 9 : currentStation - 1;
    }

    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume--;
        }
    }
}