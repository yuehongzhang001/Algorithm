
/**
 * The Driver to test program
 * @author Yuehong Zhang 3109345
 */
public class PartB_Driver {
    public static void main(String[] args){
       PriorityQueue<Integer, String> patients = new LinkedHeapPriorityQueue<>();
       System.out.println("This is a simulation of the patients in line.");
       //insert  patients name with unique keys.
       patients.insert(3, "Candy");
       patients.insert(4, "Dikey");
       patients.insert(5, "Elen");
       patients.insert(10,"Jay");
       patients.insert(1, "Amanda");
       patients.insert(2, "Borne");
       patients.insert(8, "Hellen");
       patients.insert(9, "Isaac");
       patients.insert(6, "Frank");
       patients.insert(7, "Giggy");
       //display all the patients key and names.
       System.out.println("All the patients: ");
       System.out.println(patients);
       int size = patients.size();//get the size of the PriorityQueue
       for(int i=0;i<size;i++){
           System.out.println("Next patient "+patients.removeMin()+" is served now");//call a patient each time
           System.out.println("Patients left: "+patients);//display the rest of patients.
       }
    }
}
