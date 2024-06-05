package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.entity.RacingCar;
import racingcar.global.Message;
import racingcar.io.Prompt;
import racingcar.io.UserInput;

public class Game {

    private final Prompt prompt;
    private final UserInput userInput;
    private List<RacingCar> cars;

    public Game(Prompt prompt, UserInput userInput) {
        this.prompt = prompt;
        this.userInput = userInput;
    }

    public void start() {
        prompt.startMessage();
        getInputCarName();

        prompt.attemptMessage();
        String attemptNumber = userInput.getAttemptNumber();
        validateInputAttemptNumber(attemptNumber);

        int attempts = Integer.parseInt(attemptNumber);

        prompt.printResult();
        race(attempts);

        prompt.printFinalWinnerName(getWinners());
    }

    public void getInputCarName() {
        String racingCarName = userInput.getCarName();
        validateInputCarName(racingCarName);

        cars = new ArrayList<>();
        for (String name : racingCarName.split(",")) {
            cars.add(new RacingCar(name.trim()));
        }
    }

    public void validateInputAttemptNumber(String attemptNumber) {
        if (!attemptNumber.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException(Message.ERROR_MESSAGE.getMessage());
        }
    }

    public void validateInputCarName(String racingCarName) {
        String[] carNames = racingCarName.split(",");

        if (!Arrays.toString(carNames).isEmpty()) {
            for (String carName : carNames) {
                validateCarNameLettersLength(carName.trim());
                validateCarNameContainsOnlyLetters(carName.trim());
            }
        }
    }

    public void validateCarNameLettersLength(String racingCarName) {
        if ((racingCarName.length() > 5)) {
            throw new IllegalArgumentException(Message.ERROR_MESSAGE.getMessage());
        }
    }

    public void validateCarNameContainsOnlyLetters(String racingCarName) {
        if (!racingCarName.matches("^[a-zA-Z]+$")) {
            throw new IllegalArgumentException(Message.ERROR_MESSAGE.getMessage());
        }
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

    public void race(int attempts) {
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