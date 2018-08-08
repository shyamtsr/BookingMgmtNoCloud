package com.ssreddy.booking.common.enums;

/**
 * Author : Shyamsundar T <br>
 * Created on : 05th Aug, 2018 <br>
 * Version : 1.0. <br>
 * Description : Enum class to hold integers constants.
 * <br>
 * JIRA:  <br>
 */
public enum IntegerEnum {

	ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    INT_200(200),
    INT_204(204),
    INT_400(400),
    INT_412(412),
    INT_500(500),
    INT_999(999);

    private final int value;

    private IntegerEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

	
}
