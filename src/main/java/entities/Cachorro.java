package entities;

import lombok.*;
import services.CalculoCustoStrategy;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cachorro extends Pet implements CalculoCustoStrategy {
    double precoBanho, precoTosa, precoConsulta;

    @Override
    public double calcularCusto(Pet pet, String nomeServico) {
        double prec = 0;
        switch (nomeServico){
            case "banho":
                precoBanho = 30 + (pet.getPeso() * 5);
                prec = precoBanho;
                return prec;
            case "tosa":
                precoTosa = 40 + (pet.getPeso() * 7);
                prec = precoTosa;
                return prec;
            case "consulta":
                precoConsulta = 50;
                prec = precoConsulta;
                return prec;
        }
        return prec;
    }

}
