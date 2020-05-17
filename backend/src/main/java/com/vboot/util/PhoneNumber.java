package com.vboot.util;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class PhoneNumber {
  @NotEmpty
  private String value;

  @NotEmpty
  private String locale;
}