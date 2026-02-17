package com.DevHenrique.LiterAlura.service;

public interface IConverterDados {
    <T> T obterDados(String json, Class<T> classe);
}
