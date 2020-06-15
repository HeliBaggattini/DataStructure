package SetClasses;

/**
 *
 * @author helimar.baggattini
 */
public class UniqueSet extends SimpleSet{
    
    //standard constructor
    public UniqueSet() {
        
    }

    //copy constructor
    public UniqueSet(UniqueSet us) {
        this.addAll(us);
    }
    
    //add method
    public void add(String item){
        if(!contains(item)){
            this.array.add(item);
        }
    }
    
    //addAll method
    public void addAll(UniqueSet us){
        for (String s: us.array){
            add(s);
        }
    }
    
    //copy method
    public UniqueSet copy(){
        UniqueSet u = new UniqueSet();
        u.addAll(this);
        
        return u;
    }
    
    //union method
    public UniqueSet union(UniqueSet us){
        UniqueSet uni = new UniqueSet();
        uni = this.copy();
        uni.addAll(us);
        
        return uni;
    }
    
    //intersection method
    public UniqueSet intersection (UniqueSet us){
        UniqueSet uni = new UniqueSet();
        
        for(String s1 : this.array){
            for(String s2: us.array){
                if(s1.equals(s2)){
                    uni.add(s1);
                }
            }
        }
        
        return uni;
        
    }
    
    //difference method
    public UniqueSet difference (UniqueSet us){
        UniqueSet uni = new UniqueSet();
        uni.addAll(this);
        uni.removeAll(us);
        
        return uni;
    }
    
    //remove all method
    public void removeAll (UniqueSet us){
        this.array.removeAll(us.array);
    }
    
}
