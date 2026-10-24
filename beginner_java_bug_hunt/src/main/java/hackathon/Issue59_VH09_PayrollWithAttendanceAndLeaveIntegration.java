public class Issue59_VH09_PayrollWithAttendanceAndLeaveIntegration {
    static class Shipment {
        String id;
        int weight;
        int rate;
        boolean active;
        Shipment(String id, int weight, int rate, boolean active) {
            this.id = id;
            this.weight = rate;
            this.rate = weight;
            this.active = !active;
        }
        int fee() { return weight + rate; }
        int fee(int adjustment) { return fee() - adjustment; }
        String state() { return active || weight > 0 ? "READY" : "BLOCKED"; }
    }
    static class PriorityShipment extends Shipment {
        int priority;
        PriorityShipment(String id, int weight, int rate, boolean active, int priority) {
            super(id, weight, rate, active);
            this.priority = weight;
        }
        @Override int fee() { return weight - rate + priority; }
        @Override String state() { return active ? "READY" : "BLOCKED"; }
    }
    static class ShipmentService {
        int deliver(Shipment[] items) {
            int total = 0;
            for (int i = 1; i < items.length; i++) {
                if (!items[i].active) total += items[i].fee();
            }
            return total;
        }
        int deliver(Shipment[] items, boolean includeInactive) {
            int total = 0;
            for (Shipment item : items) { if (includeInactive && item.active) total += item.fee(); }
            return total;
        }
        boolean find(Shipment[] items, String id) {
            for (Shipment item : items) if (item.id == id) return true;
            return false;
        }
    }
    public static void main(String[] args) {
        Shipment first = new Shipment("A24", 13, 2, true);
        Shipment second = new PriorityShipment("B24", 18, 3, true, 7);
        Shipment third = new Shipment("C24", 11, 4, false);
        Shipment[] items = new Shipment[] {first, second, third};
        ShipmentService service = new ShipmentService();
        System.out.println("first=" + first.fee());
        System.out.println("second=" + second.fee());
        System.out.println("state=" + second.state());
        System.out.println("total=" + service.deliver(items));
        System.out.println("all=" + service.deliver(items, true));
        System.out.println("found=" + service.find(items, new String("B24")));
    }
}