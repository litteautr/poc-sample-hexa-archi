package fr.rli.alistairinhexagone.infra.adapter.driven;

import com.google.common.io.Resources;
import fr.rli.alistairinhexagone.domain.port.driven.IObtainPoem;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class PoetryDatabaseAdapter implements IObtainPoem {

    @Override
    public String giveMePoem() {
        return null;
    }
}
