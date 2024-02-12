import React, { useEffect } from "react";
import "./AddStudentForm.css";
import { useState } from "react";
import axios from "axios";



function AddStudentForm() {

  const[stdId,setId]=useState("");
  const [name, setName] = useState("");
  const [dept, setDept] = useState("");
  const [fees, setFees] = useState("");
  const [phone, setPhone] = useState("");
  const [address, setAddress] = useState("");
  const [students,setStudents]=useState([]);

    useEffect(()=>{
        // (async()=> await load())(); 
      load();
    },[]);

    async function load(){
        const result=await axios.get("http://localhost:8080/api/v1/student/read")
        .then(Response=>Response.data)
        .then(res => setStudents(res))
        .catch((e)=>console.error(e));
    }



    // save
    async function save(e){
        e.preventDefault();
        
        const result1= await axios.post("http://localhost:8080/api/v1/student/save",
            {
                s_name : name,
                s_department : dept,
                s_phone : phone,
                s_fees : fees,
                s_address : address
            }

        )
        .catch((e)=>console.log(e));
    
        alert("Stdent Registration Completed");
        setId("");
        setName("");
        setAddress("");
        setDept("");
        setFees("");
        setPhone("");
        
        // the load function was workinhg as once the data was saved to the database , if the function was retrive the
        // data and store again into the students 'state'(frontend section)
        load();
    }

     async function editStd(items){
        setId(items.id);
        setAddress(items.s_address);
        setDept(items.s_department);
        setFees(items.s_fees);
        setName(items.s_name);
        setPhone(items.s_phone);
        console.log("update");
    }

    async function updateStd(e){
        e.preventDefault();
      const result3=await axios.put("http://localhost:8080/api/v1/student/update",{
                id : stdId,
                s_name : name,
                s_department : dept,
                s_phone : phone,
                s_fees : fees,
                s_address : address
        
      }).catch((e)=>console.log(e));
        
      console.log(result3)
        alert("Student Registration updated Successfully");
        setId("");
        setName("");
        setAddress("");
        setDept("");
        setFees("");
        setPhone("");
        load();
        
    }

    async function deleteStd(id){
        const result2=await axios.delete("http://localhost:8080/api/v1/student/delete/"+id);
        alert("Registration was successfully deleted");
        load();
      }

    function clear(e){
        e.preventDefault();
        setAddress("")
        setDept("")
        setFees("")
        setName("")
        setPhone("")
    }


  return (
    <div className="main">
      <form>
        <h1>Add New Student</h1>
        <div className="fname">
          <label htmlFor="fname">Student Name</label> <br></br>
          <input type="search" name="fname" id="fname" value={name}  onChange={(e)=>{
                setName(e.target.value);
          }} />
        </div>

        <div className="dept">
          <label htmlFor="dept">Department</label> <br></br>
          <input type="search" name="dept" id="dept" value={dept} onChange={(e)=>
            {
                setDept(e.target.value)
            }}/>
        </div>

        <div className="phone">
          <label htmlFor="phone">Moile No</label> <br></br>
          <input type="number" name="phone" id="phone" value={phone} onChange={(e)=>{
                setPhone(e.target.value)
          }}/>
        </div>

        <div className="fees">
          <label htmlFor="search">Fees</label> <br></br>
          <input type="search" name="fees" id="fees" value={fees} onChange={(e)=>{
            setFees(e.target.value)
          }}/>
        </div>

        <div className="address">
          <label htmlFor="address">Address</label> <br></br>
          <input type="search" name="address" id="address" value={address} onChange={(e)=>{
            setAddress(e.target.value)
          }}/>
        </div>

        <div className="btngroup">
          <button id="save" onClick={save} >Save</button>
          <button id="clear" onClick={updateStd} >Update</button>
          <button onClick={clear} id="cleardata">Clear</button>
        </div>
      </form>

      {/* Table section */}
    <div className="table">
      <h1>Student List Details</h1>
      <table border={5}>
        <thead>
          <tr>
            <th>Student Id</th>
            <th>Student Name</th>
            <th>Student Department</th>
            <th>Student phone</th>
            <th>Student Fees</th>
            <th>Student Address</th>
            <th>Options</th>
          </tr>
        </thead>
        <tbody>
                {
                    students.map(items=>{
                        return(
                            <tr>
                                <td> {items.id} </td>
                                <td>{items.s_name} </td>
                                <td>{items.s_department} </td>
                                <td>{items.s_phone}</td>
                                <td>{items.s_fees}</td>
                                <td>{items.s_address}</td>
                                <td>
                                    <button onClick={()=>editStd(items)}  id="save">Edit</button>
                                    <button onClick={()=>deleteStd(items.id)} id="clear">Delete</button>
                                </td>
                            </tr>
                        )                   

                    })
                }         
        </tbody>
      </table>
    </div>
    </div>
  );
}

export default AddStudentForm;
