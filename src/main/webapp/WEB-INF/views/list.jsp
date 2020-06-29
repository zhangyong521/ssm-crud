<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>员工列表</title>
    <link href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/static/bootstrap/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h1>SSM-CRUD</h1>
        </div>
        <div class="col-md-12">
            <div class="col-md-4 col-md-offset-8">
                <button class="btn btn-primary">新增</button>
                <button class="btn btn-danger">删除</button>
            </div>
        </div>
        <div class="col-md-12">
            <table class="table table-hover">
                <tr>
                    <th>empId</th>
                    <th>empName</th>
                    <th>gender</th>
                    <th>email</th>
                    <th>deptName</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${pageInfo.list}" var="emps">
                    <tr>
                        <td>${emps.empId}</td>
                        <td>${emps.empName}</td>
                        <td>${emps.gender=="M"?"男":"女"}</td>
                        <td>${emps.email}</td>
                        <td>${emps.department.deptName}</td>
                        <td>
                            <button class="btn btn-primary btn-sm">
                                <span class="glyphicon glyphicon-pencil"></span>编辑

                            </button>
                            <button class="btn btn-danger btn-sm">
                                <span class="glyphicon glyphicon-trash"></span>删除
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <!--分页信息-->
    <div class="row">
        <div class="col-md-6">
            当前第${pageInfo.pageNum }页，总共${pageInfo.pages }页，一共${pageInfo.total }数据
        </div>
        <div class="col-md-6">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li><a href="${pageContext.request.contextPath}/emps?pn=1">首页</a></li>
                    <c:if test="${pageInfo.hasPreviousPage}">
                        <li>
                            <a href="${pageContext.request.contextPath}/emps?pn=${pageInfo.pageNum-1}" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>

                    <c:forEach items="${pageInfo.navigatepageNums}" var="page_Num">
                        <c:if test="${page_Num==pageInfo.pageNum}">
                            <li class="active"><a href="#">${page_Num}</a></li>
                        </c:if>
                        <c:if test="${page_Num!=pageInfo.pageNum}">
                            <li><a href="${pageContext.request.contextPath}/emps?pn=${page_Num}">${page_Num}</a></li>
                        </c:if>
                    </c:forEach>
                    <c:if test="${pageInfo.hasNextPage}">
                        <li>
                            <a href="${pageContext.request.contextPath}/emps?pn=${pageInfo.pageNum+1}" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>

                    <li><a href="${pageContext.request.contextPath}/emps?pn=${pageInfo.pages}">末页</a></li>
                </ul>
            </nav>
        </div>
    </div>
</div>
</body>
</html>
