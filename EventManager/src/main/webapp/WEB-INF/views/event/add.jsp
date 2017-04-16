<%@include file="../header.jsp" %>
<h1>Add Event</h1>
<form method="post">
    <div class="form-group">
        <label>Title</label>
        <input type="text" name="event_title" required="required" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Description</label>
        <textarea name="event_desc" required="required" class="form-control" style="height:150px"></textarea>
    </div>
    <div class="form-group">
        <label>Start Date</label>
        <input type="text" name="start_date" required="required" class="form-control"/>
    </div>
    <div class="form-group">
        <label>End Date</label>
        <input type="text" name="end_date" required="required" class="form-control"/>
    </div>
    <div class="checkbox">
        <label><input type="checkbox" name="invite"/> Invite</label>
    </div>
    <button type="submit" class="btn btn-success">Invite</button>
    <a href="${SITE_URL}/event" class="btn btn-danger">Cancel</a>
</form>
<%@include file="../footer.jsp" %>
