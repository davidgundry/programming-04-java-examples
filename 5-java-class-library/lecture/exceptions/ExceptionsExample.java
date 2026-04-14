class AnimalException extends Exception {}

class CatException extends AnimalException {}

class DogException extends AnimalException {}

class ExceptionsExample {
  public static void main(String[] args) {

    try {
      throw new CatException();
    //} catch (DogException e) { // This line is not permitted as DogException cannot be thrown
    } catch (AnimalException e) {
      System.out.println("This handles the exception");
    } catch (Exception e) {
      System.out.println("This will never run");
    }
  }
}