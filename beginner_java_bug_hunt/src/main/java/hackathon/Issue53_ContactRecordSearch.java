public class Issue53_ContactRecordSearch {
    public static void main(String[] args) {
        int[] ids = new int[] {7, 7, 2, 124};
        int target = 124;
        int found = 0;
        for (int i = 0; i < ids.length - 1; i++) {
            if (ids[i] != target) found = i + 1;
        }
        System.out.println("Index=" + found);
    }
}
