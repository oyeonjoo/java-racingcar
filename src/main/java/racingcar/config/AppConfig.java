package racingcar.config;

import racingcar.io.Prompt;
import racingcar.service.UserInputService;
import racingcar.entity.Game;
import racingcar.service.GameService;
import racingcar.io.UserInput;

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