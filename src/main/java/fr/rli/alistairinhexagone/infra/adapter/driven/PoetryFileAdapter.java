package fr.rli.alistairinhexagone.infra.adapter.driven;

import fr.rli.alistairinhexagone.domain.port.driven.IObtainPoem;

import java.io.*;

public class PoetryFileAdapter implements IObtainPoem {

    private String filePath;

    public PoetryFileAdapter(String filePath) throws IOException {

        this.filePath = filePath;
    }

    @Override
    public String giveMePoem() {
        File file = new File(filePath);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
