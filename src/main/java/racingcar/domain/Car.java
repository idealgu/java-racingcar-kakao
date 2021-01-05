package racingcar.domain;

import racingcar.CarNameInvalidException;

public class Car {
    private static final int MOVEMENT = 1;
    private static final int NAME_MAX_LENGTH = 5;
    private static final int SPEED = 4;

    private int position;
    private final String name;

    public Car(String name){
        if(!isValidName(name)) {
            throw new CarNameInvalidException("잘못된 이름입니다.");
        }
        this.name = name;
    }

    public CarInfo getCarInfo() {
        return new CarInfo(this.name, this.position);
    }

    public void nextStep(int currentSpeed) {
        if(isCarGo(currentSpeed)) {
            position += MOVEMENT;
        }
    }

    public boolean isCarGo(int currentSpeed) {
        return currentSpeed >= SPEED;
    }

    private boolean isValidName(String name) {
        return name.length() <= NAME_MAX_LENGTH;
    }

}