import java.util.Scanner;

public class DeckCheck{
    public static void main(String[] args){
        Deck deck=new Deck();
        deck.printCardList();

        Scanner input=new Scanner(System.in);
        System.out.print("num:");
        int num=input.nextInt();

        try{
            Card draw=deck.drawCard(num);
            draw.print();
        }catch(IndexOutOfBoundsException e){
            System.out.println("num 0~52");
        }
    }
}