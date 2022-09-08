package br.unifei.imc.utils.fileGenerator;

import br.unifei.imc.models.FileTypes;
import br.unifei.imc.models.People;

import java.util.List;


public interface generateFile {
    void execute(List<People> people, FileTypes fileType);
}
