package spacetravel.test;

import spacetravel.entity.Client;
import spacetravel.entity.Planet;
import spacetravel.CRUDservice.ClientCrudService;
import spacetravel.CRUDservice.PlanetCrudService;

public class Test {
    public static void main(String[] args) {
        ClientCrudService clientService = new ClientCrudService();
        PlanetCrudService planetService = new PlanetCrudService();

        Client client = new Client();
        client.setName("Alice");
        clientService.saveClient(client);

        Planet planet = new Planet();
        planet.setId("MARS");
        planet.setName("Mars");
        planetService.savePlanet(planet);

        clientService.deleteClient(client.getId());

        planetService.deletePlanet(planet.getId());
    }
}