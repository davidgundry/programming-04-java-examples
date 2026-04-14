class Solution {
  public static void main(String[] args) {
      Object[] array = new Object[1];
      try {
        Object a = array[1]; // Index out of bounds
      } catch (RuntimeException e) {
        System.out.println("This handles the exception");
      }
  }
}