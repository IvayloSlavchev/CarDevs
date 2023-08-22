import { useState, useEffect } from 'react';
import Header from '../Header/Header';
import { localhost } from '../../App';
import "../../Styles/Home.scss";

const Home = () => {
    const [cars, setCars] = useState<any>([]);

    const categories: string[] = ["Benzin", "Diesel", "Gas-Benzin", "Electricity"];
    const getFilteredCars: any = [];

    async function filtersCarsByEngineTypes(engineType: string) {
        const getTypesOfEngine = await fetch(`${localhost}/cars`);
        const getTypesOfEngineJSON = await getTypesOfEngine.json();

        for(let item of getTypesOfEngineJSON) {
            if(item.engineTypes.includes(engineType)){
                console.log(item);
                
                getFilteredCars.push(item);
            }
        }

        setCars(getFilteredCars);
    }

    async function getAllCars() {
        const getAllCars = await fetch(`${localhost}/cars`);
        const getAllCarsToJSON = await getAllCars.json();

        console.log(getAllCarsToJSON);
        
        setCars(getAllCarsToJSON);
    }

    useEffect(() => {
        getAllCars();
    }, [])

    return (
        <div className="home-root-element">
            <Header />
            
            <div className='home-body-class'>
                <ul className='category-root-element'>
                    <li className='category-li'>
                        <button className='category-button' onClick={() => getAllCars()}>All</button>
                    </li>
                    {
                        categories.map((item: any, index: number) => {
                            return <li className='category-li' key={index}>
                                <button onClick={() => filtersCarsByEngineTypes(item)} className='category-button'>{item}</button>
                            </li>
                        })
                    }
                </ul>
                <div className='avaiable-cars-class'>
                    {
                        cars.map((item: any, index: number) => {
                            return <div key={index} className='cars-card'>
                                <h1 className='car-model'>{item.brand} {item.model}</h1>
                                <p>{item.price} leva</p>
                                <img src={item.image} alt="Car image" className='car-image' />

                                <p>Engine: {item.engineTypes.map((engineType: string) => engineType).join(", ")}</p>
                                <p>Horse power: {item.horsePower.map((horsePower: string) => horsePower).join(", ")}</p>
                            </div>
                        })
                    }
                </div>
            </div>

        </div>
    )
}

export default Home