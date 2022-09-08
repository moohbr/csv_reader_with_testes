package br.unifei.imc;

import br.unifei.imc.models.FileTypes;
import br.unifei.imc.services.SPeople;

public class Main {
    public static void main(String[] args) {

        SPeople servicePeople = new SPeople();
        servicePeople.generateFile(FileTypes.CSV);
        servicePeople.generateFile(FileTypes.JSON);
    }
}