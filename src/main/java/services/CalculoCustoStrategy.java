package services;

import entities.Pet;

public interface CalculoCustoStrategy {
   double calcularCusto(Pet pet, String nomeServico);
}
