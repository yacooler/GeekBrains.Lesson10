import ru.geekBrains.yacooler.lesson10.ArraySummator;
import ru.geekBrains.yacooler.lesson10.MyArrayDataException;
import ru.geekBrains.yacooler.lesson10.MyArraySizeException;

import java.util.Random;

public class MainApp {

    public static void main(String[] args) {

        try {
            //Первая размерность массива с числами - 0
            System.out.printf("Сумма элементов массива: %d\n", ArraySummator.calcSumElements(newFilledArray(0, 5)));

            //Размерность массива с числами не 4*4
            System.out.printf("Сумма элементов массива: %d\n", ArraySummator.calcSumElements(newFilledArray(6,2)));

            //Символ "X" в случайном месте массива с числами
            System.out.printf("Сумма элементов массива: %d\n", ArraySummator.calcSumElements(newBrokenArray(4,4)));

            //Массив с числами без ошибок
            System.out.printf("Сумма элементов массива: %d\n", ArraySummator.calcSumElements(newFilledArray(4,4)));

        } catch (MyArrayDataException | MyArraySizeException exception) {
            //MyArraySizeException ловить не обязательно, т.к. оно наследуется от RuntimeException но требуется по условиям ДЗ
            exception.printStackTrace();
        }

    }

    private static String[][] newBrokenArray(int yDimension, int xDimension){
        Random random = new Random();
        String[][] arr = newFilledArray(yDimension, xDimension);
        arr[random.nextInt(yDimension)][random.nextInt(xDimension)] = "X";

        return arr;
    }

    private static String[][] newFilledArray(int yDimension, int xDimension){
        Random random = new Random();
        String[][] arr = new String[yDimension][xDimension];
        for (int i = 0; i < yDimension; i++) {
            for (int j = 0; j < xDimension; j++) {
                arr[i][j] = String.valueOf(random.nextInt(10));
            }
        }

        return arr;
    }
}
