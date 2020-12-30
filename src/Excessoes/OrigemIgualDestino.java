package Excessoes;

/**
 *
 * @author Felipe Augusto - 743530
 */
public class OrigemIgualDestino extends Exception{
    //Metodos Personalizados
    @Override
    public String toString() {
        return "Coordenada de Destino é igual Coordenado de Origem!";
    }
}
