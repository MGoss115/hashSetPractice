public class MyHashSet {
    
    private Bucket[] bucketArray;
    private int keyRange;

    public MyHashSet(){
        this.keyRange = 769;
        this.bucketArray = new Bucket[this.keyRange];
        for(int i = 0; i < this.keyRange; i++){
            this.bucketArray[i] = new Bucket();
        }
    }

    
}
