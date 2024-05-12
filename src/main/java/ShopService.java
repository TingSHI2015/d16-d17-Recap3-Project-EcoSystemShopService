import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShopService {
    private ProductRepo productRepo = new ProductRepo();
    private OrderRepo orderRepo = new OrderMapRepo();

    public Order addOrder(List<String> productIds) {
        List<Product> products = new ArrayList<>();
        for (String productId : productIds) {
            Product productToOrder = productRepo.getProductById(productId);
            if (productToOrder == null) {
                System.out.println("Product mit der Id: " + productId + " konnte nicht bestellt werden!");
                return null;
            }
            products.add(productToOrder);
        }

        Order newOrder = new Order(UUID.randomUUID().toString(), products, OrderStatus.PROCESSING);

        return orderRepo.addOrder(newOrder);
    }


    //Ting's code! But teacherDaniel put this method-name in Interface & than in OrderListRepo the method override!
/*    public List<Order> getAllOrdersByOrderStatus(OrderStatus status){
        return orderRepo.getOrders().stream()
                .filter(order -> order.status()==status)
                .toList();

    }*/

    //TeacherDaniel's code! Much better in complex project!
    public List<Order> getAllOrderByOrderStatus(OrderStatus status){
        return orderRepo.getAllOrderByOrderStatus(status);
    }
}
