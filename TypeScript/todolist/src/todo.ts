function addTask(): void {
    const taskToAdd = document.getElementById('todoInput') as HTMLInputElement | null;
    if (taskToAdd) {
        if (taskToAdd.value === "") {
            alert("Please Enter Task Name");
        } else {
            addTaskToList(taskToAdd.value);
            taskToAdd.value = '';
        } 
    }
    else
    {
        //console.log("null");
        alert("no id exist");
    }
}

function addTaskToList(task: string): void {
    const todoList = document.getElementById('todoList') as HTMLTableSectionElement | null;


    if (todoList) {
        // Remove "No Task In Your List" message
        const noTaskRow = document.getElementById('noTaskRow');
        if (noTaskRow) {
            noTaskRow.remove();
        }

        // Create a new row for the task
        const taskRow = document.createElement('tr');

        // Task name cell
        const taskCell = document.createElement('td');
        taskCell.textContent = task;

        // Action cell with delete button
        const actionCell = document.createElement('td');
        const deleteTaskButton = document.createElement('button');
        deleteTaskButton.textContent = "Delete";

        // Delete task functionality
        deleteTaskButton.onclick = function () {
            todoList.removeChild(taskRow);

            // If no tasks remain, show "No Task In Your List" message
            if (!todoList.hasChildNodes()) {
                const noTaskRow = document.createElement('tr');
                noTaskRow.id = 'noTaskRow';
                const noTaskCell = document.createElement('td');
                noTaskCell.colSpan = 2;
                noTaskCell.textContent = "No Task In Your List";
                noTaskRow.appendChild(noTaskCell);
                todoList.appendChild(noTaskRow);
            }
        };

        // Append the button to the action cell
        actionCell.appendChild(deleteTaskButton);

        // Add the cells to the row
        taskRow.appendChild(taskCell);
        taskRow.appendChild(actionCell);

        // Add the row to the table
        todoList.appendChild(taskRow);
    }
}
