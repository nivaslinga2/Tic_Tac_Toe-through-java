import java.util.*;
public class TicTokToe {
        public static void main(String[] args){
            char[][] box=new char[4][4];
            int r=box.length;
            int c=box[0].length;
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    box[i][j]=' ';
                }
            }
            char player='X';
            boolean over=false;
            Scanner sc=new Scanner(System.in);
            
            System.out.print("Enter Player1 (X) name: ");
            String player1Name = sc.nextLine();
            System.out.print("Enter Player2 (O) name: ");
            String player2Name = sc.nextLine();
            System.out.println();
            
            while(!over){
                printbox(box);
                String playerName = (player == 'X') ? player1Name : player2Name;
                System.out.print(playerName + " enter :");
                int row=sc.nextInt();
                int col=sc.nextInt();
                System.out.println();
                if(box[row][col]==' '){
                    box[row][col]=player;
                    over=won(box,player);
                    if(over){
                        System.out.println(playerName + " won the match :");
                    }
                    else{
                        player=(player=='X'?'O':'X');
                    }
                }
                else{
                System.out.println("Invalid move ");
                }
            }
            printbox(box);
        }
            // public static void printbox(char[][] box){
            //     for(int i=0;i<box.length;i++){
            //         for(int j=0;j<box[0].length;j++){
            //             System.out.print(box[i][j]+" |");
            //         }
            //         System.out.println();
            //     }
            // }
            public static void printbox(char[][] box) {
                int n = box.length;
                System.out.println("\nCurrent Board:");
                System.out.print("   ");
                for (int i = 0; i < n; i++) {
                    System.out.print(i + "   ");
                }
                System.out.println();

                for (int i = 0; i < n; i++) {
                    System.out.print(" +");
                    for (int j = 0; j < n; j++) {
                        System.out.print("---+");
                    }
                    System.out.println();

                    System.out.print(i + "|");
                    for (int j = 0; j < n; j++) {
                        System.out.print(" " + box[i][j] + " |");
                    }
                    System.out.println();
                }

                System.out.print(" +");
                for (int j = 0; j < n; j++) {
                    System.out.print("---+");
                }
                System.out.println();
        }

        public static boolean won(char[][] box,char player){
            for(int row=0;row<box.length;row++){
                if(box[row][0]==player && box[row][1]==player && box[row][2]==player && box[row][3]==player  ){
                    return true;
                }
            }
             for(int col=0;col<box[0].length;col++){
                if(box[0][col]==player && box[1][col]==player && box[2][col]==player && box[3][col]==player  ){
                    return true;
                }
            }
            if(box[0][0]==player && box[1][1]==player && box[2][2]==player && box[3][3]==player ){
                return true;
            }
            if(box[0][3]==player && box[1][2]==player && box[2][1]==player && box[3][0]==player){
                return true;
            }
            return false;  
        }
}