package com.givval.architecture.attachement.upload.rest;

import static com.givval.architecture.core.mapper.MagicMapper.mapperOf;

import com.givval.architecture.attachement.upload.domain.AttachmentUploaderService;
import com.givval.architecture.auth.login.domain.Credentials;
import com.givval.architecture.auth.login.rest.CredentialsRto;
import com.givval.architecture.core.mapper.MagicMapper;
import com.givval.architecture.file.save.domain.SavedFile;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Tag(name = "Attachment")
@RestController()
@RequiredArgsConstructor
@RequestMapping(value = "/attachment", produces = MediaType.APPLICATION_JSON_VALUE)
public class AttachmentController {

  private final MagicMapper<UploadedAttachmentRto, SavedFile> mapper = mapperOf(UploadedAttachmentRto.class, SavedFile.class);

  private final AttachmentUploaderService attachmentUploaderService;

  @PostMapping(
    value = "upload",
    consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<UploadedAttachmentRto> uploadAttachment(
    @RequestPart("file") MultipartFile file) {
    var result = this.attachmentUploaderService.uploadAttachment(file);

    return ResponseEntity.ok(mapper.map(result));
  }

}
