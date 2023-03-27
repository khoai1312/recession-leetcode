package main;

import java.util.*;

class CourseDetails {
    public int inDegrees = 0;
    public List<Integer> neighbors = new LinkedList<>();
}

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) {
            return true;
        }

        // create a graph to store a course -> course details
        Map<Integer, CourseDetails> graph = new HashMap<>();

        // build the graph
        for (int[] prerequisite : prerequisites) {
            CourseDetails courseToTake = addCourseToGraph(graph, prerequisite[0]);
            courseToTake.inDegrees += 1;

            CourseDetails prerequisiteToTake = addCourseToGraph(graph, prerequisite[1]);
            prerequisiteToTake.neighbors.add(prerequisite[0]);
        }

        // start topological sorting

        // build a list of courses with no prerequisites

        /*
        We could use different types of containers, such as Queue, Stack or Set,
        to keep track of the nodes that have no incoming dependency, i.e. indegree = 0.
        Depending on the type of container, the resulting topological order would be different,
        though they are all valid.
        */
        LinkedList<Integer> coursesWithNoPrerequisites = new LinkedList<>();
        for (Map.Entry<Integer, CourseDetails> entry : graph.entrySet()) {
            CourseDetails currentCourse = entry.getValue();
            if (currentCourse.inDegrees == 0) {
                coursesWithNoPrerequisites.add(entry.getKey());
            }
        }

        // loop through this list of courses with no prerequisites
        int numberOfEdgesRemoved = 0;
        while (!coursesWithNoPrerequisites.isEmpty()) {

            int currentCourse = coursesWithNoPrerequisites.remove();
            List<Integer> dependentCourses = graph.get(currentCourse).neighbors;
            
            /* once the course is processed :
            - remove all of its outgoing edge
            - decrease the in-degree of its dependents by 1
            - if the dependent now has in-degree = 0, add it to the list of courses with no pre-requisites to process next
            */
            for (int dependentCourse : dependentCourses) {
                CourseDetails dependentCourseDetails = graph.get(dependentCourse);
                numberOfEdgesRemoved++;
                dependentCourseDetails.inDegrees -= 1;
                if (dependentCourseDetails.inDegrees == 0) {
                    coursesWithNoPrerequisites.add(dependentCourse);
                }

            }
        }

        // at the end, check if all the dependencies have been resolved
        // if there're still edges, it means there's a cycle somewhere
        return numberOfEdgesRemoved == prerequisites.length;
    }

    public CourseDetails addCourseToGraph(Map<Integer, CourseDetails> graph, int courseToAdd) {
        if (graph.containsKey(courseToAdd)) {
            return graph.get(courseToAdd);
        }
        CourseDetails courseDetails = new CourseDetails();
        graph.put(courseToAdd, courseDetails);
        return courseDetails;
    }
}