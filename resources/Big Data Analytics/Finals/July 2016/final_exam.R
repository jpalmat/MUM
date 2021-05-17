
library(igraph)
myGraph <- graph(
  c(
    "1","1",  "1","2",  "1","5",
    "2","3",  
    "3","2",  "3","4",
    "4","4",  "4","5",  "4", "1",
    "5","2",  "5","3"
  ), directed = TRUE)
plot(myGraph)
sort(page.rank(myGraph)$vector, decreasing = T)
