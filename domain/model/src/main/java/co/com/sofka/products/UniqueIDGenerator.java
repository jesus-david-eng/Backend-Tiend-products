package co.com.sofka.products;


import reactor.core.publisher.Mono;

;
import java.util.UUID;

import static reactor.core.publisher.Mono.fromSupplier;

public class UniqueIDGenerator {

    public static Mono<String> uuid(){
        return fromSupplier(() -> UUID.randomUUID().toString());
    }

    /*
    public static Flux<String> uuids(){
        return Flux.generate(sink -> sink.next(UUID.randomUUID().toString()));
    }

    public static Mono<Date> now(){
        return fromSupplier(Date::new);
    }
     */

}
