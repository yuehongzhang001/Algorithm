
/**
 * This class will implement passenger interface.
 * @author Yuehong Zhang 3109345
 */

public class Person implements Passenger{
    private String firstName;//person's first name attribute.
    private String lastName;//person's last name attribute.
    private int age;//person's age attribute.
    
    public Person(String firstName, String lastName, int age){
        this.firstName = firstName;//initialize firstName.
        this.lastName = lastName;//initialize lastName.
        this.age = age;//initialize age.
    }
    /**
     * implement Passenger's getName method.
     * @return full name of the passenger.
     */
    public String getName(){
        return firstName+" "+lastName;//full name of the passenger.
    }
    
    /**
     * implement Passenger's getFareType method.
     * @return the fare type of passenger.
     */
    public String getFareType(){
        if(age<18) 
            return "Youth";// if age less than 18, return "Youth".
        else if(age > 65){
            return "Senior";// if age less than 18, return "Senior".
        }
        else
            return "Regular";// if age less than 18, return "Regular".
    }
}
