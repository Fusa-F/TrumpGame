public class Stage{
    final private int max_x=20;
    final private int max_y=20;

    private int[][] m={
        {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
        {2,2,2,2,2,2,2,2,0,2,2,2,2,2,2,2,2,2,2,2},
        {2,2,2,2,2,2,2,2,0,0,2,2,2,2,2,2,2,2,2,2},
        {2,2,2,2,2,2,2,2,0,0,0,2,2,2,2,2,2,2,2,2},
        {2,2,2,2,2,2,2,2,0,0,0,2,2,2,2,2,2,2,2,2},
        {2,2,2,2,2,2,2,0,0,0,0,0,2,2,2,2,2,2,2,2},
        {2,2,2,2,2,2,2,0,0,0,0,0,2,2,2,2,2,0,2,2},
        {2,2,2,2,2,2,0,0,0,0,0,0,0,0,2,2,0,0,2,2},
        {2,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,2,2},
        {2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2},
        {2,2,2,0,2,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2},
        {2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
        {2,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,0,2,2,2},
        {2,0,2,2,2,0,0,0,0,0,0,0,0,2,2,2,2,2,2,2},
        {2,0,2,2,2,0,0,0,0,0,0,0,2,2,2,2,2,2,2,2},
        {2,0,0,0,2,2,2,0,0,0,0,2,2,2,2,2,2,2,2,2},
        {2,0,2,0,2,2,2,2,0,0,2,2,2,2,2,2,2,2,2,2},
        {2,0,2,0,2,2,2,2,2,0,2,2,2,2,2,2,2,2,2,2},
        {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
        {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}
    };

    private int Px=6,Py=11;//Player と Computer と Goal の初期座標
    private int Cx=12,Cy=12;
    private int Gx=9,Gy=2;
    public int success=0;//Goal判定のフラグ

    public Stage(){
        view();
    }

    public void view(){
        for(int i=0;i<max_y;i++){
            for(int j=0;j<max_x;j++){
                if(i==Py&&j==Px){
                    System.out.print("Ｐ");
                }else if(i==Cy&&j==Cx){
                    System.out.print("Ｃ");
                }else if(i==Gy&&j==Gx){
                    System.out.print("Ｇ");
                }else if(m[i][j]==0){
                    System.out.print("  ");    
                }else if(m[i][j]==2){
                    System.out.print("[]");
                }
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("クローバー:←  ハート:↑  スペード:→  ダイヤ:↓");
    }
    public void visit(String name,Card card){
        if(name.equals("Computer")){
            for(int i=1;i<=card.number;i++){
                if(card.mark.equals("スペード")&&m[Cy][Cx+1]==0){
                    Cx++;
                }else if(card.mark.equals("クローバー")&&m[Cy][Cx-1]==0){
                    Cx--;
                }else if(card.mark.equals("ハート")&&m[Cy-1][Cx]==0){
                    Cy--;
                }else if(card.mark.equals("ダイヤ")&&m[Cy+1][Cx]==0){
                    Cy++;
                }else{
                    break;
                }
            }
        }else{
            for(int i=1;i<=card.number;i++){
                if(card.mark.equals("スペード")&&m[Py][Px+1]==0){
                    Px++;
                }else if(card.mark.equals("クローバー")&&m[Py][Px-1]==0){
                    Px--;
                }else if(card.mark.equals("ハート")&&m[Py-1][Px]==0){
                    Py--;
                }else if(card.mark.equals("ダイヤ")&&m[Py+1][Px]==0){
                    Py++;
                }else{
                    break;
                }
            }
            view();
        }

        if(Py==Gy&&Px==Gx){
            success=1;
        }
        if(Py==Cy&&Px==Cx){
            success=2;
        }  
    }
}