package Excessoes;

/**
 *
 * @author Felipe Augusto - 743530
 */
public class ColunaDestino extends Exception{
    //Metodos Personalizados
    @Override
    public String toString() {
        return "Coluna de Destino informada é inválida!";
    }
}
