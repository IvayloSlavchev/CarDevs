import { Link } from 'react-router-dom';

const Header = () => {
    return (
        <header className='header-root-element'>
            <div> 
                <h1 className='site-title'>DevCars</h1>
            </div>
            <div className='links-class'>
                <ul className='list-of-links'>
                    <Link className='header-links' to='/'>Home</Link>
                    <Link className='header-links' to='/about'>About us</Link>
                    <Link className='header-links' to='/signin'>Sign In</Link>
                    <Link className='header-links' to='/login'>Login</Link>
                </ul>
            </div>
        </header>
    )
}

export default Header