package problem1;

public interface Artist {

  //Artist receiveAward(String award); //this method being immutable is a rather non-idea design choicee,
  //make the method mutable.

  Boolean receiveAward(String award);
}
