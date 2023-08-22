import Home from "./components/Home/Home"
import { Routes, Route } from 'react-router-dom';

export const localhost: string = 'http://localhost:8080/api/v1';

function App() {

    return (
        <div>
            <Routes>
                <Route path='/' element={<Home />} />
            </Routes>
        </div>
    )
}

export default App
