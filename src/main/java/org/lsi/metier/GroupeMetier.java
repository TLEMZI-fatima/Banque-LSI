package org.lsi.metier;

import java.util.List;

import org.lsi.entities.Groupe;

public interface GroupeMetier {

	public Groupe saveGroupe(Groupe g);
	public List<Groupe> listGroupe();
	
}

