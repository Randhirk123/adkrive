
$(document).ready(function() {
   let dataTable = $('#filtertable').DataTable({
        "pageLength":10,
		"scrollX": true,
        'aoColumnDefs':[{
            'bSortable':false,
            'aTargets':['nosort'],
        }],

		'columnDefs' : [     // see https://datatables.net/reference/option/columns.searchable
					    { 
					       'searchable': false, 
					       'targets': [0,2,3,5,6,7,8] 
					    },
					],
			
        "aoColumns":[
            null,
            null,
            null,
            null,
            null,
            null,
            null,
			null,
			null,
			null
			
        ],
        "bLengthChange":false,
        "dom":'<"top">ct<"top"p><"clear">',
    });
    $("#filterbox").keyup(function(){
        dataTable.search(this.value).draw();
    });


 		
});

