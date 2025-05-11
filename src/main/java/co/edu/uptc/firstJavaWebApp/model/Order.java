package co.edu.uptc.firstJavaWebApp.model;

public class Order {
    private int id;
    private int idCustomerOrder;
    private String dateOrder;
    private String descriptionOrder;
    private String orderStatus;
    
    public Order(){}
    
    public Order(int id, int idCustomerOrder, String dateOrder, String descriptionOrder, String orderStatus){
        this.id = id;
        this.idCustomerOrder = idCustomerOrder;
        this.dateOrder = dateOrder;
        this.descriptionOrder = descriptionOrder;
        this.orderStatus = orderStatus;
    }

    
     
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }

    public String getDescriptionOrder() {
        return descriptionOrder;
    }

    public void setDescriptionOrder(String descriptionOrder) {
        this.descriptionOrder = descriptionOrder;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getIdCustomerOrder() {
        return idCustomerOrder;
    }

    public void setIdCustomerOrder(int idCustomerOrder) {
        this.idCustomerOrder = idCustomerOrder;
    }

}
