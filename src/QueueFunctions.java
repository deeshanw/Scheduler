public interface QueueFunctions
{
    void InsertIntoQueue(String subjectname, int priority, double weekhard, double weekendhrs, String t1, String t2);

    void DeleteFromQueue();

    public boolean isEmpty();
    
    public QueueStructure ReturnClassInfo();
    
    public void Print1();
    
    public void Print2();
}
