class Q5 {
      int size=1000000;
      Hashnode[] harr;
      
    class Hashnode{
        int key;
        int value;
        public Hashnode(int k,int v){
            key=k;
            value=v;
        }
    }

    public Q5() {
    harr=new Hashnode[size];
    }
    int hash(int k){
     return ( k )%size;
    }
    
    public void put(int key, int value) {
        Hashnode g=new Hashnode(key,value);
        int index=hash(key);
        if(harr[index]==null){
        harr[index]=g;}
        else{
            harr[index].key=key;
            harr[index].value=value;
        }
    }
   
    
    public int get(int key) {
        if(harr[hash(key)]!=null){
            return harr[hash(key)].value;
        }
        else{
            return -1;
        }
    }
   
    
    public void remove(int key) {
       if(harr[hash(key)]!=null){
           harr[hash(key)]=null;
       }
        else{
            return ;
        }
    }
}
