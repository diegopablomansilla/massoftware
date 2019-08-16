//function selectItemFromServer(item) {
//	const grid = document.querySelector('vaadin-grid');
//	grid.selectedItems = [ item ];	
//}

function addKeyListenersCustom(element) {

	// https://www.webcomponents.org/element/vaadin/vaadin-grid/elements/vaadin-grid#method-getEventContext

	const grid = document.querySelector('vaadin-grid');

	const elemento = element;

	grid.addEventListener('keyup', // keydown keyup keypress

			function(e) {

				const item = grid.getEventContext(e).item;

//				alert(e.key)

				if (e.key === 'Enter') {

					elemento.$server.enterListenerForClient(item);

					grid.selectedItems = grid.selectedItems[0] === item ? []
							: [ item ];

				} else if (e.key === 'ArrowDown') {

					elemento.$server.arrowDownListenerForClient(item);

					grid.selectedItems = grid.selectedItems[0] === item ? []
							: [ item ];

				} else if (e.key === 'ArrowUp') {

					elemento.$server.arrowUpListenerForClient(item);

					grid.selectedItems = grid.selectedItems[0] === item ? []
							: [ item ];

				} else if (e.key === 'PageDown') {

					elemento.$server.pageDownListenerForClient(item);

					grid.selectedItems = grid.selectedItems[0] === item ? []
							: [ item ];

				} else if (e.key === 'PageUp') {

					elemento.$server.pageUpListenerForClient(item);

					grid.selectedItems = grid.selectedItems[0] === item ? []
							: [ item ];

				} else if (e.ctrlKey === true && e.key === 'End') {

					elemento.$server.ctrlKeyEndListenerForClient(item);

					grid.selectedItems = grid.selectedItems[0] === item ? []
							: [ item ];

				} else if (e.ctrlKey === true && e.key === 'Home') {

					elemento.$server.ctrlKeyHomeListenerForClient(item);

					grid.selectedItems = grid.selectedItems[0] === item ? []
							: [ item ];

				} else if (e.key === 'Delete') {

					elemento.$server.deleteListenerForClient(item);

					grid.selectedItems = grid.selectedItems[0] === item ? []
							: [ item ];

				}

				// console.log(e.key);
				// if (e.key === 'Enter') {
				// //alert(item.id);
				// }

			});

	// grid.addEventListener('active-item-changed', function(event) {
	// const item = event.detail.value;
	// grid.selectedItems = item ? [item] : [];
	// alert(item);
	// });
};