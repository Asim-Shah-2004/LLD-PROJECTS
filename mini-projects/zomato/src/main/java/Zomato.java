import factory.NowOrderFactory;
import factory.OrderFactory;
import factory.ScheduledOrderFactory;
import java.util.Arrays;
import java.util.List;
import managers.OrderManager;
import managers.RestaurantManager;
import models.Cart;
import models.MenuItem;
import models.Order;
import models.Restaurant;
import models.User;
import services.NotificationService;
import strategies.CreditCardPaymentStrategy;
import strategies.PaymentStrategy;
import strategies.UpiPaymentStrategy;

public class Zomato {
	public static void main(String[] args) {
		RestaurantManager restaurantManager = RestaurantManager.getInstance();
		OrderManager orderManager = OrderManager.getInstance();

		Restaurant spiceVilla = new Restaurant("Spice Villa", "Downtown");
		Restaurant greenBowl = new Restaurant("Green Bowl", "Uptown");

		MenuItem biryani = new MenuItem("M1", "Biryani", 220);
		MenuItem kebab = new MenuItem("M2", "Kebab", 180);
		MenuItem salad = new MenuItem("G1", "Salad", 140);
		MenuItem smoothie = new MenuItem("G2", "Smoothie", 120);

		spiceVilla.getMenu().addAll(Arrays.asList(biryani, kebab));
		greenBowl.getMenu().addAll(Arrays.asList(salad, smoothie));

		restaurantManager.addRestaurant(spiceVilla);
		restaurantManager.addRestaurant(greenBowl);

		User arya = new User("Arya", "Sector 7");
		User neil = new User("Neil", "Sector 12");

		// Cart edge case: item added before restaurant selection.
		Cart invalidCart = new Cart();
		invalidCart.addItem(biryani);

		Cart aryaCart = arya.getCart();
		aryaCart.setRestaurant(spiceVilla);
		aryaCart.addItem(biryani);
		aryaCart.addItem(kebab);

		Cart neilCart = neil.getCart();
		neilCart.setRestaurant(greenBowl);
		neilCart.addItem(salad);
		neilCart.addItem(smoothie);

		OrderFactory nowFactory = new NowOrderFactory();
		OrderFactory scheduledFactory = new ScheduledOrderFactory("2026-05-25 20:00");

		PaymentStrategy cardPayment = new CreditCardPaymentStrategy();
		PaymentStrategy upiPayment = new UpiPaymentStrategy();

		Order deliveryNow = nowFactory.createOrder(
				arya,
				aryaCart,
				aryaCart.getRestaurant(),
				aryaCart.getItems(),
				cardPayment,
				aryaCart.getCost(),
				"Delivery"
		);

		placeOrder(orderManager, deliveryNow);

		Order pickupNow = nowFactory.createOrder(
				arya,
				aryaCart,
				aryaCart.getRestaurant(),
				aryaCart.getItems(),
				upiPayment,
				aryaCart.getCost(),
				"Pickup"
		);

		placeOrder(orderManager, pickupNow);

		Order deliveryScheduled = scheduledFactory.createOrder(
				neil,
				neilCart,
				neilCart.getRestaurant(),
				neilCart.getItems(),
				upiPayment,
				neilCart.getCost(),
				"Delivery"
		);

		placeOrder(orderManager, deliveryScheduled);

		Order pickupScheduled = scheduledFactory.createOrder(
				neil,
				neilCart,
				neilCart.getRestaurant(),
				neilCart.getItems(),
				cardPayment,
				neilCart.getCost(),
				"Pickup"
		);

		placeOrder(orderManager, pickupScheduled);

		System.out.println("\n--- Restaurants ---");
		List<Restaurant> restaurants = restaurantManager.listRestaurant();
		for (Restaurant restaurant : restaurants) {
			System.out.println(restaurant.getName() + " @ " + restaurant.getLocation());
		}

		orderManager.listOrders();
	}

	private static void placeOrder(OrderManager orderManager, Order order) {
		boolean paid = order.processPayment(order.getTotal());
		if (!paid) {
			System.out.println("Payment failed for order " + order.getOrderId());
		}
		orderManager.addOrder(order);
		NotificationService.notify(order);
	}
}
