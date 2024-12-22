
package oel;
import java.util.Scanner;
public class EventScheduler {
		IntervalTree intervalTree = new IntervalTree();
		MinHeap minHeap = new MinHeap(100);

		public void addEvent(String name, int startTime, int endTime, int priority) {
	Event event = new Event(name, startTime, endTime, priority);


		if (intervalTree.hasConflict(intervalTree.root, event)) {
		System.out.println("Event cannot be added due to conflict.");
	return;
		}

		
		intervalTree.root = intervalTree.insert(intervalTree.root, event);
		minHeap.insert(event);
		System.out.println("Event added successfully: " + event);
		}

		public void displaySchedule() {
		System.out.println("\n--- Prioritized Schedule ---");
		while (!minHeap.isEmpty()) {
		System.out.println(minHeap.extractMin());
		}
		}

		public static void main(String[] args) {
		EventScheduler scheduler = new EventScheduler();
		Scanner scanner = new Scanner(System.in);

		while (true) {
		System.out.println("\n1. Add Event\n2. Show Schedule\n3. Exit");
		int choice = scanner.nextInt();
		scanner.nextLine();

		if (choice == 1) {
		System.out.println("Enter event name:");
		String name = scanner.nextLine();
		System.out.println("Enter start time:");
		int start = scanner.nextInt();
		System.out.println("Enter end time:");
		int end = scanner.nextInt();
		System.out.println("Enter priority:");
		int priority = scanner.nextInt();

		scheduler.addEvent(name, start, end, priority);
		} else if (choice == 2) {
		scheduler.displaySchedule();
		} else if (choice == 3) {
		break;
		}
		}

		scanner.close();
		}
		}


