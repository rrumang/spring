<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

name : <input type="text" id="name" readonly value="${userVo.name }"/><br>
alias : <input type="text" id="alias" readonly value="${userVo.alias }"/><br>
birth : <input type="text" id="birth" readonly value="<fmt:formatDate value="${userVo.birth}" pattern="yyyy-MM-dd"/>"/>