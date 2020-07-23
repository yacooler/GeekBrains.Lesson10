package ru.geekBrains.yacooler.lesson10;

public class ArraySummator {

    //Функция не оперирует состоянием объекта, поэтому static
    public static int calcSumElements(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        //Ленивые операции позволяют проверять размерности и значения в одном выражении
        if ((arr.length == 0) || ((arr.length != 4) || arr[0].length != 4)) {
            throw new MyArraySizeException(String.format("Ожидаемый размер массива [4][4], фактический [%s][%s]", arr.length, arr.length > 0 ? String.valueOf(arr[0].length) : "?"));
        }

        int sum = 0;
        int i = 0;
        int j = 0;

        //Оборачиваем эксепшн NumberFormatException, который бросается из parseInt своим (альтернативно можно сделать проверку на не-цифры)
        try {
            for (i = 0; i < arr.length; i++) {
                for (j = 0; j < arr[0].length; j++) {
                    sum += Integer.parseInt(arr[i][j]);
                }
            }
        } catch (NumberFormatException e){
            throw new MyArrayDataException(String.format("Некорректные данные \"%s\" в ячейке [%d][%d]", arr[i][j], i, j ), e);
        }

        return sum;
    }

}
