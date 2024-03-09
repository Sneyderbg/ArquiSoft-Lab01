import React from "react";

import "../styles/NavBarButton.css";

export default function NavBarButton({ active, onClick, children }) {
  return (
    <button className="navbar-btn" disabled={active} onClick={onClick}>
      {children}
    </button>
  );
}
