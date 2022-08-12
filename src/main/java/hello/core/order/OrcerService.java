package hello.core.order;

public interface OrcerService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
