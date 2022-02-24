import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here
        // String[] text = {"aa", "a", "b", "bcd", "sd", "adsf", "erw"};
        String[] text = {"a", "ab", "aba"};

        String[] resultArray = MergeSort(text);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < resultArray.length; i++) {
            result.ensureCapacity(result.length() + resultArray[i].length());
            result.append(resultArray[i]);
        }

        System.out.println(result);
    }

    private static String[] MergeSort(String[] strings) {
        if (strings.length <= 1) {
            return strings;
        }

        int divider = strings.length / 2;

        String[] leftPart = MergeSort(Arrays.copyOfRange(strings, 0, divider));
        String[] rightPart = MergeSort(Arrays.copyOfRange(strings, divider, strings.length));

        return Merge(leftPart, rightPart);
    }

    private static  String[] Merge(String[] leftPart, String[] rightPart) {
        int i = 0;
        int j = 0;
        int k = 0;
        String[] result = new String[leftPart.length + rightPart.length];

        while (i + j < leftPart.length + rightPart.length) {
            if (j == rightPart.length || i < leftPart.length && leftPart[i].concat(rightPart[j]).compareTo(rightPart[j].concat(leftPart[i])) < 0) {
                result[k++] = leftPart[i++];
            }
            else {
                result[k++] = rightPart[j++];
            }
        }

        return result;
    }
}
