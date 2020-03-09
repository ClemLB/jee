package fr.eseo.jee;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestAnnulerVisite.class, TestPayerVisite.class, TestReserverVisite.class, TestTrouverVisites.class })
public class AllTests {
	static final String DB_ADRESSE = "localhost";
	// static final String DB_ADRESSE = "192.168.4.197";
	static final String USERNAME = "java";
	static final String PASSWORD = "network";
}
