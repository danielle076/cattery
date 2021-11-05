package nl.danielle.cattery.service;

import nl.danielle.cattery.exceptions.RecordNotFoundException;
import nl.danielle.cattery.model.FileUpload;
import nl.danielle.cattery.model.Kitten;
import nl.danielle.cattery.repository.FileUploadRepository;
import nl.danielle.cattery.repository.KittenRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileStorageServiceImpl implements FileStorageService {

    final FileUploadRepository fileUploadRepository;

    final KittenRepository kittenRepository;

    public FileStorageServiceImpl(FileUploadRepository fileUploadRepository, KittenRepository kittenRepository) {
        this.fileUploadRepository = fileUploadRepository;
        this.kittenRepository = kittenRepository;
    }

    @Override
    public FileUpload store(MultipartFile file, long id) throws IOException {

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        FileUpload fileUpload = new FileUpload(fileName, file.getContentType(), file.getBytes());

        Kitten kitten = null;
        if (kittenRepository.existsById(id)) {
            kitten = kittenRepository.findById(id).orElse(null);
        }
        fileUpload.setKitten(kitten);

        return fileUploadRepository.save(fileUpload);
    }

    @Override
    public FileUpload getFileById(String id) {

        if (!fileUploadRepository.existsById(id)) {
            throw new RecordNotFoundException();
        }
        return fileUploadRepository.findById(id).get();
    }
}
