package nl.danielle.cattery.service;

import nl.danielle.cattery.model.FileUpload;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileStorageService {
    FileUpload store(MultipartFile file, long id) throws IOException;
    FileUpload getFileById(String id);
}
