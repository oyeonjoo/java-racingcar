package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.entity.RacingCar;
import racingcar.entity.Winners;
import racingcar.io.Prompt;
import racingcar.io.UserInput;

public class GameService {

    private final UserInput userInput;
    private final Prompt prompt;
    private final Winners winners;
    private List<RacingCar> cars;

    public GameService(UserInput userInput, Prompt prompt, Winners winners) {
        this.userInput = userInput;
        this.prompt = prompt;
        this.winners = winners;
    }

    public void startGame() {
        prompt.startMessage();
        cars = userInput.getInputCarName();

        prompt.attemptMessage();

        race();

        prompt.printFinalWinnerName(getWinners());
    }

    public List<String> getWinners() {

        for (RacingCar car : cars) {
            winners.updateWinners(car);
        }
        return winners.getWinnersNames();
    }


    public void race() {
        int attempts = Integer.parseInt(userInput.getAttemptNumber());

        prompt.printResult();

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