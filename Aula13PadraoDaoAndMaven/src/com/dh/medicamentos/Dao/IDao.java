package com.dh.medicamentos.Dao;

public interface IDao <T>{

    public T salvar(T t);
    public T buscar(Integer id);

}
