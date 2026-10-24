public class Issue55_ContactRecordStringSearch {
    public static void main(String[] args) {
        String storedId = new String("ID-7");
        String requestedId = new String("ID-7");
        if (storedId == requestedId) System.out.println("Contact ID found");
        else System.out.println("Contact ID not found");
    }
}