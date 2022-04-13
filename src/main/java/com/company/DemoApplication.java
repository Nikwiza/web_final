package com.company;

import com.company.entity.Korisnik;
import com.company.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private KorisnikRepository korisnikRepository;

	@Override
	public void run(String... args) throws Exception {
		Korisnik korisnik = new Korisnik();
		korisnik.setKorisnicko_ime("Nikwiza");
		korisnik.setIme("Nikola");
		korisnik.setPrezime("Kerleta");
		korisnik.setLozinka("lozinkus");

		this.korisnikRepository.save(korisnik);
		List<Korisnik> korisnici = this.korisnikRepository.findAll();
		for(Korisnik k : korisnici){
			System.out.println(k);
		}


	}

	public static void main(String[] args) {SpringApplication.run(DemoApplication.class, args);}
}
