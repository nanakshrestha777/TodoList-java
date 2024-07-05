function addTask() {
    const taskInput = document.getElementById('taskInput');
    const taskDescription = taskInput.value;
    
    if (taskDescription.trim() !== '') {
        const taskList = document.getElementById('taskList');
        const li = document.createElement('li');
        
        li.innerHTML = `
            ${taskDescription}
            <button onclick="removeTask(this)">Remove</button>
            <button onclick="completeTask(this)">Complete</button>
        `;
        
        taskList.appendChild(li);
        taskInput.value = '';
    }
}

function removeTask(button) {
    const li = button.parentElement;
    li.remove();
}

function completeTask(button) {
    const li = button.parentElement;
    li.classList.toggle('completed');
}
