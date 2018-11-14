package com.company.wars;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class Decryptor {

    /**
     *
     * @param galaxy
     * @return
     */
    private Integer decryptGalaxy(String galaxy) {
        return sumHexValue(galaxy);
    }

    /**
     *
     * @param hexValue
     * @return
     */
    private Integer sumHexValue(String hexValue){
        return hexValue
                .toLowerCase()
                .chars()
                .mapToObj(c -> Character.digit(c, 16))
                .mapToInt(Integer::intValue)
                .sum();
    }

    /**
     *
     * @param quadrant
     * @return
     */
    private Integer decryptQuadrant(String quadrant) {
        return maxHexValue(quadrant);
    }

    /**
     *
     * @param hexValue
     * @return
     */
    private Integer maxHexValue(String hexValue) {
        return hexValue
                .toLowerCase()
                .chars()
                .mapToObj(c -> Character.digit(c, 16))
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

    /**
     *
     * @param starSystem1
     * @param starSystem2
     * @return
     */
    private Integer decryptStarSystem(String starSystem1, String starSystem2) {
        if(maxHexValue(starSystem1) > maxHexValue(starSystem2)) {
            return sumHexValue(starSystem1);
        } else {
            return sumHexValue(starSystem2);
        }
    }

    /**
     *
     * @param planet
     * @return
     */
    private String decryptPlanet(String planet) {
        return planet
                .chars()
                .mapToObj(c -> (char) c)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    /**
     *
     * @param encryptedCoordinates
     * @return
     */
    public String decryptCoordinates(String encryptedCoordinates) {
        final String SEPARATOR = "-";
        String[] splitedCoordinates = encryptedCoordinates.split("-");
        return new StringBuilder()
                .append(decryptGalaxy(splitedCoordinates[0]))
                .append(SEPARATOR)
                .append(decryptQuadrant(splitedCoordinates[1]))
                .append(SEPARATOR)
                .append(decryptStarSystem(splitedCoordinates[2], splitedCoordinates[3]))
                .append(SEPARATOR)
                .append(decryptPlanet(splitedCoordinates[4]))
                .toString();
    }
}
