package pl.project.pack;

import org.springframework.stereotype.Service;

@Service
public class PackService {
    private PackRepository packRepository;

    public PackService(PackRepository packRepository) {
        this.packRepository = packRepository;
    }

    public Pack save(Pack pack) {
        return packRepository.save(pack);
    }
}
