import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        /*Реализовать методы поиска в соответствии с заданием. Организовать генерацию начального набора случайных данных.
        Для всех вариантов добавить реализацию добавления, поиска и удаления элементов.
            Оценить время работы каждого алгоритма поиска и сравнить его со временем работы стандартной функции поиска,
        используемой в выбранном языке программирования.
        Задание №1:
        Бинарный поиск
        Бинарное дерево
        Фибоначчиев
                Интерполяционный*/
        ArrayList<Integer> arr = new ArrayList<>();
        arr.addAll(gen());
        System.out.println(fibMonaccianSearch((arr),5,100));
        System.out.println(binariSearch(arr,1));
        System.out.println(interpolationSearch(arr,8));
        //System.out.println(arr);
    }
    public static ArrayList<Integer> gen(){
        Random random = new Random();
        ArrayList<Integer> arrayList = new ArrayList();
        for(int i=0; i<100; i++){
            arrayList.add(random.nextInt(0,100));
        }
        Collections.sort(arrayList);
        return arrayList;
    }
    public static int interpolationSearch(ArrayList<Integer> sortedArray, int toFind) {
        int low = 0;
        int high = (sortedArray.size() - 1);

        while (low <= high && toFind >= sortedArray.get(low) && toFind <= sortedArray.get(high)) {
            int pos = low + (((high - low) / (sortedArray.get(high) - sortedArray.get(low)) * (toFind - sortedArray.get(low))));

            if (sortedArray.get(pos) == toFind)
                return pos;

            if (sortedArray.get(pos) < toFind)
                low = pos + 1;
            else
                high = pos - 1;
        }
        return -1;
    }
    public static int binariSearch(ArrayList<Integer>  arr, int x) {
        int left = 0, right = arr.size()-1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr.get(mid) == x) {
                return mid;
            }
            if (arr.get(mid) < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    public static int fibMonaccianSearch(ArrayList<Integer> arr, int x, int n) {
        int fibMMm2 = 0;
        int fibMMm1 = 1;
        int fibM = fibMMm2 + fibMMm1;

        while (fibM < n) {
            fibMMm2 = fibMMm1;
            fibMMm1 = fibM;
            fibM  = fibMMm2 + fibMMm1;
        }

        int offset = -1;

        while (fibM > 1) {
            int i = Math.min(offset+fibMMm2, n-1);

            if (arr.get(i) < x) {
                fibM  = fibMMm1;
                fibMMm1 = fibMMm2;
                fibMMm2 = fibM - fibMMm1;
                offset = i;
            }

            else if (arr.get(i) > x) {
                fibM  = fibMMm2;
                fibMMm1 = fibMMm1 - fibMMm2;
                fibMMm2 = fibM - fibMMm1;
            }

            else return i;
        }

        if(fibMMm1 == 1 && arr.get(offset+1) == x)
            return offset+1;

        return -1;
    }
}