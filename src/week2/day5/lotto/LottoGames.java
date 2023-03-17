package week2.day5.lotto;

import week1.day5.MethodTest9;

public class LottoGames {
    public static void main(String[] args) throws DuplicateException {
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.createLottoNums();
        lottoMachine.checkLottoNums();
        MethodTest9.printArray(lottoMachine.getNums());
    }
}
