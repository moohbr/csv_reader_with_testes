package br.unifei.imc;

import br.unifei.imc.exceptions.OpcaoErradaException;
import br.unifei.imc.models.FileTypes;
import br.unifei.imc.services.SPeople;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestPessoaService {


    static SPeople service;

    @BeforeClass
    public static void setup(){
        service = new SPeople();
        service.generateFile(FileTypes.CSV);
        service.generateFile(FileTypes.JSON);
    }

    @Test
    public void testCriarCSV(){
        Assert.assertTrue(Files.exists(Path.of("pessoas.csv")));
    }

    @Test
    public void testeValidaCSV(){
        try {
            String arquivo = Files.readString(Path.of("pessoas.csv"));
            Assert.assertEquals(ConstFileInfo.CSV, arquivo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testeValidaJSON(){
        try {
            String arquivo = Files.readString(Path.of("pessoas.json"));
            Assert.assertEquals(ConstFileInfo.JSON, arquivo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testCriarJSON(){
        Assert.assertTrue(Files.exists(Path.of("pessoas.json")));
    }

    @Test(expected = OpcaoErradaException.class)
    public void testeOpcaoErrada(){
        service.generateFile(null);
    }

    @AfterClass
    public static void cleanup() throws IOException {
        Files.deleteIfExists(Path.of("pessoas.csv"));
        Files.deleteIfExists(Path.of("pessoas.json"));
    }
}