import java.util.ArrayList;

public class Player{
    private ArrayList<Card> handList;
    public String name;
    public int flg=0;

    public Player(){
        handList=new ArrayList<Card>(5);
    }
    
    public void playerDrawCard(Card card){
        handList.add(card);
    }

    public void playerHandView(){
        System.out.println("");
        System.out.println(name+"の手札");
        int i=1;
        for(Card card:handList){
            System.out.print(i+":");
            card.print();
            i++;
        }
    }

    public Card playerUseCard(int num){
        Card useCard=handList.get(num-1);
        handList.remove(num-1);
        if(handList.size()==0){
            flg=1;    
        }

        return useCard;
    }
}