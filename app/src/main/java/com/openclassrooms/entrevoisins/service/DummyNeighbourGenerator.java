package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DummyNeighbourGenerator {

    public static List<Neighbour> DUMMY_NEIGHBOURS = Arrays.asList(
            new Neighbour(1, "Caroline", "https://i.pravatar.cc/150?u=a042581f4e29026704d", "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14", "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot.."),
            new Neighbour(2, "Jack", "https://i.pravatar.cc/150?u=a042581f4e29026704e", "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14", "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot.."),
            new Neighbour(3, "Chloé", "https://i.pravatar.cc/150?u=a042581f4e29026704f", "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14", "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot.."),
            new Neighbour(4, "Vincent", "https://i.pravatar.cc/150?u=a042581f4e29026704a", "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14", "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot.."),
            new Neighbour(5, "Elodie", "https://i.pravatar.cc/150?u=a042581f4e29026704b", "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14", "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot.."),
            new Neighbour(6, "Sylvain", "https://i.pravatar.cc/150?u=a042581f4e29026704c", "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14", "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot.."),
            new Neighbour(7, "Laetitia", "https://i.pravatar.cc/150?u=a042581f4e29026703d", "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14", "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot.."),
            new Neighbour(8, "Dan", "https://i.pravatar.cc/150?u=a042581f4e29026703b", "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14", "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot.."),
            new Neighbour(9, "Joseph", "https://i.pravatar.cc/150?u=a042581f4e29026704d", "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14", "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot.."),
            new Neighbour(10, "Emma", "https://i.pravatar.cc/150?u=a042581f4e29026706d", "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14", "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot.."),
            new Neighbour(11, "Patrick", "https://i.pravatar.cc/150?u=a042581f4e29026702d", "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14", "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot.."),
            new Neighbour(12, "Ludovic", "https://i.pravatar.cc/150?u=a042581f3e39026702d", "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14", "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot.."),
            new Neighbour(13, "Filou", "https://drive.google.com/uc?id=1MekYfvo4II81g-pjUGzKwi3q_pNzWAA2", "Le Pré Saint-Gervais",
                    "+33 0 00 00 00 00", "Miaou miaou miaouuuuu, miaaaaaaaaaaaaaaaou, mia brrrrrrrr miaaaou, miaou "),
            new Neighbour(14, "Minh", "https://drive.google.com/uc?id=1L56YWGdVRBwnY5QRsk5m58oOtbcETpKR", "Maisons-Julittes",
                    "+33 0 77 11 14 10", "Coeur, ça veut dire aimer\n" + "Coeur, ça veut dire rêver\n" + "Coeur d'un petit garçon\n" + "Avec la vie pour horizon\n" + "\n" + "Coeur, ça veut dire sourire\n" + "Coeur, ça veut dire souffrir\n" + "Coeur, souvenirs d'enfance\n" + "D'école et de vacances\n" + "\n" + "Ce n'est qu'un petit garçon\n" + "Comme les autres\n" + "Qu'une histoire sans façon\n" + "Comme la nôtre\n" + "C'est l'histoire d'un bonheur\n" + "Tendre et fragile\n" + "Comme un beau bouquet de fleurs\n" + "Au mois d'avril\n" + "\n" + "Coeur, ça veut dire aimer\n" + "Coeur, ça veut dire rêver\n" + "Coeur d'un petit garçon\n" + "Avec la vie pour horizon\n" + "\n" + "Coeur, ça veut dire sourire\n" + "Coeur, ça veut dire souffrir\n" + "Coeur, souvenirs d'enfance\n" + "D'école et de vacances\n" + "\n" + "Ce n'est qu'un petit garçon\n" + "Comme les autres\n" + "Qu'une histoire sans façon\n" + "Comme la nôtre\n" + "C'est l'histoire d'un bonheur\n" + "Tendre et fragile\n" + "Comme un grand bouquet de fleurs\n" + "Au mois d'avril\n" + "\n" + "Coeur, ça veut dire aimer\n" + "Coeur, ça veut dire rêver\n" + "Coeur, un peu de bonheur\n" + "Au fond de votre coeur\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" + "Bonjour, fan de Jul, d'où mon surnom Choul, je souhaiterais échanger à son sujet, voire assister à ses concerts à plusieurs. J'aime aussi les pokémons, les super-héros (surtout Batman). J'aime aussi la Kpop, Iron Man et les chats, ainsi que les Pepe. Resident Evil 6 est le meilleur jeu d'horreur.")
    );

    static List<Neighbour> generateNeighbours() {
        return new ArrayList<>(DUMMY_NEIGHBOURS);
    }
}

