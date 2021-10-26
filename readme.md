## Stap 1: Het idee

```
Voor een cattery hebben we een systeem nodig waarin de administratie wordt bijgehouden. 

De cattery krijgt een paar keer in het jaar een nestje met kittens (verschillende rassen). Een administratief medewerker voegt de kittens toe aan het systeem. De kittens krijgen een stamboom, vaccinatie, worden ontwormd en er is een foto die worden geüpload door de administratief medewerker.	
									
Wanneer een klant een kitten(s) wilt hebben wordt deze klant door de administratief medewerker in het systeem gezet. Gegevens die worden opgeslagen zijn naam, adres, woonplaats, telefoonnummer, e-mail, kinderen en andere huisdieren.							
		
Wanneer een kitten(s) beschikbaar is dan wordt een klant gecontacteerd middels een email of via de telefoon door de backoffice (haalt deze informatie uit het systeem). De backoffice kan kittens en andere informatie toevoegen/verwijderen/updaten aan het systeem. 	

Daarnaast doet de backoffice afhandeling met de klant. Dat betekend wanneer de klant de kitten(s) komt ophalen, hij een door het systeem gegenereerde bon krijgt. De bon kan per kitten verschillen, dat ligt aan het 	ras dat de klant wilt, maar ook of de klant de kitten zelf eenmaal of tweemaal laat vaccineren, of dat hij dit door de cattery laat doen.
```

## Software

### Stap 1: Initializr

Ga naar de website <a href="https://start.spring.io" target="_blank">spring.io</a>. De volgende gegevens vul je in voor
het eerste Spring Boot project.

- Project: vink aan `Maven Project`
- Language: vink aan `Java`
- Spring Boot: vink aan `2.5.6` (laatste versie)
- Project Metadata: vul informatie in over jouw project
    - Group: `nl.danielle` (identifier van de ontwikkelaar)
    - Artifact: `cattery` (hoe heet je project)
    - Name: `cattery` (hoe heet je project)
    - Description: `Cattery project for Spring Boot`
    - Package name: maakt het systeem zelf aan
    - Packaging: vink aan `Jar`
    - Java: vink aan `11`

Klik op "add dependencies" en voeg `Spring Web`, `SpringData JPA` en `PostgreSQL Driver` toe.

Met "generate" wordt er een bestand in jouw download map gezet. Unzip het bestand en open het in Intellij.

Klik vervolgens rechtsonder in IntelliJ op `Load`.

Ga naar File > Project Structure en zet `Project SDK` op 11. Klik op apply.

### Stap 2: pom.xml

Wanneer je in `pom.xml` een foutmelding krijgt, zet je de `<parent>` versie op `<version>2.4.3</version>` en wanneer je een foutmelding in de `<plugin>` krijg zet je de versie er tussen op de volgende manier: `<version>${project.parent.version}</version>`.

De pom.xml heeft de volgende structuur:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.4.3</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>nl.danielle</groupId>
	<artifactId>cattery</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>cattery</name>
	<description>Cattery project for Spring Boot</description>
	<properties>
		<java.version>11</java.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<version>${project.parent.version}</version>
			</plugin>
		</plugins>
	</build>

</project>
```