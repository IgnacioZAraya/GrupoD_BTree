package BTree;

import Nodo.Nodo;

public class BTree {
    private int T;

    private Nodo raiz;

    public BTree(int t) {
        T = t;
        raiz = new Nodo(T);
        raiz.setnLlaves(0);
        raiz.setHoja(true);
    }

    private Nodo encontrarLlave(Nodo nd, int llave){
        int i = 0;
        if (nd == null){
            return nd;
        }

        for (i = 0; i<nd.getnLlaves(); i++){
            if (llave < nd.getLlave(i)){
                break;
            }
            if (llave == nd.getLlave(i)){
                return nd;
            }
        }

        if (nd.isHoja()){
            return null;
        }else{
            return encontrarLlave(nd.getHijo(i), llave);
        }
    }

    private void parteNodo(Nodo nd1, int pos, Nodo nd2){
        Nodo aux = new Nodo(T);
        aux.setHoja(nd2.isHoja());
        aux.setnLlaves(T-1);

        for (int j = 0; j<T-1; j++){
            aux.setLlave(0, nd2.getLlave(j + T));
        }

        if (!nd2.isHoja()){
            for (int j = 0; j < T; j++){
                aux.setHijo(j, nd2.getHijo(j+T));
            }
        }

        nd2.setnLlaves(T-1);

        for (int j = nd1.getnLlaves(); j>= pos +1; j--){
            nd1.setHijo(j+1, nd1.getHijo(j));
        }

        nd1.setHijo(pos+1, aux);

        for (int j = nd1.getnLlaves()-1; j>= pos; j--){
            nd1.setLlave(j+1, nd1.getLlave(j));
        }

        nd1.setLlave(pos, nd2.getLlave(T-1));
        nd1.setnLlaves(nd1.getnLlaves()+1);
    }

    public void insertarValor(final int llave){
        Nodo r = raiz;
        if (r.getnLlaves() == 2 * T - 1){
            Nodo aux = new Nodo(T);
            raiz = aux;
            aux.setHoja(false);
            aux.setnLlaves(0);
            aux.setHijo(0, r);
            parteNodo(aux, 0, r);
            insertarNodo(aux, llave);
        }else{
            insertarNodo(r, llave);
        }
    }

    final private void insertarNodo(Nodo nd, int llaves){
        if (nd.isHoja()){
            int i = 0;

            for (i = nd.getnLlaves()-1; i> 0 && llaves < nd.getLlave(i); i--){
                nd.setLlave(i+1, nd.getLlave(i));
            }

            nd.setLlave(i + 1, llaves);
            nd.setnLlaves(nd.getnLlaves()+1);
        }else{
            int i = 0;

            for (i = nd.getnLlaves() - 1; i >= 0 && llaves < nd.getLlave(i); i--) {
            }

            i++;
            Nodo temp = nd.getHijo(i);

            if (temp.getnLlaves() == 2*T-1){
                parteNodo(nd, i, temp);
                if (llaves > nd.getLlave(i)){
                    i++;
                }
            }

            insertarNodo(nd.getHijo(i), llaves);
        }
    }

    public void MostrarArbol(){
        MostrarArbol(raiz);
    }

    private void MostrarArbol(Nodo nd){
        assert (nd == null);
        for (int i = 0; i<nd.getnLlaves(); i++){
            System.out.printf(nd.getLlave(i)+"-");
        }
        if (!nd.isHoja()){
            for (int i = 0; i < nd.getnLlaves()+1; i++){
                MostrarArbol(nd.getHijo(i));
            }
        }
    }
}
