public class Issue55_ContactRecordStringSearch {
    public static void main(String[] args) {
        String[] ids = new String[] {"A24", "B24", "C24"};
        String target = new String("B24");
        int found = 0;
        for (int i = 1; i < ids.length - 1; i++) { if (ids[i] == target) found = i; else found = i - 1; }
        System.out.println("Index=" + found);
    }
}
