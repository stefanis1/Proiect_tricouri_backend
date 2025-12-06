import { useState,useEffect } from 'react'
import './App.css'
import axios from 'axios'

const TricouCard = (propietati) =>{
    const{nume,url,echipa ,pret,marime}= propietati

    const echipaFA =echipa ? echipa.name: "Nu are echipa "

    return(
        <div className="TricouCard">
            <p>
                <img src={url}
                     className="Imagine-Tricou"
                     alt={'nu merge poza '}/>
            </p>
            <h2 className="Nume-Tricou">
                {nume}
            </h2>
            <p className="Nume-Echipa">
                Team: {echipaFA}
            </p>
            <button className="Buton-Pret">
                RON {pret}
            </button>
        </div>
    )
}

const UserCard = (props) => {
    const {name ,email}=props;

    return (
        <div >
            <p>
                {name}
            </p>

            <button>
                {email}
            </button>
        </div>
    )
}




function App() {



    const [user,setuser]=useState([]);

    useEffect( () =>{
        fetch('http://localhost:8080/user')
            .then(rasp => rasp.json())
            .then(data =>setuser(data))
            .catch(err =>console.error)

    },[])

const [tricouri,setTricouri]=useState([]);

useEffect(() => {
    fetch('http://localhost:8080/tricou')
        .then(rasp=>rasp.json())
        .then(date =>{setTricouri(date);
            console.log(date)
        })
        .catch(err =>console.error(err))
},[]);


    return (
      <>
        {/*<div className="User">*/}
        {/*    {user.map( t => (*/}
        {/*        <UserCard*/}
        {/*        key={t.id}*/}
        {/*        name={t.name}*/}
        {/*        // echipa={t.echipa}*/}
        {/*        // pret={t.pret}*/}
        {/*         email={t.email}/>*/}


        {/*        ))}*/}
        {/*</div>*/}

          <div className="Tricouri"   >
              {tricouri.map( (t) => (
                  <TricouCard
                  key={t.id}
                  nume={t.name}
                  echipa={t.echipa}
                  pret={t.pret}
                  marime={t.marime}
                  url={t.url}/>




              ))}
          </div>

      </>
    )
}

export default App
