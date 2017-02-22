# Functional Programming in Scala : Paths

## Functional Programming

In functional programming, we split our code between pure functional code and code with side effects (IO, modifying variables, ...).

This project must be done with pure functional style (no modification of variables => all can be declared final).

Functional programming means that we make heavy use of functions : they can be passed as arguments to other functions. See lessons for more explanations.

## TDD 

In this project, you have to write test cases to validate your implementation.
You can use the Test Driven Development method by following the three rules below :

1. You are not allowed to write any production code unless it is to make a failing unit test pass.
2. You are not allowed to write any more of a unit test than is sufficient to fail; and compilation failures are failures.
3. You are not allowed to write any more production code than is sufficient to pass the one failing unit test.

Source : [Uncle Bob](http://butunclebob.com/ArticleS.UncleBob.TheThreeRulesOfTdd)

### Suggestion for the process

Always start by testing the limit condition(s) : empty list, value of zero ... This allows you to focus on the usage of the method and its signature.

Then add a more relevant test to check the implementation.

### The project : search paths produced by an API

Imagine that some Google Maps like API provides **possible paths from origin to destination**.

Select the best one based on distance and intermediate stops.

Expect the API to produce **only valid paths**.

![Alt text](https://g.gravizo.com/g?
/** @opt all */
class Point {
  public int x;
  public int y;
}
/** @opt all */
class Segment {
  public Point origin;
  public Point destination;
  public double distance;
}
/** @opt all */
class Path {
  public List segments;
  public double distance;
  public List stops;
}
/** @opt all */
class PathList {
  public List paths;
  public Path shortestPath;
}
)

*We consider that a path is collection of segments, rather than a collection of points*

## TDD Steps

Suggestion of implementation steps, which should match with your tests (8 steps).

## Steps 1-3 : Find the shortest path 

Find the shortest path in a list of paths :

* Compute the distance of a segment
* Compute the distance of a path
* Find the shortest path in a list of paths

## Steps 4-6 : Filter paths 

Filter paths keeping only those which include a given list of stops :

* Enumerate all stops in a path
* Filter paths keeping only those which include a stop
* Filter paths keeping only those which include a given list of stops

## Step 7 : Find the best path

Find the shortest path in a list of paths, which includes a given list of stops

## Step 8 : Find all possible paths

Compute all possible paths between 2 points, given a list of Segments.

This step is more tricky because it involves recursion so it is usually only reachable for the fastest groups who already have experience with Functional Programming.
