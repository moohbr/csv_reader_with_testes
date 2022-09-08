package br.unifei.imc.utils.fileGenerator;

import br.unifei.imc.models.FileTypes;
import br.unifei.imc.models.People;

import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;


public class generateCSV implements generateFile {
    final String file_location = "pessoas.csv";
    @Override
    public void execute(List<People> humanity, FileTypes fileType) {
        try{

            Writer writer = Files.newBufferedWriter(Paths.get(file_location));
            CSVWriter csvWriter = new CSVWriter(writer, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);

            List<String[]> data = new ArrayList<String[]>();

            data.add(new String[] {"Id", "Nome", "Idade"});
            for (People p : humanity){
                data.add(new String[] {String.valueOf(p.getId()), p.getName(), String.valueOf(p.getAge())});
            }
            csvWriter.writeAll(data);
            csvWriter.close();


        }catch (Exception e){
            System.out.println("Error while generating CSV file:\n" + e);
        }
    }
}

