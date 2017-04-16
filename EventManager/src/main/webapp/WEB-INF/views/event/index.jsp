<%@include file="../header.jsp" %>
<h1>Events</h1>
<div class="pull-right">
    <p>
        <a href="${SITE_URL}/event/add" class="btn btn-primary">Add</a>
    </p>
</div>
    <div class="row">    
    <table class="table table-bordered table-hover table-striped">
        <tr>
            <th>Id</th>
            <th>Title</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Status</th>
            <th>Action</th>
        </tr>
        <c:forEach var="event" items="${requestScope.events}">
            <tr>
                <td>${event.id}</td>
                <td>${event.title}</td>
                <td>${event.startDate}</td>
                <td>${event.endDate}</td>
                <td>${event.status}</td>
                <td>Edit Delete</td>
            </tr>
        </c:forEach>
    </table>
</div>
<%@include file="../footer.jsp" %>
