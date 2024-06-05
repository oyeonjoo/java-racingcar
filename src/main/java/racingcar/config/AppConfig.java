package racingcar.config;

import racingcar.io.Prompt;
import racingcar.io.UserInputService;
import racingcar.service.Game;
import racingcar.service.GameService;
import racingcar.service.UserInput;

public class AppConfig {

    public static Prompt prompt() {
        return new Prompt();
    }

    public static UserInputService inputService() {
        return new UserInputService();
    }

    public static UserInput userInput() {
        return new UserInput(inputService());
    }

    public static GameService service() {
        return new GameService(userInput(), prompt());
    }

    public static Game getGame() {
        return new Game(service());
    }
}