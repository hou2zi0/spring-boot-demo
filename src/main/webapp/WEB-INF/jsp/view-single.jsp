<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Singleview Vocabulary</title>
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
        
        <div class="card singleview">
            <h1 title="Click the glyphs to change the font.">
                <span class="simplified" id="KuaiLe">${vocab.simplified}</span>
            </h1>
            <h1 title="Click the glyphs to change the font.">
                <span class="traditional" id="NotoSansTC">${vocab.traditional}</span>
            </h1>
            <p class="pinyin">${vocab.pinyin}</p>
            <p class="translations">${vocab.translations}</p>
            <p class="wiktionary">See entry on <a href="${vocab.wiktionary}">Wiktionary</a></p>
        </div>
            </div>
    </body>
    <script src="<c:url value="/js/switchFont.js"/>"></script>
</html>