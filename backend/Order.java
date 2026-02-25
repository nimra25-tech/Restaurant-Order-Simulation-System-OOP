package backend;

public class Order {
    private MenuItem[] items; 
    private int[] quantities; 
    private int count; 
    private final int MAX_ITEMS = 10; 

    public Order() {
        items = new MenuItem[MAX_ITEMS];
        quantities = new int[MAX_ITEMS];
        count = 0;
    }

    
    public boolean addItem(MenuItem item, int quantity) {
        if(count < MAX_ITEMS) {
            items[count] = item;
            quantities[count] = quantity;
            count++;
            return true;
        } else {
            return false; 
        }
    }

    
    public double calculateTotal() {
        double total = 0;
        for(int i=0; i<count; i++) {
            total += items[i].getPrice() * quantities[i];
        }
        return total;
    }

    
    public String getOrderSummary() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<count; i++) {
            sb.append(items[i].getName())
              .append(" x")
              .append(quantities[i])
              .append(" = ")
              .append(items[i].getPrice() * quantities[i])
              .append("\n");
        }
        return sb.toString();
    }
}
