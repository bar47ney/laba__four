/**
 * Created by Сергей on 24.04.2019.
 */
public class Matrix
{
    int[][] array = new int[3][3];
    int determinant_one;
    int determinant_two;
    int determinant_three;

    public int calculate()
    {
        return array[0][0] * determinant_one - array[0][1] * determinant_two + array[0][2] * determinant_three;
    }
}
