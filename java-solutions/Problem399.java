/*
    399. Evaluate Division

    You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i].
    Each Ai or Bi is a string that represents a single variable.
    You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
    Return the answers to all queries. If a single answer cannot be determined, return -1.0.
    Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.

    Example 1:
    Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
    Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
    Explanation: 
    Given: a / b = 2.0, b / c = 3.0
    queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
    return: [6.0, 0.5, -1.0, 1.0, -1.0 ]

    Example 2:
    Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
    Output: [3.75000,0.40000,5.00000,0.20000]

    Example 3:
    Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
    Output: [0.50000,2.00000,-1.00000,-1.00000]

    Constraints:
    1 <= equations.length <= 20
    equations[i].length == 2
    1 <= Ai.length, Bi.length <= 5
    values.length == equations.length
    0.0 < values[i] <= 20.0
    1 <= queries.length <= 20
    queries[i].length == 2
    1 <= Cj.length, Dj.length <= 5
    Ai, Bi, Cj, Dj consist of lower case English letters and digits.
 */

public class Problem399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // create graph given equations and values
            // verticies are the variables
            // directed edges are the result when performing the division
        // queries become a path search (dfs, can bfs be used)
            // if queries use unknown variable (return -1)
            // if queries use known variable (return x / y)
        // <startVertex, <startVertex, edgeWeight>
        Map<String, HashMap<String, Double>> graph = new HashMap<>();
        
        // build undirected graph
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String dividend = equation.get(0);
            String divisor = equation.get(1);
            double quotient = values[i];
            
            if (!graph.containsKey(dividend)) {
                graph.put(dividend, new HashMap<String, Double>());
            }
            
            if (!graph.containsKey(divisor)) {
                graph.put(divisor, new HashMap<String, Double>());
            }
            
            graph.get(dividend).put(divisor, quotient);
            graph.get(divisor).put(dividend, 1 / quotient);
        }
        
        // dfs to find path for each query
        double[] queryResult = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String dividend = queries.get(i).get(0);
            String divisor = queries.get(i).get(1);
            
            if (!graph.containsKey(dividend) || !graph.containsKey(divisor)) {
                // graph doesn't contain the vertex
                queryResult[i] = -1;
            } else if (dividend.equals(divisor)) {
                // "mimic" vertex self-loop
                queryResult[i] = 1;
            } else {
                // dfs to find path
                Set<String> visited = new HashSet<>();
                queryResult[i] = dfs(graph, dividend, divisor, visited, 1);
            }
        }
        
        return queryResult;
    }
    
    private double dfs(Map<String, HashMap<String, Double>> graph, String currVertex, String goalVertex, Set<String> visited, double cumProd) {
        // track visited
        visited.add(currVertex);
        
        // assume not found
        double total = -1.0;
        
        // iterative dfs to neighbors, remember to track result
        Map<String, Double> neighbors = graph.get(currVertex);
        if (neighbors.containsKey(goalVertex)) {
            total = cumProd * neighbors.get(goalVertex);
        } else {
            for (Map.Entry<String, Double> entry : neighbors.entrySet()) {
                String nextVertex = entry.getKey();
                if (visited.contains(nextVertex)) {
                    continue;
                }
                total = dfs(graph, nextVertex, goalVertex, visited, cumProd * entry.getValue());
                
                // found a path, break out to return solution
                if (total != -1.0) {
                    break;
                }
            }
        }
        
        // backtrack, not needed since a new visited set is created each dfs in main method
        // visited.remove(currVertex);
        return total;
    }
}