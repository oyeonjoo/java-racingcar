package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {

    public UserInput() {
    }

    public String getCarName() {
        return Console.readLine();
    }

    public String getAttemptNumber() {
        return Console.readLine();
    }
}