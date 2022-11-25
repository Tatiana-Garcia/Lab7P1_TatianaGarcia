
package lab7p1_tatianagarcia;
import java.util.Random;
import javax.swing.JOptionPane;
/**
 *
 * @author tatig
 */
public class Lab7P1_TatianaGarcia {
    static Random aleatorio = new Random();

    
    public static int menu()
    {
        String entrada = JOptionPane.showInputDialog(null, """
                1-PORTRAIT
                2-NUMERO MAGICO
                3-SUBSECUENCIA
                4-SALIDA""","MENU",JOptionPane.INFORMATION_MESSAGE);
        int menu = Integer.parseInt(entrada);
        int opcion = menu; 
        return opcion;
    }
    
    public static void main(String[] args) {
        int opcion = menu();
        do 
        {
            int fil, col;
            switch (opcion)
            {
                case 1: 
                {
                    String filas = JOptionPane.showInputDialog(null,"Ingrese numero de filas(M):",
                            "-- PORTRAIT --",JOptionPane.INFORMATION_MESSAGE);
                    fil = Integer.parseInt(filas);
                    String columnas = JOptionPane.showInputDialog(null,"Ingrese numero de columnas(N):",
                            "-- PORTRAIT --",JOptionPane.INFORMATION_MESSAGE);
                    col = Integer.parseInt(columnas);
                    
                    int[][]numeros = lectura(fil,col); 
                    int [][]rotada = rotacion(numeros);
                    JOptionPane.showMessageDialog(null, "Matriz generada:\n"+imprimirmatriz(numeros)
                            +"\nLa matriz rotada es: \n"+imprimirmatriz(rotada),
                            "-- PORTRAIT --",JOptionPane.INFORMATION_MESSAGE);
                    
                    
                    break; 
                }
                case 2: 
                {
                    String filas = JOptionPane.showInputDialog(null,"Ingrese numero de filas(M):",
                            "-- NUMERO MAGICO --",JOptionPane.INFORMATION_MESSAGE);
                    fil = Integer.parseInt(filas);
                    String columnas = JOptionPane.showInputDialog(null,"Ingrese numero de columnas(N):",
                            "-- NUMERO MAGICO --",JOptionPane.INFORMATION_MESSAGE);
                    col = Integer.parseInt(columnas);
                    
                    int[][]numeros = lectura(fil,col); 
                    int [] array = magia(numeros);
                    JOptionPane.showMessageDialog(null, "Matriz generada:\n"+imprimirmatriz(numeros)
                            +"Op.1: "+array[0]+"\nOp.2 "+array[1]+"\nEl numero generado es: "+array[2],
                            "-- NUMERO MAGICO --",JOptionPane.INFORMATION_MESSAGE);
                    break; 
                }
                case 3:
                {
                    String cadena="-", cadena2="-"; 
                    cadena += JOptionPane.showInputDialog(null,"Ingrese una palabra:",
                            "-- SUBSECUENCIA --",JOptionPane.INFORMATION_MESSAGE);
                    
                    cadena2 += JOptionPane.showInputDialog(null,"Ingrese otra palabra:",
                            "-- SUBSECUENCIA --",JOptionPane.INFORMATION_MESSAGE);
                    
                    
                    int num = numero(cadena, cadena2);  
                    
                    JOptionPane.showMessageDialog(null, "Cadena 1:"+cadena+"\nCadena 2:"
                            +cadena2+"\nEl size de la subsecuencia mas grande es: "+num,
                            "-- SUBSECUENCIA --",JOptionPane.INFORMATION_MESSAGE);
                    
                    break;
                }
                default: 
                {
                    JOptionPane.showMessageDialog(null,"Salida del sistema",
                            "-- MENU --",JOptionPane.INFORMATION_MESSAGE);
                }
                
            }//Fin del switch
            opcion = menu();
        }while(opcion < 4);
        
    }//fin del main 
    
    
    public static int[][]lectura(int fil, int col)
    {
        int temporal [][] = new int [fil][col];
        for (int i = 0; i < fil; i++)
        {
            for (int j = 0; j < col; j++)
            {
                temporal[i][j]= aleatorio.nextInt(10);
            }
        }
        return temporal; 
    }
    
    public static String imprimirmatriz(int [][]numeros)
    {
        String cadena = "";
        if (numeros.length != numeros[0].length)
        {
            for (int i = 0; i < numeros.length; i++)
            {
                for (int j = 0; j < numeros[i].length; j++)
                {
                    cadena += "["+numeros [i][j]+"]"+" "; 
                }
                cadena += "\n";
            } 
        }
        else 
        {
            cadena = "M y N deben ser numeros diferentes\n"; 
        }    
        
        return cadena; 
    }
    
    //NOT USED
    public static String imprimir(int [][]numeros)
    {
        String cadena = "";
        
        for (int i = 0; i < numeros.length; i++)
        {
            for (int j = 0; j < numeros[i].length; j++)
            {
                cadena += "["+numeros [i][j]+"]"+" "; 
            }
            cadena += "\n";
        } 
        
        return cadena; 
    }
    public static String imprimirarreglo(int [] array)
    {
        String cadena = ""; 
        
        for (int i = 0; i < array.length; i++)
        {
            cadena += "["+array[i]+"] ";
        }
        return cadena;
    }
    //END OF NOT USED
    
    //case 1
    public static int [][]rotacion(int [][]matriz)
    {
        int [][]rotada = new int [matriz[0].length][matriz.length];
         
        for (int i = 0; i < matriz[0].length; i++)
        {
            int con = 0;
            for (int j = matriz.length -1; j >=0;j--)
            {
                rotada[i][con]= matriz[j][i];
                con++;
            }
        }
        return rotada;
    }
    //case 2
    public static int []magia(int [][] matriz)
    {
        int respuesta, respuesta1=0, respuesta2=1;
        for (int i = 0; i < matriz.length; i++)
        {
            for (int j = 0; j < matriz[i].length; j++)
            {
                if (i == 0 || i == matriz.length-1||j == 0||j == matriz[i].length-1)
                {
                    respuesta1 += matriz[i][j];
                } 
                else 
                {
                    respuesta2 *= matriz[i][j];
                }
                
            }
           
        }
        int array[] = new int [3];
        respuesta = respuesta1 +respuesta2;
        if (matriz.length==matriz[0].length)
        {
            array[0] = 0; 
            array[1] = 0; 
            array[2] = 0; 
        }
        else 
        {
            array[0] = respuesta1;
            array[1]= respuesta2;
            array[2] = respuesta;
        }
        
        return array; 
    }//Fin del metodo numero magico 
    public static int numero(String cadena, String cadena2)
    {
        int numero; 
        
        int matriz[][] = new int [cadena2.length()][cadena.length()];
        
        for (int i = 0; i < matriz.length; i++) {
            char cadi = cadena2.charAt(i);
            for (int j = 0; j < matriz[0].length; j++) {
                char cadj = cadena.charAt(j);
                if (i == 0|| j == 0)
                {
                    matriz[i][j] = 0; 
                }
                else if (cadj == cadi)
                {
                    
                    matriz[i][j] = 1 + matriz[i-1][j-1];
                }
                else 
                {
                    matriz[i][j]= Math.max(matriz[i-1][j], matriz[i][j-1]);
                }
            }
        }
        
        JOptionPane.showMessageDialog(null, "La matriz es: \n"+imprimir(matriz), "SUBSECUENCIA", JOptionPane.INFORMATION_MESSAGE);
        
        numero = matriz[cadena2.length()-1][cadena.length()-1];
        return numero; 
    }
    
}
