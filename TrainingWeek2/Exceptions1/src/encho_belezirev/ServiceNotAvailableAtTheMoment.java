package encho_belezirev;

//Problem 2
public class ServiceNotAvailableAtTheMoment extends Exception {
    private String breakdownReason;
    private String message;
    
    public ServiceNotAvailableAtTheMoment(String message) {
        super(message);
    }
    
    public ServiceNotAvailableAtTheMoment(){
    }
    
    public String getReason() {
        return this.breakdownReason;
    }
    
    public String getMessage(){
        return this.message;
    }
    
    private void setReason(String value){
        this.breakdownReason = value;
    }
    
    private void setMessage(String value){
        this.message = value;
    }
    
    public void useService(String message, String reason) throws ServiceNotAvailableAtTheMoment{
        this.setMessage(message);
        this.setReason(reason);
        System.out.println("Reason for the breakdown: "+this.getReason());
        throw new ServiceNotAvailableAtTheMoment(this.getMessage());
    }
    
}
