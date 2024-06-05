package racingcar.entity;

public class RacingCar {

    private int position;
    private final CarInfo carInfo;

    public RacingCar(String name) {
        this.carInfo = new CarInfo(name);
        this.position = 0;
    }

    public void move(boolean forward) {
        if (forward) {
            position++;
        }
    }

    public String getName() {
        return carInfo.name();
    }

    public int getPosition() {
        return position;
    }

    public String display() {
        return carInfo.name() + " : " + "-".repeat(position);
    }
}
