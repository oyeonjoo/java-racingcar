package racingcar.config;

import racingcar.io.Prompt;
import racingcar.io.UserInput;
import racingcar.service.Game;

public class AppConfig {

    public static Prompt prompt() {
        return new Prompt();
    }

    public static UserInput userInput() {
        return new UserInput();
    }

    public static Game getGame() {
        return new Game(prompt(), userInput());
    }
}
