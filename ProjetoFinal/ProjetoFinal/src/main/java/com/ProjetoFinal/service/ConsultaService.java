package com.ProjetoFinal.service;

import com.ProjetoFinal.dto.ConsultaDTO;
import com.ProjetoFinal.entities.Consulta;
import com.ProjetoFinal.entities.Dentista;
import com.ProjetoFinal.entities.Paciente;
import com.ProjetoFinal.entities.Usuario;
import com.ProjetoFinal.repositories.ConsultaRepository;
import com.ProjetoFinal.repositories.DentistaRepository;
import com.ProjetoFinal.repositories.PacienteRepository;
import com.ProjetoFinal.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class ConsultaService {

    @Autowired
    private ConsultaRepository ConsultaRepository;
    @Autowired
    private DentistaRepository DentistaRepository;
    @Autowired
    private PacienteRepository PacienteRepository;
    @Autowired
    private UsuarioRepository UsuarioRepository;

    public Consulta salvar(ConsultaDTO consultaDto) {
        Dentista dentista_id = DentistaRepository.getById(consultaDto.getIdDentista());
        Paciente paciente_id = PacienteRepository.getById(consultaDto.getIdPaciente());
        Usuario usuario_id = UsuarioRepository.getById(consultaDto.getIdUsuario());
        if((dentista_id!= null) && (paciente_id!= null) && (usuario_id!= null)){
            Consulta consulta = new Consulta(
                    dentista_id,
                    paciente_id,
                    usuario_id,
                    (new Date()));
            ConsultaRepository.save(consulta);
            return consulta;
        } else {
            throw new RuntimeException("Não existe Dentistas, Pacientes e Usuarios com esse ID");
        }

    }

    public List<Consulta> buscarTodos(){
        return ConsultaRepository.findAll();
    }

    public void excluir(Integer id){
        ConsultaRepository.deleteById(id);
    }

    public Optional<Consulta> buscar(Integer id){
        return ConsultaRepository.findById(id);
    }
}
