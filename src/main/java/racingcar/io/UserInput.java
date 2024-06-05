package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.entity.RacingCar;
import racingcar.service.UserInputService;

public class UserInput {

    private final UserInputService userInputService;

    public UserInput(UserInputService userInputService) {
        this.userInputService = userInputService;
    }

    public List<RacingCar> getInputCarName() {
        String racingCarName = getCarName();

        List<RacingCar> cars = new ArrayList<>();
        for (String name : racingCarName.split(",")) {
            cars.add(new RacingCar(name));
        }
        return cars;
    }

    public String getCarName() {
        String racingCarName = Console.readLine();
        userInputService.validateInputCarName(racingCarName);

        return racingCarName;
    }

    public String getAttemptNumber() {
        String attemptNumber = Console.readLine();
        userInputService.validateInputAttemptNumber(attemptNumber);

        return attemptNumber;
    }
}