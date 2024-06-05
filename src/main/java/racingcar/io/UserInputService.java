package racingcar.io;

import java.util.List;
import racingcar.global.Message;

public class UserInputService {

    public UserInputService() {
    }

    public void validateInputCarName(String racingCarName) {
        List<String> carNames = List.of(racingCarName.split(","));

        if (!(carNames.toString()).isEmpty()) {
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

    public void validateInputAttemptNumber(String attemptNumber) {
        if (!attemptNumber.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException(Message.ERROR_MESSAGE.getMessage());
        }
    }
}