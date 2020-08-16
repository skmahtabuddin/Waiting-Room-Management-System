package waiting.room.management.system;

  public class WRMSlist{
    Node head;
    Node tail;
    int id =0;
    
    public void RegisterPatient(Patient p){
    Node n = new Node(p,null);
    if (head==null){
    head =n; 
    tail = n;
    }
    else{
       tail.next = n;
       tail= n;
    }
    id = id + 1;
    p.id = id;
    System.out.println("Successfully Added!");
    }
    
    public Patient ServePatient(){
        if (head==null){
        System.out.println("No one left!");   
        return null;
    }
    else{
        Node rem =  head;
        head= head.next;
        rem.next = null;
        Patient p = (Patient)rem.element;
        return p;
    }
    }
     public void CancelAll(){
        while (head!=null){ 
        Node rem =  head;
        head= head.next;
        rem.next = null;
        rem.element = null;
        }
        System.out.println("Successfully Canceled!");
    }        
    
     public boolean CanDoctorGoHome(){
        if (head==null){   
        return true;
    }
    else{
        return false;
    }       
}  
     
      public void ShowAllPatient(){
          Node v = Sort();
          while(v!=null){ 
          Patient p = (Patient)v.element;    
          System.out.println(p.name+" age:"+p.age+" Sex:"+p.sex+" blood group:"+p.blood_group+" id: "+p.id);  
          v = v.next;
          }    
      }
     
           
    public Node Sort(){
        Node copy =  CopyList();
        Object temp;
        for(Node n = copy; n!=null; n=n.next){            
            Patient p1 = (Patient)n.element;
            String o1 = p1.name;
            
            for(Node v = n.next; v!=null; v=v.next){
                
                Patient p2 = (Patient)v.element;
                String o2 = p2.name;
                    
                if (o1.compareToIgnoreCase(o2)>0) 
                {   
                    temp = n.element ;
                    n.element = v.element;
                    v.element = temp;
                    p1 = (Patient)n.element;
                    o1 = p1.name;
                }
            }                      
        }
        return copy;
    }
       
    public Node CopyList(){
      Node CopyH= null; 
      Node CopyT= null;
      for(Node n = head; n!=null; n=n.next){
          Node newNode = new Node(n.element, null);
          if (CopyH==null){
              CopyH = newNode ; 
              CopyT = newNode ;
          }
          else{
          CopyT.next = newNode ;
          CopyT= newNode;
          }
      }
      return CopyH;
      }
}
