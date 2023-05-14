package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class BorsaTest {
	private Borsa borsa;
	private Attrezzo attrezzo;
	private Attrezzo attrezzoPesante;
	
	@BeforeEach
	void setUp() {
		this.borsa=new Borsa();
		this.attrezzo=new Attrezzo("attrezzo", 0);
		this.attrezzoPesante=new Attrezzo("attrezzoPesante", 11);
	}

	@Test
	void testAddAttrezzo() {
		assertTrue(this.borsa.addAttrezzo(attrezzo));
	}
	
	@Test
	void testAddAttrezzoConPesoMaggioreDiPesoMax() {
		assertFalse(this.borsa.addAttrezzo(attrezzoPesante));
	}
	

	@Test
	void testGetAttrezzo() {
		this.borsa.addAttrezzo(attrezzo);
		this.borsa.addAttrezzo(attrezzoPesante);
		assertEquals(attrezzo,this.borsa.getAttrezzo("attrezzo"));
	}
	
	@Test
	void testGetAttrezzoNull() {
		assertNull(this.borsa.getAttrezzo("attrezzo"));
	}
	
	@Test
	void testIsEmpty() {
		assertTrue(this.borsa.isEmpty());
	}
	
	@Test
	void testIsEmptyFalse() {
		this.borsa.addAttrezzo(attrezzo);
		assertFalse(this.borsa.isEmpty());
	}

	
	@Test
	void testRemoveAttrezzo() {
		this.borsa.addAttrezzo(attrezzo);
		assertEquals("attrezzo", this.borsa.removeAttrezzo("attrezzo").getNome());
	}
	
	@Test
	void testRemoveAttrezzoNull() {
		assertNull(this.borsa.removeAttrezzo("attrezzo"));
	}
	
	@Test
	void testGetContenutoOrdinatoPerPeso() {
		Attrezzo a1 = new Attrezzo("battrezzo", 0);
		Attrezzo a2 = new Attrezzo("qwerty", 3);
		Attrezzo a3 = new Attrezzo("qwerty", 3);
		this.borsa.addAttrezzo(a1);
		this.borsa.addAttrezzo(a2);
		this.borsa.addAttrezzo(a3);// non dovrebbe inserirlo
		this.borsa.addAttrezzo(attrezzo);
		List<Attrezzo> l= this.borsa.getContenutoOrdinatoPerPeso();
		Iterator<Attrezzo> it = l.iterator();
		assertEquals(this.attrezzo, it.next());
		assertEquals(a1, it.next());
		assertEquals(a2, it.next());
		assertFalse(it.hasNext());
	}
	
	@Test
	void testgetSortedSetOrdinatoPerPeso() {
		Attrezzo a1 = new Attrezzo("a1", 1);
		Attrezzo a2 = new Attrezzo("a2", 1);
		this.borsa.addAttrezzo(a1);
		this.borsa.addAttrezzo(a2);
		this.borsa.addAttrezzo(this.attrezzo);
		Set<Attrezzo> s = this.borsa.getSortedSetOrdinatoPerPeso();
		Iterator<Attrezzo> it = s.iterator();
		assertEquals(this.attrezzo, it.next());
		assertEquals(a1, it.next());
		assertTrue(it.hasNext());
	}
	
	@Test
	void testGetContenutoOrdinatoPerNome() {
		Attrezzo a1 = new Attrezzo("battrezzo", 0);
		Attrezzo a2 = new Attrezzo("qwerty", 3);
		this.borsa.addAttrezzo(a2);
		this.borsa.addAttrezzo(this.attrezzo);
		this.borsa.addAttrezzo(a1);
		Set<Attrezzo> t =  this.borsa.getContenutoOrdinatoPerNome();
		Iterator<Attrezzo> it = t.iterator();
		assertEquals(this.attrezzo, it.next());
		assertEquals(a1, it.next());
		assertEquals(a2, it.next());
	}
	
	@Test
	void testGetContenutoRaggruppatoPerPeso() {
		Attrezzo a1 = new Attrezzo("battrezzo", 0);
		Attrezzo a2 = new Attrezzo("qwerty", 2);
		Attrezzo a3 = new Attrezzo("qwerty", 3);
		Attrezzo a4 = new Attrezzo("q", 1);
		this.borsa.addAttrezzo(a2);
		this.borsa.addAttrezzo(a1);
		this.borsa.addAttrezzo(a3);
		this.borsa.addAttrezzo(a4);
		this.borsa.addAttrezzo(this.attrezzo);
	
		Map<Integer,Set<Attrezzo>> m = this.borsa.getContenutoRaggruppatoPerPeso();
			
		assertTrue(m.containsKey(3));
		assertTrue(m.containsKey(0));
		assertTrue(m.containsKey(1));
		assertFalse(m.containsKey(5));
		assertTrue(m.get(0).contains(this.attrezzo));
		assertTrue(m.get(1).contains(a4));
		assertFalse(m.get(0).contains(a3));
	}
}
