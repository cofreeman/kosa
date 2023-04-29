package week8.day4;

import java.util.Objects;

public class BookUtils {
    public static String convertKind(String kind) {
        if (Objects.equals(kind, "b01")) {
            return "프로그래밍 언어";
        } else if (Objects.equals(kind, "b02")) {
            return "웹프로그래밍";
        } else if (Objects.equals(kind, "b03")) {
            return "빅데이터";
        } else if (Objects.equals(kind, "b04")) {
            return "데이터베이스";
        } else if (Objects.equals(kind, "b05")) {
            return "인프라";
        } else {
            return "책종류가 없음";
        }
    }
}
