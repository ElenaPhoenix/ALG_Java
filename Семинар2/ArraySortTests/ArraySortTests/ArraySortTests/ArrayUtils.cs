using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ArraySortTests
{
    /**
     * Утилиты для работы с массивом
     */
    public class ArrayUtils
    {

        private static Random random = new Random();

        public static int[] prepareArray()
        {
            return prepareArray(random.Next(15, 20));
        }

        public static int[] prepareArray(int length)
        {
            int[] array = new int[length];
            for (int i = 0; i < array.Length; i++)
            {
                array[i] = random.Next(-99, 100);
            }
            return array;
        }

    }
}
