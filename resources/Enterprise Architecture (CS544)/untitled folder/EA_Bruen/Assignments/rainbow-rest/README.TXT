
 REST Service version of MemberMVC from Lesson 11...
 
 USES DB entiremember
 
 Uses Spring MVC Controller for REST services.
 The client side is a separate project: 
 
 MemberMVC[Lesson 12]  
           OR 
 MemberMVCCloud[Lesson 13]  
 
 NOTE: JSON circular dependencies are necessary to resolve...otherwise - [java.lang.StackOverflowError]
      Uses @JsonIndentityInfo [ see slides]
 
 ALSO uses @JsonIdentityInfo to handle bidirectional...see slides
 

ALSO DispatcherServlet has  edu.mum.rest.HibernateAwareObjectMapper configured
It handles LAZY loading...for JSON payload
  
 