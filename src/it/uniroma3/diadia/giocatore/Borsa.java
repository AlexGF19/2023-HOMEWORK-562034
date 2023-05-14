package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatorAttrezzo;
import it.uniroma3.diadia.attrezzi.ComparatorNomeAttrezzo;


public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private HashMap<String, Attrezzo> attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<String, Attrezzo>();// speriamo bastino...
		this.numeroAttrezzi = 0;
	}

	
	
	public HashMap<String, Attrezzo> getAttrezzi() {
		return attrezzi;
	}


	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if(null==this.attrezzi.put(attrezzo.getNome(), attrezzo)) {
			this.numeroAttrezzi++;
			return true;
		}
		return false;
	}

	public int getPesoMax() {
		return pesoMax;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);
	}

	public int getPeso() {
		int peso = 0;
		ArrayList<Attrezzo> list = new ArrayList<Attrezzo>();
		list.addAll( this.attrezzi.values());
		Iterator<Attrezzo> it = list.iterator();
		while (it.hasNext())
			peso += ((Attrezzo) it.next()).getPeso();
		return peso;
	}

	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		this.numeroAttrezzi--;
		return this.attrezzi.remove(nomeAttrezzo);
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			ArrayList<Attrezzo> list = new ArrayList<Attrezzo>();
			list.addAll( this.getContenutoOrdinatoPerPeso());
			Iterator<Attrezzo> it = list.iterator();
			while (it.hasNext())
				s.append(((Attrezzo) it.next()).toString() + " ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}

	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		ArrayList<Attrezzo> l = new ArrayList<Attrezzo>(this.attrezzi.values());
		l.sort(new ComparatorAttrezzo());
		return l;
	}
	
	
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		TreeSet<Attrezzo> t = new TreeSet<Attrezzo>(new ComparatorAttrezzo());
		t.addAll(this.attrezzi.values());
		return t;
	}
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		TreeSet<Attrezzo> t = new TreeSet<Attrezzo>(new ComparatorNomeAttrezzo());
		t.addAll(this.attrezzi.values());
		return t;
	}
	
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		
		Collection<Attrezzo> l =  this.attrezzi.values();
		Map<Integer,Set<Attrezzo>> m = new HashMap<Integer,Set<Attrezzo>>();
		
		for(Attrezzo a : l) {
			if(m.containsKey(a.getPeso())) {
				m.get(a.getPeso()).add(a);
			}
			else {
				m.put(a.getPeso(), new TreeSet<Attrezzo>(new ComparatorNomeAttrezzo()));
				m.get(a.getPeso()).add(a);
			}
		}
		return m;
	}

}
