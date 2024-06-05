package racingcar.entity;

import racingcar.service.GameService;

public class Game {

    private final GameService gameService;

    public Game(GameService gameService) {
        this.gameService = gameService;
    }

    public void start() {
        gameService.startGame();
    }
}