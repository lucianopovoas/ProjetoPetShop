package entities;

import services.CalculoCustoStrategy;

public class Gato extends Pet implements CalculoCustoStrategy {
    double precoBanho, precoTosa, precoConsulta;

    @Override
    public double calcularCusto(Pet pet, String nomeServico) {
        double prec = 0;
        switch (nomeServico){
            case "banho":
                precoBanho = 25;
                prec = precoBanho;
                return prec;
            case "consulta":
                precoConsulta = 45;
                prec = precoConsulta;
                return prec;
        }
        return prec;
    }
}
