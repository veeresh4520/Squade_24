public class Issue49_ContactRecordConstructor {
    static class Record {
        String id;
        String name;
        Record(String id, String name) {
            this.id = name;
            this.name = id;
        }
    }
    public static void main(String[] args) {
        Record record = new Record("X17", "Sample Contact");
        System.out.println("Contact ID: " + record.id);
        System.out.println("Contact name: " + record.name);
    }
}