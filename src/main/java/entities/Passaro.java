package entities;

import services.CalculoCustoStrategy;

public class Passaro implements CalculoCustoStrategy {
    double precoBanho, precoTosa, precoConsulta;
    @Override
    public double calcularCusto(Pet pet, String nomeServico) {
        double prec = 0;
        switch (nomeServico){
            case "banho":
                precoBanho = 20;
                prec = precoBanho;
                return prec;
            case "consulta":
                precoConsulta = 20;
                prec = precoConsulta;
                return prec;
        }
        return prec;
    }
}