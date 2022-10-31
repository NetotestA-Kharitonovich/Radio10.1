package ru.netology;

public class Radio {
    private int currentStation;
    private int minStation = 0;
    private int maxStation = 9;
    private int currentVolume;
    private int minVolume = 0;
    private int maxVolume = 100;

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int currentStation) {
        if (currentStation < getMinStation()) {
            return;
        }
        if (currentStation > getMaxStation()) {
            return;
        }
        this.currentStation = currentStation;
    }

    public int getMinStation() {
        return minStation;
    }

    public int getMaxStation() {
        return maxStation;
    }

    public void nextStation() {
        if (currentStation == maxStation) {
            setCurrentStation(0);
        } else {
            setCurrentStation(currentStation + 1);
        }
    }

    public void previousStation() {
        if (currentStation == 0) {
            setCurrentStation(maxStation);
        } else {
            setCurrentStation(currentStation - 1);
        }
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int currentVolume) {
        if (currentVolume < getMinVolume()) {
            return;
        }
        if (currentVolume > getMaxVolume()) {
            return;
        }
        this.currentVolume = currentVolume;
    }

    public int getMinVolume() {
        return minVolume;
    }

    public int getMaxVolume() {
        return maxVolume;
    }

    public void increaseVolume() {
        if (getCurrentVolume() == maxVolume) {
            return;
        }
        setCurrentVolume(currentVolume + 1);
    }

    public void decreaseVolume() {
        if (getCurrentVolume() == minVolume) {
            return;
        }
        setCurrentVolume(currentVolume - 1);
    }

    public Radio(int maxStation) {
        this.maxStation = maxStation;
    }
}