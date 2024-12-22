package oel;

class MinHeap {
private Event[] heap;
private int size;
MinHeap(int capacity){
	heap= new Event[capacity];
	size=0;
}
public void insert(Event event) {
	heap[size]=event;
	int current=size;
	while(current>0 && heap[current].priority<heap[(current - 1)/2].priority) {
		Event temp = heap[current];
		heap[current]=heap[(current - 1)/2];
		heap[(current - 1)/2]=temp;
		current= (current - 1)/2;
	}
	size++;
}
public Event extractMin() {
	if(size==0) return null;
	Event min = heap[0];
	heap[0]=heap[size - 1];
	size --;
	heapify(0);
	return min;
}
private void heapify(int index) {
	int smallest=index;
	int left=2*index+1;
	int right= 2*index+2;
	if (left < size && heap[left].priority < heap[smallest].priority)
			smallest = left;

			if (right < size && heap[right].priority < heap[smallest].priority)
			smallest = right;

			if (smallest != index) {
			Event temp = heap[index];
			heap[index] = heap[smallest];
			heap[smallest] = temp;
			heapify(smallest);
			}
			}

			public boolean isEmpty() {
			return size == 0;
			}
		}

