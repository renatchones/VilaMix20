package br.com.qintess.vilamix20.dao;

import br.com.qintess.vilamix20.model.Evento;

public interface EventoDao {
	
	public void save(Evento evento);

	
	public void update(Evento evento); 
		
	
	public void delete(Long id); 
	
	Evento findById(Long id);
	
	
	
	
}
