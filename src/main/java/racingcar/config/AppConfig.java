package racingcar.config;

import racingcar.entity.Game;
import racingcar.entity.Winners;
import racingcar.io.Prompt;
import racingcar.io.UserInput;
import racingcar.service.GameService;
import racingcar.service.UserInputService;

public class AppConfig {

    public static Prompt prompt() {
        return new Prompt();
    }

    public static Winners winners() {
        return new Winners();
    }

    public static UserInput userInput() {
        return new UserInput(inputService());
    }

    public static UserInputService inputService() {
        return new UserInputService();
    }

    public static GameService service() {
        return new GameService(userInput(), prompt(), winners());
    }

    public static Game getGame() {
        return new Game(service());
    }
}