/**
 * Created by Сергей on 12.04.2019.
 */
public class Determinant {
    int[][] array = new int[2][2];

    public int calculate()
    {
        return array[0][0] * array[1][1] - array[0][1]*array[1][0];
    }
    public void setArray(int a, int b, int c, int d)
    {
        array[0][0] = a;
        array[0][1] = b;
        array[1][0] = c;
        array[1][1] = d;
    }
}
