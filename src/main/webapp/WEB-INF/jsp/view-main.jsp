<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>View Vocabulary</title>
        <link href="<c:url value="/css/main.css"/>" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="https://cdn.rawgit.com/Chalarangelo/mini.css/v3.0.1/dist/mini-default.min.css">
        <script
			  src="https://code.jquery.com/jquery-3.6.0.min.js"
			  integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
			  crossorigin="anonymous"></script>
    </head>
    <body>
        <nav>
            <a href="/vocab" id="list">List</a>
            <a href="/add">Add</a>
          </nav>

    

        <!--<h1>Vocab</h1>-->
        <div class="row listview">
                <c:forEach items="${vocab}" var="v">
                       
                        <div class="card small">
                            <p>
                                <span data-href="/mandarin/delete/${v.identifier}" class="delete">×</span>
                                <a href="/update/${v.identifier}" class="update">✏️</a>
                            </p>
                            <a href="/mandarin/${v.identifier}"> 
                            <h1>
                                <span class="simplified">${v.simplified}:</span><span class="traditional">${v.traditional}</span>
                            </h1>
                            <p class="pinyin">${v.pinyin}</p>
                        </a>
                            <p class="wiktionary">See entry on <a href="${v.wiktionary}">Wiktionary</a></p>
                        </div>
                    
                </c:forEach>
            </div>
    </body>
    <script src="<c:url value="/js/main.js"/>"></script>
</html>