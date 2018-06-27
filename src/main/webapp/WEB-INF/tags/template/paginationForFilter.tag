<%@attribute name="paginatedList" required="true" type="java.lang.Object"%>
<%@attribute name="page" required="true"%>
<%@attribute name="action" required="true"%>
<%@attribute name="formId" required="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>
window.onload = function() {		
	$('.pagination').jqPagination({
		page_string : 'Página {current_page} de {max_page}',
		link_string	: '<c:url value='${action}'/>?page={page_number}',		
		paged		: function(page) {
			var formId = '${formId}';
			var filterForm = $('#'+formId);
			if (formId != '') {
				var filterFormAction = $(filterForm).attr('action');
				$(filterForm).attr('action', filterFormAction + '?page=' + (page-1));
				$(filterForm).submit();
			} else {
				document.location.href = "<c:url value='${action}'/>?page=" + (page-1);
			}
		}
	});
};
</script>

<div class="ui pagination menu">
  <a class="item" data-action="first" href="#">
    <i class="angle double left blue icon"></i>
  </a>
  <a class="item" data-action="previous" href="#">
    <i class="angle left blue icon"></i>
  </a>
  <input type="text" style="border: none; padding-left: 15px" readonly="readonly" data-max-page="${paginatedList.getNumberOfPages()}" data-current-page="${page == null or empty page or page == 0 ? 1 : page+1}"/>
  <a class="item" style="border-left: 1px solid rgba(34,36,38,.13)" data-action="next" href="#">
    <i class="angle right blue icon"></i>
  </a>
  <a class="item" data-action="last" href="#">
    <i class="angle double right blue icon"></i>
  </a>
</div>
