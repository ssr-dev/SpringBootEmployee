package co.edu.uptc.firstJavaWebApp.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class OrderList {
    private List<Order> orderList;
    private static Set<Integer> usedIds = new HashSet<>();

    public OrderList(){
        this.orderList = new ArrayList<>();
    }

    public void addOrder(Order order){
        orderList.add(order);
        usedIds.add(order.getId());
    }

    public Order findOrderById(int idOrder){
        for (Order order: orderList){
            if (order.getId() == idOrder){
                return order;
            }
        }
        return null;
    }

    public List<Order> findOrdersByCustomerId(int customerId) {
        List<Order> result = new ArrayList<>();
        for (Order order : orderList) {
            if (order.getIdCustomerOrder() == customerId) {
                result.add(order);
            }
        }
        return result;
    }

    public List<Order> getOrderList(){
        return orderList;
    }

    public boolean deleteOrder(int idOrder){
        Order order = findOrderById(idOrder);
        if(order != null){
            orderList.remove(order);
            usedIds.remove(idOrder);
            return true;
        }
        return false;
    }

    public int generateUniqueId() {
        Random random = new Random();
        int idOrder;
        do {
            idOrder = random.nextInt(1_000_000);
        } while (usedIds.contains(idOrder));
        usedIds.add(idOrder);
        return idOrder;
    }

    public boolean modifyOrder(Order changeOrder){
        Order existingOrder = findOrderById(changeOrder.getId());
        if (existingOrder != null){
            existingOrder.setDescriptionOrder(changeOrder.getDescriptionOrder());
            existingOrder.setOrderStatus(changeOrder.getOrderStatus());
            return true;
        }
        return false;
    }
}
