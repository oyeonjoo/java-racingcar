package racingcar.entity;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    private final List<RacingCar> winners;
    private final List<String> winnerNames;
    private int maxPosition;

    public Winners() {
        this.winners = new ArrayList<>();
        this.winnerNames = new ArrayList<>();
    }

    public void updateWinners(RacingCar car) {
        int currentPosition = car.getPosition();

        if (currentPosition >= maxPosition) {
            if (currentPosition > maxPosition) {
                winners.clear();
                maxPosition = currentPosition;
            }
            winners.add(car);
        }
    }

    public List<String> getWinnersNames() {
        for (RacingCar car : winners) {
            winnerNames.add(car.getName());
        }
        return winnerNames;
    }
}