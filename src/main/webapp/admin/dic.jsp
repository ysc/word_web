<%-- 
    Document   : dic
    Created on : 2014-7-6, 17:28:12
    Author     : 杨尚川
--%>

<%@page import="org.apdplat.word.web.redis.ResourceChangeNotifier"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String dic = request.getParameter("dic");
    String action = request.getParameter("action");
    if(action != null && dic != null){
        if("add".equals(action.trim())){
            ResourceChangeNotifier.addDic(dic);
        }
        if("remove".equals(action.trim())){
            ResourceChangeNotifier.removeDic(dic);
        }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>分词词典管理</title>
    </head>
    <body>
        <h1>分词词典管理</h1>
    </body>
</html>
