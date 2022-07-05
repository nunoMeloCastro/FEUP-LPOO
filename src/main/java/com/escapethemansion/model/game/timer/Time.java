package com.escapethemansion.model.game.timer;

import java.text.SimpleDateFormat;
import java.util.Objects;

public class Time {
    private int second;
    private int minute;

    public Time(int second, int minute) {
        this.second = second;
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public int getMinute() {
        return minute;
    }

    public boolean reduceTime(boolean timerIsPaused) {
        if(timerIsPaused) return true;
        if (minute == 0 && second == 0) return false;

        if (minute > 0 && second == 0) {
            minute--;
            second = 59;
            return true;
        }

        second--;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return second == time.second && minute == time.minute;
    }

    @Override
    public int hashCode() {
        return Objects.hash(second, minute);
    }
}
