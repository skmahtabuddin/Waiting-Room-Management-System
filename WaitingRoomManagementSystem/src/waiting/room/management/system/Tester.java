package waiting.room.management.system;

public class Tester {
    
     public static void main(String[] args) {
     Patient p1 = new Patient("Aakash", 10, "O+","M");
     Patient p2 = new Patient("Suma", 20, "O+","F");
     Patient p3 = new Patient("xefer", 30, "B+","F");
     Patient p4 = new Patient("Mahtab", 40, "B-","M");
     Patient p5 = new Patient("nity", 50, "O-","F");
     Patient p6 = new Patient("Protty", 50, "O-","M");
     
     
     //Testing for Array
     System.out.println("Testing for Array");
     WRMSArray w = new WRMSArray();
     w.RegisterPatient(p1);
     w.RegisterPatient(p2);
     w.RegisterPatient(p3);
     w.RegisterPatient(p4);
     w.RegisterPatient(p5);
     w.RegisterPatient(p6);
   

     System.out.println(w.ServePatient().name);
       
     w.ShowAllPatient();

     boolean b = w.CanDoctorGoHome();
     if (b==true){
     System.out.println("Yes");
      }
     else{
     System.out.println("No");
      }

     w.CancelAll();
     
     
     
     //Testing for LinkedList
     System.out.println("Testing for LinkedList");
     WRMSlist v = new WRMSlist();
     v.RegisterPatient(p1);
     v.RegisterPatient(p2);
     v.RegisterPatient(p3);
     v.RegisterPatient(p4);
     v.RegisterPatient(p5);
     v.RegisterPatient(p6);
   

     System.out.println(v.ServePatient().name);
       
     v.ShowAllPatient();

     boolean c = w.CanDoctorGoHome();
     if (c==true){
     System.out.println("Yes");
      }
     else{
     System.out.println("No");
      }

     v.CancelAll();
    }
}
