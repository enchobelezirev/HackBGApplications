package encho_belezirev;


public class Problem7StudentClass implements Comparable<Problem7StudentClass> {
    private int grade;
    private String name;

    public Problem7StudentClass(String name, int grade) {
        this.setName(name);
        this.setGrade(grade);
    }
    public String getName() {
        return this.name;
    }

    public void setName(String value) {
        if (value.length() < 5 || value.length() > 100) {
            System.out.println("The name of a person shud be between 5-100 letters!!!!");
            return;
        }
        this.name = value;
    }
    
    public int getGrade(){
        return this.grade;
    }
    
    public void setGrade(int value){
        if (value < 2 || value > 6) {
            System.out.println("The grade is an int between 2 and 6. Please be more carefull");
            return;
        }
        this.grade = value;
    }
    @Override
    public int compareTo(Problem7StudentClass o) {
        int compare = 0;
        if (this.getGrade() > o.getGrade()) {
            compare = 1;
        }
        if(this.getGrade() < o.getGrade()){
            compare = -1;
        }
        
        if (this.getGrade() == o.getGrade()) {
            compare = this.getName().compareTo(o.getName());
        }
        
        return compare;
    }
}
