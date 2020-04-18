package br.com.qintess.vilamix20.service;


import br.com.qintess.vilamix20.model.Evento;

public interface EventoService {
	
	void salvar(Evento evento);
	
	void editar(Evento evento);
	
	void excluir (Long id);
	
	Evento buscarPorId(Long id);
	
	
	
	
}
