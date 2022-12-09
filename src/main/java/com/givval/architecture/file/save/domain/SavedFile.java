package com.givval.architecture.file.save.domain;

import lombok.Value;

@Value(staticConstructor = "of")
public class SavedFile {
  String fileId;
}
