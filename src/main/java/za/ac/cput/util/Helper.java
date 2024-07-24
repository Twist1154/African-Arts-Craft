package za.ac.cput.util;

import za.ac.cput.domain.Order;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Helper.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 24-Jul-24
 */

public class Helper {
    public static boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }

    public static boolean isDoubleNullorEmpty(Double s) {
        return s == null || Double.isNaN(s);
    }

    public static boolean isNullOrEmpty(List<Order> s) {
        return s == null || s.isEmpty();
    }

    public static boolean isEmailValid(String email, String regex) {
        return Pattern.compile(regex)
                .matcher(email)
                .matches();
    }

    public static boolean isNullOrEmpty(Long l) {
        return l == null || l.describeConstable().isEmpty();
    }
}
