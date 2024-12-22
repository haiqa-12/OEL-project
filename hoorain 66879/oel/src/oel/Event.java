package oel;

public class Event {
 String name;
 int startTime;
 int endTime;
 int priority;
 Event(String name , int startTime , int endTime, int priority){
	 this.name=name;
	 this.startTime=startTime;
	 this.endTime=endTime;
	 this.priority=priority;
 }
 @Override
 public String toString() {
	 return "[" + name + " | Start: "+startTime + "| End: " + endTime + " | Priority: " + priority + "]";
 }
}
class IntervalNode {
	Event event;
	int maxEndTime;
	IntervalNode left,right;
	IntervalNode(Event event){
		this.event=event;
		this.maxEndTime=event.endTime;
	}
}
class IntervalTree{
	IntervalNode root;

	public IntervalNode insert(IntervalNode root,Event event) {
		if(root==null)
			return new IntervalNode(event);
		if(event.startTime<root.event.startTime)
			root.left=insert(root.left,event);
		else
			root.right=insert(root.right,event);
		
		root.maxEndTime=Math.max(root.maxEndTime,event.endTime);
		return root;
		
	}
	public boolean hasConflict(IntervalNode root,Event event) {
		if(root==null)
			return false;
		if(event.startTime<root.event.endTime && event.endTime>root.event.startTime) {
			System.out.println("Conflict with:"+ root.event);
			return true;
		}
		if(root.left!=null&&root.left.maxEndTime>=event.startTime)
			return hasConflict(root.left,event);
		return hasConflict(root.right,event);
	}
}
