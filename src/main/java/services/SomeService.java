package services;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import repositories.SomeRepo;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Service
public class SomeService {

    private final SomeRepo someRepo;

    public SomeService(SomeRepo someRepo) {
        this.someRepo = someRepo;
    }

    public SomeRepo getSomeRepo() {
        return someRepo;
    }
}
