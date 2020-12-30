package Excessoes;

/**
 *
 * @author Felipe Augusto - 743530
 */
public class OrigemVazia extends Exception{
    //Metodos Personalizados
    @Override
    public String toString() {
        return "Coordenada de Origem está sem peça (vazia)!";
    }
}
