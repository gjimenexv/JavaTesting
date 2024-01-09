public class Main {
    public static void main(String[] args) {
        int[] pares = llenarLista2();
        mostrarLista(pares);
    }
    /**
     * Llena array con ciclo while
     * @return array numerosPares
     */
    public static int[] llenarLista(){
        int[] numerosPares = new int[20];
        int contador = 0;
        int contadorLista = 0;

        while(contadorLista<20){
            if(contador ==0){
                contador++;
                continue;
            }if (contador%2==0){
                numerosPares[contadorLista] = contador;
                contadorLista++;
            }
            contador++;
        }
        return numerosPares;
    }

    /**
     * Llena array con ciclo for
     * @return array list numerosPares
     */
    public static int[] llenarLista2(){
        int[] numerosPares = new int[20];
        int contador = 0;
        for (int i = 0; i < numerosPares.length; i++){
            if(contador == 0){
                contador++;
                continue;
            }if(contador%2==0){
                numerosPares[i] =  contador;
            }else{
                i -= 1;
            }
            contador++;
        }
        return numerosPares;
    }

    /**
     * Imprime valores del array
     * @param  numerosPares
     */
    public static void mostrarLista(int[] lista) {
        for (int i = 0; i < lista.length ; i++) {
            System.out.println("i " + i + " valor :" +lista[i]);
        }
    }

}