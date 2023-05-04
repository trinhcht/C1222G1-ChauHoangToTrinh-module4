package ss3.ss3.repository.impl;

import org.springframework.stereotype.Repository;
import ss3.ss3.repository.IMailBoxRepository;

@Repository
public class MailBoxRepository implements IMailBoxRepository {
    @Override
    public String[] languages() {
        return new String[]{"English", "Vietnamese", "Japanese", "Chinese"};
    }

    @Override
    public Integer[] pageSizes() {
        return new Integer[]{5, 10, 15, 25, 50, 100};
    }
}