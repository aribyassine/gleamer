package com.example.gleamer;

import com.example.gleamer.model.MetaData;
import com.example.gleamer.storage.StorageFileNotFoundException;
import com.example.gleamer.storage.StorageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@RequestMapping("/images")
public class FileUploadController {

    private final StorageService storageService;

    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping
    public MetaData handleFileUpload(@RequestParam("image") MultipartFile file) {
        return storageService.store(file);
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound() {
        return ResponseEntity.notFound().build();
    }

}
