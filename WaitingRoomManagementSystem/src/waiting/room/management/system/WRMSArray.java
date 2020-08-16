package waiting.room.management.system;

public class WRMSArray{
   Object [] a;
    int size;
    int start;
    int id;
    public WRMSArray(){
    a = new Object[5];
    size = 0;
    start= 0; 
    id = 0;
}
    
    
    public void RegisterPatient(Patient p){
     if (a.length==size){
      System.out.println("No space left!");
    }
    else{
         id = id +1;
         p.id = id;
        a[(start+size)%a.length]= p;
        size++;
        System.out.println("Successfully Added!");
    }
     
    }
    
    
    public Patient ServePatient(){
        if (size==0){
        System.out.println("No space left!");   
        return null;
    }
    else{
        Patient p = (Patient)a[start];
        a[start] = null;
        size--;
        start = (start+1)%a.length;
        return p;
    }
    }
     
    public void CancelAll(){
        for(int i = 0; i<size; i++){
           a[start] = null;  
           start = (start+1)%a.length;  
        }
        size=0;
        System.out.println("Successfully Canceled!");
    }
    
    
    public boolean CanDoctorGoHome(){
        if (size==0){
        return true;
    }
    else{
        return false;
    }  
}
    
    public void ShowAllPatient(){
        Object [] SortedArr = Sort();
        if (size==0){
        System.out.println("No one left!");    
        }
        int x = start;
       for(int i = 0; i<size; i++){
          Patient p = (Patient)SortedArr[x]; 
          System.out.println(p.name+" age:"+p.age+" Sex:"+p.sex+" blood group:"+p.blood_group+" id: "+p.id);
         x = (x+1)%SortedArr.length;
        } 
    }
   
    public Object[] Sort(){
        Object [] copy = CopyCir();
        int x = start;
        Object temp;
        for (int i = 0; i <size; i++)            
        {
            int y = x+1;
            Patient p1 = (Patient)copy[x];
            String o1 = p1.name;
        
            for (int j = i+1; j <size; j++) 
            {
                Patient p2 = (Patient)copy[y];
                String o2 = p2.name;
                    
                if (o1.compareToIgnoreCase(o2)>0) 
                {   
                    temp = copy[x];
                    copy[x] = copy[y];
                    copy[y] = temp;
                    p1 = (Patient)copy[x];
                    o1 = p1.name;
                }
                y= (y+1)%copy.length;
            }           
            x = (x+1)%copy.length;
            
        }
        return copy;
    }
    
    
    public Object[] CopyCir(){
      Object [] cir = new Object [a.length];
      int index =  start;
      int cirIndex = start;
      for (int i =0; i<size; i++){
         cir[cirIndex]= a[index];
         index=(index+1)%a.length;
         cirIndex=(cirIndex+1)%a.length;
     }
      return cir;
  }
    
    
}
