import java.util.Scanner;

public class Human extends Player{
    public Human(){
        super();
        this.name=setName();
    }

    public String setName(){
        Scanner input=new Scanner(System.in);
        System.out.print("Your name?:");
        String name=input.next();
        return name;
    }
}