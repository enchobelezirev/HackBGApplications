package encho_belezirev;

import java.util.PriorityQueue;
import java.util.Queue;

public class ToDoList {
    private int remainingHours;
    private Queue<Task> toDoQueue;

    public ToDoList(int remainingHours) {
        this.setRemainingHours(remainingHours);
        this.toDoQueue = new PriorityQueue<>(new ComparatorTask());
    }

    private void setRemainingHours(int value) {
        this.remainingHours = value;
    }

    public int getRemainingHours() {
        return this.remainingHours;
    }

    public void add(Task t) {
        this.toDoQueue.add(t);
    }

    public void markFinished(Task t) {
        t.setStateFinished(true);
    }

    public void markCancelled(Task t) {
        t.setStateCancelled(true);
    }

    public Task getTop() {
        return this.toDoQueue.poll();
    }

    public boolean canFinish() {
        int time = sumTime();
        return time <= this.remainingHours;
    }

    public int getRemainigTime() {
        int time = sumTime();
        return time;
    }
    
    private int sumTime(){
        int sumTime = 0;
        for (Task task : toDoQueue) {
            sumTime += task.getTimeForTask();
        }
        return sumTime;
    }
}
