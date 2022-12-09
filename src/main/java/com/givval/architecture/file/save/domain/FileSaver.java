package com.givval.architecture.file.save.domain;

import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileSaver {

  public SavedFile save(MultipartFile file) {
    // do a lot but actually nothing
    return SavedFile.of(UUID.randomUUID().toString());
  }
}
