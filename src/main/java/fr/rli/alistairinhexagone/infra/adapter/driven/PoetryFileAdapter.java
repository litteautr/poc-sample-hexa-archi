package fr.rli.alistairinhexagone.infra.adapter.driven;

import com.google.common.io.Resources;
import fr.rli.alistairinhexagone.domain.port.driven.IObtainPoem;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class PoetryFileAdapter implements IObtainPoem {

    private String filePath;

    public PoetryFileAdapter(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String giveMePoem() {
        URL url = Resources.getResource(filePath);
        try {
            return Resources.toString(url, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
