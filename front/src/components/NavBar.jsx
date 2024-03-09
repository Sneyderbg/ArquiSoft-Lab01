import React from "react";
import "../styles/NavBar.css";
import NavBarButton from "./NavBarButton";

function NavBar({ activeFilter, onFilterBtnClick }) {
  return (
    <nav className="navbar">
      <span>Buscar vuelos por</span>
      {["Fechas", "Aerolinea", "Origen", "Destino", "Precio"].map(
        (text, idx) => {
          return (
            <NavBarButton
              key={idx}
              active={idx === activeFilter}
              onClick={() => onFilterBtnClick(idx)}
            >
              {text}
            </NavBarButton>
          );
        }
      )}
    </nav>
  );
}

export { NavBar };

