import { createClient } from '@supabase/supabase-js';
import * as readline from 'readline';
//import readline from "node:readline";


// Replace with your Supabase project details
const supabaseUrl = 'https://ekkjrwomdgvcjhlwnheg.supabase.co';
const supabaseKey = 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImVra2pyd29tZGd2Y2pobHduaGVnIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzIxODAwMTEsImV4cCI6MjA0Nzc1NjAxMX0.hQzQSbn8Dat7hg-sxDltq35xmqoyIKdyImPRLzu7NGU';

const supabase = createClient(supabaseUrl, supabaseKey);

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

// Function to handle the CRUD operations based on user input
async function handleCrudOperation(operation: string) {
  switch (operation) {
    case 'insert':
      await insertData();
      break;
    case 'showall':
      await getData();
      break;
    case 'update':
      await updateData();
      break;
    case 'delete':
      await deleteData();
      break;
    default:
      console.log('Invalid operation');
  }
}

// Insert operation
async function insertData() {
  rl.question('Enter name: ', (name) => {
    rl.question('Enter email: ', async (email) => {
      const { data, error } = await supabase
        .from('users')
        .insert([{ name: name, email: email }])
        .select('*');

      if (error) {
        console.error('Error inserting data:', error.message);
      } else {
        console.log('Inserted data:', data);
      }
      rl.close();
    });
  });
}

// Read (Select)
async function getData() {
  const { data, error } = await supabase
    .from('users')
    .select('*');

  if (error) {
    console.error('Error fetching data:', error.message);
  } else {
    console.log('Fetched data:', data);
  }
}

// Update
async function updateData() {
  rl.question('Enter email to update: ', (email) => {
    rl.question('Enter new name: ', async (newName) => {
      const { data, error } = await supabase
        .from('users')
        .update({ name: newName })
        .eq('email', email);

      if (error) {
        console.error('Error updating data:', error.message);
      } else {
        console.log('Updated data:', data);
      }
      rl.close();
    });
  });
}

// Delete
async function deleteData() {
  rl.question('Enter email to delete: ', async (email) => {
    const { data, error } = await supabase
      .from('users')
      .delete()
      .eq('email', email);

    if (error) {
      console.error('Error deleting data:', error.message);
    } else {
      console.log('Deleted data:', data);
    }
    rl.close();
  });
}

// Prompt for CRUD operation
rl.question('Enter operation (insert, select, update, delete): ', (operation) => {
  handleCrudOperation(operation);
});
