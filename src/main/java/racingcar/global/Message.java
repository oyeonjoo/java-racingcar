package racingcar.global;

public enum Message {

    ENTER_RACING_CAR_NAME_MESSAGE("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)"),
    NUMBER_OF_ATTEMPT_MESSAGE("시도할 회수는 몇회인가요?"),
    RESULT_MESSAGE("실행 결과"),
    FINAL_WINNER_MESSAGE("최종 우승자 : "),
    ERROR_MESSAGE("잘못 입력했습니다. 게임을 종료합니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}