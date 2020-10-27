public class Card{
    public String mark;
    public int number;

    public Card(String mark,int number){
        this.mark=mark;
        this.number=number;
    }

    public void print(){
        System.out.println(mark+"の"+number);
    }
}