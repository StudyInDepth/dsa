# Binary Search
 
## Input: a sorted array, and an int key
## Output: the index of the key if present, -1 otherwise
## Complexity: log base 2 of n

## Steps:
* Maintaining two variables lo and hi such that the key is in a[lo...hi] if it is the array
* Entering a loop that tests middle entry in the interval at index mid
 * if the key is equal to a[mid] the return value is mid.
 * otherwise, the method cuts the interval size about in half
 * looking at the left half if the key is less than a[mid]
 * looking at the right half if the key is greater than a[mid]
 * the process terminates when the key is found or the interval is empty
 
## References
http://stackoverflow.com/questions/8185079/how-to-calculate-binary-search-complexity



 

 
