import java.util.ArrayList;
import java.util.Collections;

public class Deck{
    private ArrayList<Card> cardList;

    public Deck(){
        String[] marks=new String[]{"ダイヤ","スペード","ハート","クローバー"};
        ArrayList<Card> cardList=new ArrayList<>(52);

        for(int i=0;i<marks.length;i++){
            String mark=marks[i];

            for(int j=1;j<=13;j++){
                Card card=new Card(mark,j);
                cardList.add(card);
            }
        }

        Collections.shuffle(cardList);
        this.cardList=cardList;
    }

    public void printCardList(){
        for(Card card:cardList){
            card.print();
        }
    }

    public Card drawCard(int num){
        Card card=cardList.get(num);
        cardList.remove(num);
        return card;
    }

    public void deckSize(){
        int size=cardList.size();
        System.out.println("山札のこり"+size+"枚");
    }
}