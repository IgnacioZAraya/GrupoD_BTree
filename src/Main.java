import BTree.BTree;

public class Main {
    public static void main(String[] args) {
        BTree bArbol = new BTree(3);
        bArbol.insertarValor(8);
        bArbol.insertarValor(9);
        bArbol.insertarValor(10);
        bArbol.insertarValor(11);
        bArbol.insertarValor(15);
        bArbol.insertarValor(20);
        bArbol.insertarValor(17);

        bArbol.MostrarArbol();
    }
}