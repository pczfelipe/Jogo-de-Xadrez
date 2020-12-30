package Excessoes;

/**
 *
 * @author Felipe Augusto - 743530
 */
public class LinhaDestino extends Exception{
    //Metodos Personalizados
    @Override
    public String toString() {
        return "Linha de Destino informada é inválida!";
    }
}
