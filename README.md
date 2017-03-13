# Paths 

To begin, clone or download the project available on [github](https://github.com/tnachtergaele/rattrapage-scala).
It contains a skeleton to ease your work.

In Eclipse : Import as maven project

In IntelliJ : Right-click on pom.xml, then click on "Add as maven project"

## Introduction

In this project, you will search paths produced by an API such as Google Maps. 

This API provides **possible paths from origin to destination**, 
for example, all the possible ways to go to Paris from Marseille with all intermediate cities.

We suppose the API produce **only valid paths**, no need to implement any validation on the paths.

## The API

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
  public double length;
}
/** @opt all */
class Path {
  public List segments;
  public double length;
  public List stops;
}
/** @opt all */
class PathList {
  public List paths;
  public Path shortestPath;
}
)

## Use Cases

You are suggested to use [Scala test](http://www.scalatest.org/) to write your test cases.

Here is a suggested, step-by-step approach to implement all features :

### Compute the length of a segment

The length is the euclidean distance between origin and destination `sqrt[(x1 - x2)² + (y1 - y2)²]`.

Tests :

* The length of an empty segment
* The length of a vertical segment `Point(x, y1), Point(x, y2)`
* The length of a general segment `Point(x1, y1), Point(x2, y2)`

### Compute the length of a path

The length of a path is the sum of its segments lengths.
An empty path has a length equal to 0

Tests :

* The length of an empty path
* The length of a path containing a single segment
* The length of a path containing at least two segments

### Find the shortest path in a list of paths

As the shortest path may not be defined (if the list is empty for example),
this function returns an Option.

Tests :

* The shortest path of an empty list of paths
* The shortest path of a list of paths containing only empty paths
* The shortest path of a list of paths containing a single path
* The shortest path of a list of paths containing at least two paths

### Enumerate all stops in a path

Stops in a path are all intermediate points of a path.
They represent possible places where a driver could stop to pickup or deposit someone.

Tests :

* All stops of an empty path
* All stops of a path containing a single segment
* All stops of a path containing at least two segments

### Filter paths keeping only those which include a stop

Giving a list of paths and a point, produce the list of paths which have this intermediate stop.
 
Tests :
 
* Filter an empty list of paths
* Filter a list of paths containing paths which not include the stop
* Filter a list of paths containing at least one path which include the stop

### Filter paths keeping only those which include a given list of points

Giving a list of paths and a list of points,
return the list of paths which stops at all of these points.

Tests :
 
* Filter an empty list of paths
* Filter a list of paths which not stop at the full list of points
* Filter a list of paths containing at least one path which stops at all the points

### Find the best path

Find the shortest path in a list of paths, which stops at a given list of points.
As the shortest path may not exists (if the list is empty for example), this function returns an Option.

Tests :

* The best path of an empty list of paths
* The best path of a list of paths containing a single path which does not include the full list of points
* The best path of a list of paths containing a single path which includes the list of points
* The best path of a list of paths containing at least two paths which include the list of points

### Find all possible paths

Compute all possible paths between 2 points, given a list of Segments.
The segments of the path must have the correct direction, so be careful not to swap origin and destination.
We suppose that the list of Segments contains at least a path between the two points
(no need to return an Option here).


Tests :

Assuming you search the possible paths between `Point(x1,y1)` and `Point(x2,y2)`

* The possible paths with the list `[Segment(Point(x1, y1), Point(x2, y2))]`
* The possible paths with the list `[Segment(Point(x1, y1), Point(x3, y3)), Segment(Point(x3, y3), Point(x2, y2))]`
* The possible paths with a list containing several paths between `Point(x1, y1)` and `Point(x2, y2)`


## Grading

This project must be done with pure functional style.
This means that you have to program without mutable variables, assignments, loops, and other imperative control structures.

For each question, you get points based on :

* The implementation following rules above
* Passing tests associated to this implementation (described in each question)

Bonus points : up to 5 points if you added optional tests cases.

Questions | Points :

* Compute the length of a segment | 1
* Compute the length of a path | 2
* Find the shortest path in a list of paths | 2
* Enumerate all stops in a path | 2
* Filter paths keeping only those which include a stop | 3
* Filter paths keeping only those which include a given list of stops | 3
* Find the best path | 4
* Find all possible paths | 3