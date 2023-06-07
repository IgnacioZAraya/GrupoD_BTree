import BTree.BTree;

import java.util.Scanner;

public class Main {
    private static Scanner input = new Scanner(System.in);
    private static Scanner intInput = new Scanner(System.in);
    public static void main(String[] args) {
        BTree bArbol = new BTree(3);
        boolean seguir = true;
        while (seguir){
            System.out.print("Elija una opción"+"\n");
            System.out.print("1. Insertar un valor"+"\n");
            System.out.print("2. Mostrar árbol"+"\n");
            System.out.print("3. Eliminar un valor"+"\n");
            System.out.print("Presione cualquier otra tecla para salir"+"\n");

            String opcion = input.nextLine();

            switch (opcion){
                case "1":
                    System.out.printf("Escriba el valor: "+"\n");
                    int v = intInput.nextInt();
                    bArbol.insertarValor(v);
                    break;
                case "2":
                    System.out.printf("Arbol: "+"\n");
                    bArbol.MostrarArbol();
                    System.out.printf("Fin"+"\n");
                    break;
                case "3":

                    break;
                default:
                    seguir = false;
                    break;
            }
        }
    }
}