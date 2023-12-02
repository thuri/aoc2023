package net.lueckonline.aoc2023;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day2 {

  public static int part1(String input) {
    final var bag = new Bag(12, 13, 14);
    return Arrays.stream(input.split("\\n"))
        .map(Game::new)
        .reduce(
            0,
            (sum, game) -> sum + (bag.isValidGame(game) ? game.id : 0), 
            (sum1, sum2) -> sum1 + sum2
        );
  }

  public static Object part2(String input) {
    return Arrays.stream(input.split("\\n"))
        .map(Game::new)
        .map(Bag::new)
        .reduce(
            0,
            (sum, minBag) -> sum + minBag.power(), 
            (sum1, sum2) -> sum1 + sum2
        );
  }

  static class Bag {

    final Map<Color, Integer> map = new HashMap<>();

    Bag(int red, int green, int blue) {
      map.put(Color.red, red);
      map.put(Color.green, green);
      map.put(Color.blue, blue);
    }

    Bag(Game game) {
      game.pulls.stream()
      .forEach(cubeSet -> {
        this.map.compute(cubeSet.color, (color, current) -> Math.max(current == null ? 0 : current, cubeSet.count));
      });
    }

    int power() {
      return this.map.get(Color.red) * this.map.get(Color.green) * this.map.get(Color.blue);
    }

    boolean isValidGame(Game game) {
      return game.pulls.stream().allMatch(cubeSet -> map.get(cubeSet.color) >= cubeSet.count);
    }

  }

  static final class Game {
    int id;
    List<CubeSet> pulls;

    Game(String line) {
      final var gameAndDrawing = line.split(":", 2);

      this.id = Integer.valueOf(gameAndDrawing[0].replaceAll("Game ", ""));
      this.pulls = Arrays.stream(gameAndDrawing[1].split(";"))
          .flatMap(pull -> Arrays.stream(pull.split(",")))
          .map(CubeSet::new)
          .toList();
    }
  }

  static final class CubeSet {
    int count;
    Color color;

    CubeSet(String line) {
      final var parts = line.trim().split("\\s", 2);
      this.count = Integer.valueOf(parts[0]);
      this.color = Color.valueOf(parts[1]);
    }
  }

  static enum Color { red, green, blue }

}
