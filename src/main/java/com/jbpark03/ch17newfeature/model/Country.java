package com.jbpark03.ch17newfeature.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Country {
  private String name;
  private String codeName;
}
