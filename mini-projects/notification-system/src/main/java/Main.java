import decorator.SignatureDecorator;
import decorator.TimestampDecorator;
import notification.Notification;
import notification.SimpleNotification;
import observable.NotificationObserverable;
import observer.Logger;
import observer.NotificationEngine;
import services.NotificationService;
import strategy.EmailNotification;
import strategy.PushNotification;
import strategy.SmsNotification;

public class Main {

    public static void main(String[] args) {

        // ── Setup ────────────────────────────────────────────────────────────
        NotificationService service = NotificationService.getInstance();
        NotificationObserverable observable = service.getObservable();

        // Wire up observers
        Logger logger = new Logger(observable);
        NotificationEngine engine = new NotificationEngine(observable);

        observable.add(logger);
        observable.add(engine);

        // Wire up delivery strategies
        engine.addNotificationStrategy(new EmailNotification());
        engine.addNotificationStrategy(new SmsNotification());
        engine.addNotificationStrategy(new PushNotification());

        // ── Case 1: Plain notification ────────────────────────────────────────
        System.out.println("========== Case 1: Plain Notification ==========");
        Notification plain = new SimpleNotification("Your order has been placed.");
        service.sendNotification(plain);

        // ── Case 2: Notification with Timestamp decorator ─────────────────────
        System.out.println("\n========== Case 2: Timestamp Decorator ==========");
        Notification timestamped = new TimestampDecorator(
                new SimpleNotification("Server CPU usage exceeded 90%."));
        service.sendNotification(timestamped);

        // ── Case 3: Notification with Signature decorator ─────────────────────
        System.out.println("\n========== Case 3: Signature Decorator ==========");
        Notification signed = new SignatureDecorator(
                new SimpleNotification("Your password was changed."),
                " — Security Team");
        service.sendNotification(signed);

        // ── Case 4: Stacked decorators (Timestamp + Signature) ────────────────
        System.out.println("\n========== Case 4: Stacked Decorators (Timestamp + Signature) ==========");
        Notification stacked = new SignatureDecorator(
                new TimestampDecorator(
                        new SimpleNotification("New login detected from Mumbai.")),
                " — Account Alerts");
        service.sendNotification(stacked);

        // ── Case 5: Stacked decorators in reverse order (Signature + Timestamp) ─
        System.out.println("\n========== Case 5: Stacked Decorators (Signature + Timestamp) ==========");
        Notification stackedReverse = new TimestampDecorator(
                new SignatureDecorator(
                        new SimpleNotification("Your invoice is ready."),
                        " — Billing Dept"));
        service.sendNotification(stackedReverse);

        // ── Case 6: Singleton check ───────────────────────────────────────────
        System.out.println("\n========== Case 6: Singleton Integrity Check ==========");
        NotificationService service2 = NotificationService.getInstance();
        if (service == service2) {
            System.out.println("Singleton OK: both references point to the same instance.");
        } else {
            System.out.println("Singleton BROKEN: different instances returned!");
        }

        // ── Case 7: Multiple notifications in sequence ────────────────────────
        System.out.println("\n========== Case 7: Multiple Sequential Notifications ==========");
        String[] messages = {
            "Payment of $49.99 received.",
            "Shipment dispatched. Tracking: TRK-00123.",
            "Delivery attempted — please reschedule."
        };
        for (String msg : messages) {
            service.sendNotification(new SimpleNotification(msg));
        }

        // ── Case 8: Empty content edge case ───────────────────────────────────
        System.out.println("\n========== Case 8: Empty Content Edge Case ==========");
        Notification empty = new SimpleNotification("");
        service.sendNotification(empty);

        // ── Case 9: Decorated empty content ───────────────────────────────────
        System.out.println("\n========== Case 9: Decorated Empty Content ==========");
        Notification decoratedEmpty = new TimestampDecorator(
                new SignatureDecorator(new SimpleNotification(""), " — System"));
        service.sendNotification(decoratedEmpty);

        // ── Case 10: Dynamic strategy change ─────────────────────────────────
        System.out.println("\n========== Case 10: Engine with Single Strategy Only ==========");
        NotificationObserverable observable2 = new NotificationObserverable();
        NotificationEngine singleStrategyEngine = new NotificationEngine(observable2);
        singleStrategyEngine.addNotificationStrategy(new PushNotification());
        observable2.add(singleStrategyEngine);
        observable2.setNotification(new SimpleNotification("Push-only alert: disk space low."));

        System.out.println("\n========== All cases completed. ==========");
    }
}