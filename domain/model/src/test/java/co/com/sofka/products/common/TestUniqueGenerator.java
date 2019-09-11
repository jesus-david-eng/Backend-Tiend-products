package co.com.sofka.products.common;


import co.com.sofka.products.UniqueIDGenerator;
import org.junit.Test;
import reactor.test.StepVerifier;

import static org.assertj.core.api.Assertions.assertThat;

public class TestUniqueGenerator {

    @Test
    public void uuid() {
        StepVerifier.create(UniqueIDGenerator.uuid())
                .assertNext(uuid -> assertThat(uuid).isNotEmpty())
                .verifyComplete();
    }
}
