# Paths 

To begin, clone or download the project available on [github](https://github.com/tnachtergaele/rattrapage-scala).
It contains a skeleton to ease your works.

In Eclipse : Import as maven project

In IntelliJ : Right-click on pom.xml, then click on "Add as maven project"

## Introduction

In this project, you will search paths produced by an API such as Google Maps. 

This API provides **possible paths from origin to destination**, 
for example, all the possible ways to go to Paris from Marseille with all intermediate cities.

We suppose the API produce **only valid paths**.

## Grading

This project must be done with pure functional style. 
This means that you have to program without mutable variables, assignments, loops, and other imperative control structures.

For each question, you award points based on :
 
* The implementation following rules above
* Tests associated to this implementation (described in each question) 

Bonus points : up to 5 points if you added optional tests cases.

Questions | Points : 

* Compute the distance of a segment | 1
* Compute the distance of a path | 2
* Find the shortest path in a list of paths | 2
* Enumerate all stops in a path | 2
* Filter paths keeping only those which include a stop | 3
* Filter paths keeping only those which include a given list of stops | 3
* Find the best path | 4
* Find all possible paths | 3

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

## Tests

We recommend to use [Scala test](http://www.scalatest.org/) to write your test cases.

## Compute the distance of a segment

The euclidean distance between two points (origin and destination).

Tests :

* The distance of an empty segment
* The distance of a segment `Point(x,y1),Point(x,y2)`
* The distance of a segment `Point(x1,y1),Point(x2,y2)`

## Compute the distance of a path

The distance of a path is the sum of these segments distance.
An empty path has a distance equal to 0

Tests :

* The distance of an empty path
* The distance of a path containing a single segment
* The distance of a path containing at least two segments

## Find the shortest path in a list of paths

As the shortest path may not exists (if the list is empty for example), this function gives an Option as result.

Tests :

* The shortest path of an empty list of paths
* The shortest path of a list of paths containing only empty paths
* The shortest path of a list of paths containing a single path
* The shortest path of a list of paths containing at least two paths

## Enumerate all stops in a path

Stops in a path is all intermediate points of a path : all points excluding the beginning and the end of the path.
We admit that each intermediate points are unique in a path, so this function return a Set of points.

Tests :

* All stops of an empty path
* All stops of a path containing a single segment
* All stops of a path containing at least two segments

## Filter paths keeping only those which include a stop

Giving a list of paths and a stop, produce the list of those which include this stop
 
 Tests :
 
* Filter an empty list of paths
* Filter a list of paths containing paths which not include the stop
* Filter a list of paths containing at least one path which include the stop

## Filter paths keeping only those which include a given list of stops

Giving a list of paths and a list of stops, produce the list of those which include these stops

Tests :
 
* Filter an empty list of paths
* Filter a list of paths containing paths which not include the full list of stops
* Filter a list of paths containing at least one path which include the list of stops

## Find the best path

Find the shortest path in a list of paths, which includes a given list of stops.
As the shortest path may not exists (if the list is empty for example), this function gives an Option as result.

Tests :

* The best path of an empty list of paths
* The best path of a list of paths containing a single path which not include the full list of stops
* The best path of a list of paths containing a single path which include the list of stops
* The best path of a list of paths containing at least two paths which include the list of stops

## Find all possible paths

Compute all possible paths between 2 points, given a list of Segments.
The segments of the path must have the correct orientation, so be careful to origin and destination.
We suppose that the list of Segments contains at least a path between the two points.

Tests :

Assuming you search the possible paths between `Point(x1,y1)` and `Point(x2,y2)`

* The possible paths with the list `[Segment(Point(x1,y1),Point(x2,y2))]`
* The possible paths with the list `[Segment(Point(x1,y1),Point(x3,y3)), Segment(Point(x3,y3),Point(x2,y2))]`
* The possible paths with a list containing several paths between `Point(x1,y1)` and `Point(x2,y2)`