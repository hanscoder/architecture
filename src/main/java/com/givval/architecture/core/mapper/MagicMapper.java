package com.givval.architecture.core.mapper;

import com.googlecode.jmapper.JMapper;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MagicMapper<D, S> {
  private final Class<D> destinationClass;
  private final Class<S> sourceClass;

  public static <D, S> MagicMapper<D, S> mapperOf(
    Class<D> destinationClass, Class<S> sourceClass) {
    return new MagicMapper<>(destinationClass, sourceClass);
  }

  public D map(S sourceElement) {
    JMapper<D, S> mapper = new JMapper<>(destinationClass, sourceClass);
    return mapper.getDestination(sourceElement);
  }

  public List<D> mapToList(List<S> sourceElements) {
    JMapper<D, S> mapper = new JMapper<>(destinationClass, sourceClass);
    return sourceElements.stream().map(mapper::getDestination).collect(Collectors.toList());
  }
}
