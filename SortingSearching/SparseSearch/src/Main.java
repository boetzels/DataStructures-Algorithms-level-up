import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String[] s = {"ai","","","bat","","","car","cat","","","dog","","hoh"};


        System.out.println(SparseSearch(s, "ai", 0, s.length - 1));
    }

    private static int SparseSearch(String[] string, String search, int startIndex, int pivotIndex) {
        int checkIndex = (pivotIndex - startIndex) / 2 + startIndex;

        if (string[checkIndex].equals("")){
            int i = checkIndex;
            int j = checkIndex;
            boolean foundNext = false;

            while (!foundNext && i >= startIndex && j <= pivotIndex) {
                if (i > startIndex && !string[--i].equals("")) {
                    checkIndex = i;
                    foundNext = true;
                }
                else if (j < pivotIndex && !string[++j].equals("")) {
                    checkIndex = j;
                    foundNext = true;
                }
            }

            if (!foundNext) {
                return -1;
            }
        }

        if (string[checkIndex].equals(search)) {
            return checkIndex;
        }
        else if (startIndex == pivotIndex) {
            return -1;
        }
        else if (string[checkIndex].compareTo(search) < 0) {
            return SparseSearch(string, search, checkIndex + 1, pivotIndex);
        }
        else {
            return SparseSearch(string, search, startIndex, checkIndex - 1);
        }
    }
}
