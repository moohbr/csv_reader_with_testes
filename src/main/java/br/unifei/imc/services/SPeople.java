package br.unifei.imc.services;

import br.unifei.imc.models.FileTypes;
import br.unifei.imc.models.People;
import br.unifei.imc.utils.fileGenerator.generateCSV;
import br.unifei.imc.utils.fileGenerator.generateFile;
import br.unifei.imc.utils.fileGenerator.generateJSON;

import java.util.List;

public class SPeople {
    private List<People> generatePeopleMap() {
        return List.of(
                new People(1,"Guts",39),
                new People(2,"Casca",30),
                new People(3,"Andreas",60)
        );
    }

    public void generateFile(FileTypes fileType) {
        List<People> humanity = generatePeopleMap();

        System.out.println(humanity);

        generateFile generator = switch (fileType) {
            case CSV -> new generateCSV();
            case JSON -> new generateJSON();
        };

        generator.execute(humanity, fileType);


    }

}
