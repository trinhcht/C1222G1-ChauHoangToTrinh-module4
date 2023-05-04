package ss3.ss3.service.impl;

import org.springframework.stereotype.Service;
import ss3.ss3.repository.impl.MailBoxRepository;
import ss3.ss3.service.IMailBoxService;

@Service
public class MailBoxService implements IMailBoxService {
    private final MailBoxRepository mailBoxRepository;

    public MailBoxService(MailBoxRepository mailBoxRepository) {
        this.mailBoxRepository = mailBoxRepository;
    }

    @Override
    public String[] languages() {
        return mailBoxRepository.languages();
    }

    @Override
    public Integer[] pageSizes() {
        return mailBoxRepository.pageSizes();
    }
}