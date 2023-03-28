package week4.day2;
@FunctionalInterface
interface qefs {
    <T> int calc(T t);

    default int calc2() {
        return 0;
    }
}
