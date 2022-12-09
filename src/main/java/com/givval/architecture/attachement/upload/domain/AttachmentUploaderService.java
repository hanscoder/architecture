package com.givval.architecture.attachement.upload.domain;

import com.givval.architecture.file.save.domain.FileSaver;
import com.givval.architecture.file.save.domain.SavedFile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class AttachmentUploaderService {
  private final FileSaver fileSaver;
  public SavedFile uploadAttachment(MultipartFile file) {
    return this.fileSaver.save(file);
  }
}
