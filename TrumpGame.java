import java.util.Scanner;

public class TrumpGame{
    public static void main(String[] args){
        Deck d=new Deck();
        Human h=new Human();
        for(int i=0;i<5;i++){
            h.playerDrawCard(d.drawCard(i));
        }
        Computer c=new Computer();
        for(int i=0;i<5;i++){
            c.playerDrawCard(d.drawCard(i));
        }

        Stage s=new Stage();
        d.deckSize();

        int num;
        int e2Flg=0;
        while(true){
            Scanner input=new Scanner(System.in);

            h.playerHandView();
            try{
                num=input.nextInt();
                Card use=h.playerUseCard(num);

                try{
                    Card draw=d.drawCard(0);
                    h.playerDrawCard(draw);
                }catch(IndexOutOfBoundsException e2){
                    System.out.println("山札がなくなりました");
                    e2Flg=1;
                }finally{
                    s.visit(h.name,use);
                    use=c.playerUseCard(1);
                    c.playerDrawCard(d.drawCard(0));
                    d.deckSize(); 
                    s.visit(c.name,use);
        
                }

            }catch(IndexOutOfBoundsException e1){
                if(e2Flg!=1){
                    System.out.println("選択範囲外です");
                }
            
            }catch(java.util.InputMismatchException e0){
                System.out.println("数字を入力してください");
                
            }finally{
                
                if(s.success==1){
                    System.out.println("YOU WIN!");
                    break;
                }else if(s.success==2){
                    System.out.println("敵に見つかりました");
                    System.out.println("  GAMEOVER  ");
                    break;
                }else if(h.flg==1){
                    System.out.println("手札がなくなりました");
                    System.out.printf("  GAMEOVER  ");        
                    break;
                }
            }
        }

    }

}