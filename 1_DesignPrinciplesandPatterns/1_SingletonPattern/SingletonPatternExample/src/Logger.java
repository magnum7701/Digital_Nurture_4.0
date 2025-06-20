public class Logger{
    private static Logger l;

    private Logger(){
        System.out.println("Logger object created !");
    }

    public static Logger getLogger(){
        if(l==null){
             l = new Logger();
        }
        return l;
    }

    public void display(){
        System.out.println("Display function");
    }

    public static void main(String[] args){
        Logger obj1 = getLogger();
        Logger obj2 = getLogger();

        obj1.display();
        obj2.display();

        System.out.println("Are obj1 and obj2 same ? (True/False) : "+(obj1==obj2));
    }

}