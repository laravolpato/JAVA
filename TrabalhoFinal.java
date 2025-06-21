import java.util.Scanner;
import java.util.Random;

public class TrabalhoFinal
{
    public static void MostraMatriz(char[][] M, int linhas, int colunas)
    {
        for(int L=0; L<linhas; L++)
        {
            for(int C=0; C<colunas; C++)
            {
                System.out.printf(" %c ", M[L][C]);
            }
            System.out.printf("\n");
        }
    }
    
    public static double Modulo(int valor)
    {
        return Math.sqrt(valor * valor);
    }
    
    public static void main(String[] args)
    {
        Scanner entrada = new Scanner(System.in);
        Random rd = new Random();
        
        System.out.print("Informe a quantidade de linhas (mínimo 3): ");
        int Linhas = entrada.nextInt();
        
        System.out.print("Informe a quantidade de colunas (mínimo 3): ");
        int Colunas = entrada.nextInt();
        
        if(Linhas < 3 || Colunas < 3)
        {
            System.out.println("Linhas e colunas devem ser no mínimo 3");
            return;
        }
        
        char[][] M = new char[Linhas][Colunas];
        
        for(int L=0; L<Linhas; L++)
        {
            for(int C=0; C<Colunas; C++)
            {
                M[L][C] = '.';
            }
        }
        
        int[] pontos = new int[4];
        
        for(int i=0; i<4; i++)
        {
            boolean achei = true;
            int nro = 0;
            
            if(i==0)
            {
                nro = rd.nextInt(Linhas * Colunas);
            }
            else
            {
                while(achei)
                {
                    achei = false;
                    nro = rd.nextInt(Linhas * Colunas);
                    for(int j=0; j<i; j++)
                    {
                        if(nro == pontos[j])
                        {
                            achei = true;
                        }
                    }
                }
            }
            pontos[i] = nro;
        }
        
        int A_L = pontos[0] / Colunas;
        int A_C = pontos[0] % Colunas;
        int B_L = pontos[1] / Colunas;
        int B_C = pontos[1] % Colunas;
        int C_L = pontos[2] / Colunas;
        int C_C = pontos[2] % Colunas;
        int D_L = pontos[3] / Colunas;
        int D_C = pontos[3] % Colunas;
        
        System.out.println("::: PontoA: L=" + A_L + ", C=" + A_C);
        System.out.println("::: PontoB: L=" + B_L + ", C=" + B_C);
        System.out.println("::: PontoC: L=" + C_L + ", C=" + C_C);
        System.out.println("::: PontoD: L=" + D_L + ", C=" + D_C);
        System.out.println("::: >>> Nenhum ponto com coordenadas repetidas! <<<");
        
        M[A_L][A_C] = 'A';
        M[B_L][B_C] = 'B';
        M[C_L][C_C] = 'C';
        M[D_L][D_C] = 'D';
        
        double DistAB = Modulo(A_L - B_L) + Modulo(A_C - B_C);
        double DistY_AB = Modulo(A_C - B_C);
        double DistX_AB = Modulo(B_L - A_L);
        double DeslY_AB = DistY_AB / DistAB;
        double DeslX_AB = DistX_AB / DistAB;
        double PosY_AB = A_L;
        double PosX_AB = A_C;
        
        for(int avanco=0; avanco<DistAB; avanco++)
        {
            if(B_L > A_L)
            {
                PosY_AB += DeslX_AB;
            }
            else if(B_L < A_L)
            {
                PosY_AB -= DeslX_AB;
            }
            
            if(B_C > A_C)
            {
                PosX_AB += DeslY_AB;
            }
            else if(B_C < A_C)
            {
                PosX_AB -= DeslY_AB;
            }
            
            if(M[(int)PosY_AB][(int)PosX_AB]=='.')
            {
                M[(int)PosY_AB][(int)PosX_AB] = '+';
            }
        }
        
        double DistCD = Modulo(C_L - D_L) + Modulo(C_C - D_C);
        double DistY_CD = Modulo(C_C - D_C);
        double DistX_CD = Modulo(D_L - C_L);
        double DeslY_CD = DistY_CD / DistCD;
        double DeslX_CD = DistX_CD / DistCD;
        double PosY_CD = C_L;
        double PosX_CD = C_C;
        
        for(int avanco=0; avanco<DistCD; avanco++)
        {
            if(D_L > C_L)
            {
                PosY_CD += DeslX_CD;
            }
            else if(D_L < C_L)
            {
                PosY_CD -= DeslX_CD;
            }
            
            if(D_C > C_C)
            {
                PosX_CD += DeslY_CD;
            }
            else if(D_C < C_C)
            {
                PosX_CD -= DeslY_CD;
            }
            
            if(M[(int)PosY_CD][(int)PosX_CD]=='.')
            {
                M[(int)PosY_CD][(int)PosX_CD] = '*';
            }
        }
        MostraMatriz(M, Linhas, Colunas);
    }    
}
