<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Add Vocabulary</title>
        <link href="<c:url value="/css/main.css"/>" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="https://cdn.rawgit.com/Chalarangelo/mini.css/v3.0.1/dist/mini-default.min.css">
    </head>
    <body>
        <nav>
            <a href="/vocab">List</a>
            <a href="/add">Add</a>
          </nav>
    
        <c:url var="update_url" value="/update"/>
        <form:form action="${update_url}" method="put" modelAttribute="vocab">
            <fieldset>  
                <legend>Update Vokabel</legend>
                <div class="row responsive-label"> 
                    <div class="col-sm-12 col-md-3">
                        <form:label for="identifier" path="identifier">identifier: </form:label> 
                    </div>
                    <div class="col-sm-12 col-md">
                        <form:input type="text" path="identifier" placeholder="1"/>
                    </div>
                </div>
                <div class="row responsive-label"> 
                    <div class="col-sm-12 col-md-3">
                        <form:label for="simplified" path="simplified">simplified: </form:label> 
                    </div>
                    <div class="col-sm-12 col-md">
                        <form:input type="text" path="simplified" placeholder="爱"/>
                    </div>
                </div>
                <div class="row responsive-label"> 
                    <div class="col-sm-12 col-md-3">
                        <form:label path="traditional">traditional: </form:label> 
                    </div>
                    <div class="col-sm-12 col-md">
                        <form:input type="text" path="traditional" placeholder="愛"/>
                    </div>
                </div>
                <div class="row responsive-label"> 
                    <div class="col-sm-12 col-md-3">
                        <form:label path="pinyin">pinyin: </form:label> 
                    </div>
                    <div class="col-sm-12 col-md">
                        <form:input type="text" path="pinyin" placeholder="ài"/>
                    </div>
                </div>
                <div class="row responsive-label"> 
                    <div class="col-sm-12 col-md-3">
                        <form:label path="translations">translations: </form:label>
                    </div> 
                    <div class="col-sm-12 col-md">
                        <form:input type="text" path="translations" placeholder="lieben; die Liebe"/>
                    </div>
                </div>
                <div class="row responsive-label"> 
                    <div class="col-sm-12 col-md-3">
                        <form:label path="wiktionary">wiktionary: </form:label> 
                    </div>
                    <div class="col-sm-12 col-md">
                        <form:input type="text" path="wiktionary" placeholder="https://en.wiktionary.org/wiki/%E6%84%9B#Chinese"/>
                    </div>
                </div>
                    <input type="submit" value="submit"/>
                </div>
            </fieldset>  
        </form:form>
    </body>
</html>