package week2.day5.lotto;

import java.util.Random;

public class LottoMachine {
    private int[] nums = new int[6];

    public LottoMachine() {
    }
    public void createLottoNums(){
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(20) + 1;
        }
    }

    public void checkLottoNums() throws DuplicateException {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]){
                    throw new DuplicateException();
                }
            }
        }
    }

    public int[] getNums() {
        return nums;
    }
}
