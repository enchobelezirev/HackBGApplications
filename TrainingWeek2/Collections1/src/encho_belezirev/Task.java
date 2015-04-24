package encho_belezirev;

public class Task {
    private String description;
    private float priority;
    private int timeForTask;
    private boolean isFinished;
    private boolean isCancelled;

    public Task(String description, int timeForTask) {
        this.setDescription(description);
        this.setTimeForTask(timeForTask);
        this.isFinished = false;
        this.isCancelled = false;
    }

    public Task(String description, float priority) {
        this.setDescription(description);
        this.setPriority(priority);
        this.isFinished = false;
        this.isCancelled = false;
    }

    private void setDescription(String value) {
        this.description = value;
    }

    public String getDescription() {
        return this.description;
    }

    private void setTimeForTask(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("The time for the task shoudl be positive number!");
        }
        this.timeForTask = value;
    }
    
    public int getTimeForTask(){
        return this.timeForTask;
    }
    
    private void setPriority(float value){
        if (value < 0) {
            throw new IllegalArgumentException("Priority should be non-negative number!");
        }
        this.priority = value;
    }
    
    public float getPriority(){
        return this.priority;
    }
    
    public void setStateFinished(boolean value){
        this.isFinished = value;
    }
    
    public boolean getStateFinished(){
        return this.isFinished;
    }
    
    public void setStateCancelled(boolean value){
        this.isCancelled = value;
    }
    
    public boolean getStateCancelled(){
        return this.isCancelled;
    }
}
