package nl.danielle.cattery.repository;

import nl.danielle.cattery.model.FileUpload;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileUploadRepository extends JpaRepository<FileUpload, String> {

}