package com.givval.architecture.attachement.upload.rest;

import com.googlecode.jmapper.annotations.JMap;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UploadedAttachmentRto {
  @NotNull
  @NotBlank
  @JMap
  String fileId;
}
