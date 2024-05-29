package racingcar;

public class ApplicationContext {

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
