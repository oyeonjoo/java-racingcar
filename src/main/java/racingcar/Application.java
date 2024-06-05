package racingcar;

import racingcar.config.AppConfig;
import racingcar.entity.Game;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = AppConfig.getGame();
        game.start();
    }
}