import { createClient } from '@supabase/supabase-js';
import * as readline from 'readline'
 

const supabaseUrl = 'https://ekkjrwomdgvcjhlwnheg.supabase.co';
const supabaseKey = 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImVra2pyd29tZGd2Y2pobHduaGVnIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzIxODAwMTEsImV4cCI6MjA0Nzc1NjAxMX0.hQzQSbn8Dat7hg-sxDltq35xmqoyIKdyImPRLzu7NGU';

 const supabase=createClient(supabaseUrl,supabaseKey);
 
 interface Student{
    stuid:number,
    stuname:string,
    stucls:number;
 }
 
 const read= readline.createInterface(
    {
        input:process.stdin,
        output:process.stdout
    }
 );
 
 async function insertStudent(student:Student) {
    const {data, error} = await supabase
    .from('student')
    .insert(student)
    .select('*');
    if(error){
        console.log("Student not inserted",error.details);
    }else{
        console.log("Student inserted Succesfully",data);
    }
    }
async function deleteStudent(stu:number) {
    const {data,error}=await supabase
    .from('student')
    .delete()
    .eq('stuid',stu)
    .select('*');
    if(error){
        console.log("Student not Deleted",error.details);
    }else{
        console.log("Student Deleted Succesfully",data);
    }
   
}
 
 
 
async function updateStudent(student:Student) {
    const {data,error}=await supabase
    .from('student')
    .update(student)
    .eq('stuid',student.stuid)
    .select('*');
    if(error){
        console.log("Student not updated",error.details);
    }else{
        console.log("Student updated Succesfully",data);
    }
   
}
 
 
async function showStudent() {
    const {data,error}=await supabase
    .from('student')
    .select('*');
    if(error){
        console.log("Empty list",error.details);
    }else{
        console.log("list of students",data);
    }
   
}
 
async function showOnlyStudent(stu:number) {
    const {data,error}=await supabase
    .from('student')
    .select()
    .eq('stuid',stu);
    if(error){
        console.log("Student not found",error.details);
    }else{
        console.log("Student List is",data);
    }
   
}
 
const stu:number=4;
    const student:Student={
        stuid:2,
        stuname:'mee',
        stucls:1
    }
 
   async function handlecrudOpertions(operations:string) {
    let exit:boolean=false;
    while(!exit)
    {
        read.question('Enter operation (insert, select, update, delete): ', (operation) => {
            handlecrudOpertions(operation);
          });
          switch(operations){
            case 'insert':
                await insertStudent(student);
                break
            case 'update':
                await updateStudent(student);
                break;
            case 'delete':
                await deleteStudent(stu);
                break;
            case 'showallstudents':
                await showStudent();
                break;
            case 'showstudentsbased on id':
                await showOnlyStudent(stu);
                break;
            case 'exit':
                exit = true;
                console.log("exiting the system");
            default:
                console.log('invalid input');
   
        }
    }
   
   
   }