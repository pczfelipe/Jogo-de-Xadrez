package Excessoes;

/**
 *
 * @author Felipe Augusto - 743530
 */
public class PecaFrente extends Exception{
    //Metodos Personalizados
    @Override
    public String toString() {
        return "Existe uma peca no meio do caminho do movimento!";
    }
}
