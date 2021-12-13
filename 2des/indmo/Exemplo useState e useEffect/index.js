import React, {useState, useEffect} from 'react';

export default function Home() {
    const [lista, setLista] = useState([]);

    useEffect(()=>{
        fetch(url)
        .then(resp => { return resp.json() })
        .then(data => { 
            setLista(data);
        })
        .catch(err => {

        });
    }, []);

    useEffect(() => {

    }, [lista]);

    return(
        <View>
            {
                lista.map(() => {
                    
                })
            }
        </View>
    )
}