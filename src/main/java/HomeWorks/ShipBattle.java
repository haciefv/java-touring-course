package HomeWorks;

import java.util.*;

public class ShipBattle {

    public static boolean canLocate(int x, int y, int direction, int shipType, int[][] seaMap) {
        if (direction == 0) {
            if (y + shipType > 10) return false;
            for (int i = 0; i < shipType; i++) {
                if (seaMap[x][y + i] != 0) {
                    return false;
                }
            }
        } else {
            if (x + shipType > 10) return false;
            for (int i = 0; i < shipType; i++) {
                if (seaMap[x + i][y] != 0) {
                    return false;
                }
            }
        }
        for (int i = -1; i <= shipType; i++) {
            for (int j = -1; j <= 1; j++) {
                int newX = (direction == 0) ? x + i : x + j;
                int newY = (direction == 0) ? y + j : y + i;

                if (newX >= 0 && newX < 10 && newY >= 0 && newY < 10) {
                    if (seaMap[newX][newY] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] sea = new int[10][10];
        for (int[] row : sea) {
            Arrays.fill(row, 0);
        }

        int[] shipSizes = {5, 4, 3, 3, 2, 2};
        List<List<int[]>> allShipCoordinates = new ArrayList<>();

        for (int shipSize : shipSizes) {
            boolean placed = false;
            while (!placed) {
                int x = (int) (Math.random() * 10);
                int y = (int) (Math.random() * 10);
                int direction = (int) (Math.random() * 2);

                if (canLocate(x, y, direction, shipSize, sea)) {
                    List<int[]> shipCoordinates = new ArrayList<>();
                    if (direction == 0) {
                        for (int i = 0; i < shipSize; i++) {
                            sea[x][y + i] = 1;
                            shipCoordinates.add(new int[]{x, y + i});
                        }
                    } else {
                        for (int i = 0; i < shipSize; i++) {
                            sea[x + i][y] = 1;
                            shipCoordinates.add(new int[]{x + i, y});
                        }
                    }
                    allShipCoordinates.add(shipCoordinates);
                    placed = true;
                }
            }
        }




        List<List<int[]>> shootedCoordinates = new ArrayList<>();
        boolean winner = false;
        for (int z = 0; z < 25; z++) {
            boolean shooted = false;
            if (allShipCoordinates.isEmpty()) {
                System.out.println("You are Winner!");
                winner = true;
                break;
            }

            System.out.println("Enter [x,y] cell:");
            String cell = sc.nextLine().trim();
            int xCell = Integer.parseInt(String.valueOf(cell.charAt(1)));
            int yCell = Integer.parseInt(String.valueOf(cell.charAt(3))) ;
            int[] selectedCell = new int[]{xCell, yCell};

            shootedCoordinates.add(Collections.singletonList(new int[]{xCell, yCell}));


            for (int i = 0; i < allShipCoordinates.size(); i++) {
                List<int[]> allShipCoordinate = allShipCoordinates.get(i);

                List<int[]> cellsToRemove = new ArrayList<>();
                shooted = false;
                for (int k = 0; k < allShipCoordinate.size(); k++) {
                    int[] locatedCell = allShipCoordinate.get(k);
                    if (Arrays.equals(locatedCell, selectedCell)) {
                        shooted = true;
                        cellsToRemove.add(locatedCell);
                        allShipCoordinate.removeAll(cellsToRemove);


                        if (allShipCoordinate.isEmpty()) {
                            allShipCoordinates.remove(i);
                            i--;
                            System.out.println("Destroyed!");
                        } else {
                            System.out.println("Damaged!");
                        }
                    }
                }


            }
            if (!shooted) {
                System.out.println("Not Damaged");
            }
        }
        if (!winner) {
            System.out.println("Defeat!");

        }

    }

}
