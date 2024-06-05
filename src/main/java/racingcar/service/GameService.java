package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.entity.RacingCar;
import racingcar.io.Prompt;
import racingcar.io.UserInput;

public class GameService {

    private final UserInput userInput;
    private final Prompt prompt;
    private List<RacingCar> cars;

    public GameService(UserInput userInput, Prompt prompt) {
        this.userInput = userInput;
        this.prompt = prompt;
    }

    public void startGame() {
        prompt.startMessage();
        cars = userInput.getInputCarName();

        prompt.attemptMessage();
        prompt.printResult();

        race();
        prompt.printFinalWinnerName(getWinners());
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        int maxPosition = 0;

        for (RacingCar car : cars) {
            int currentPosition = car.getPosition();

            if (currentPosition > maxPosition) {
                maxPosition = currentPosition;
                winners.clear();
                winners.add(car.getName());
                continue;
            }
            validateWinners(car, currentPosition, maxPosition, winners);
        }
        return winners;
    }

    public void validateWinners(RacingCar car, int currentPosition, int maxPosition,
        List<String> winners) {

        if (currentPosition == maxPosition) {
            winners.add(car.getName());
        }
    }

    public void race() {
        int attempts = Integer.parseInt(userInput.getAttemptNumber());

        for (int i = 0; i < attempts; i++) {
            moveForward();
            prompt.printRoundResult(cars);
        }
    }

    public void moveForward() {
        for (RacingCar car : cars) {
            int pickedNumber = Randoms.pickNumberInRange(0, 9);
            if (pickedNumber >= 4) {
                car.move(true);
            }
        }
    }
}