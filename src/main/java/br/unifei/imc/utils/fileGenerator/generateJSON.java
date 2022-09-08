package br.unifei.imc.utils.fileGenerator;

import br.unifei.imc.models.FileTypes;
import br.unifei.imc.models.People;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class generateJSON implements generateFile {

    @Override
    public void execute(List<People> people, FileTypes fileType) {
        List<JSONObject> listjsonPeople = List.of(
                new JSONObject(),
                new JSONObject(),
                new JSONObject()
        );
        for (int i = 0; i < people.size(); i++) {
            listjsonPeople.get(i).put("id", people.get(i).getId());
            listjsonPeople.get(i).put("nome", people.get(i).getName());
            listjsonPeople.get(i).put("idade", people.get(i).getAge());
        }
        try {
            File file = new File("pessoas.json");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(listjsonPeople.toString());
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("Erro ao gerar arquivo JSON" + e);
        }

    }
}

