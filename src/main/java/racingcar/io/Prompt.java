package racingcar.io;

import java.util.List;
import racingcar.global.Message;
import racingcar.entity.RacingCar;

public class Prompt {

    public Prompt() {
    }

    public void startMessage() {
        System.out.println(Message.ENTER_RACING_CAR_NAME_MESSAGE.getMessage());
    }

    public void attemptMessage() {
        System.out.println(Message.NUMBER_OF_ATTEMPT_MESSAGE.getMessage());
    }

    public void printResult() {
        System.out.println(Message.RESULT_MESSAGE.getMessage());
    }

    public void printFinalWinnerName(List<String> winners) {
        System.out.println(Message.FINAL_WINNER_MESSAGE.getMessage() + String.join(", ", winners));
    }

    public void printRoundResult(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            System.out.println(car.display());
        }
        System.out.println();
    }
}
