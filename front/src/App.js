import { useState } from "react";
import "./App.css";
import { FlightSearch } from "./FlightSearch";
import { Table } from "./components/Table";
import { NavBar } from "./components/NavBar";

function App() {
  const [activeFilter, setActiveFilter] = useState(0);

  const [flights, setFlights] = useState([]);
  const handleSearchByDatesClick = () => {
    const startDate = document.getElementById("startDate").value;
    const endDate = document.getElementById("endDate").value;

    const flightByDatesHeaders = new Headers({ method: "GET" });
    const flightByDatesRequest = new Request(
      `http://localhost:8080/flights/search?startDate=${startDate}&endDate=${endDate}`,
      flightByDatesHeaders
    );

    fetch(flightByDatesRequest)
      .then((response) => response.json())
      .then((data) => setFlights(data))
      .catch((error) => alert("Error en el servidor", error.status));
  };

  const handleUnimplementedSearch = (e) => {
    console.error(
      "there is no function to filter by",
      ["dates", "airline", "origin", "destination", "price"][activeFilter],
      "in App.js"
    );
    alert("unimplemented filter (see console)");
  };

  return (
    <div className="app">
      <NavBar
        activeFilter={activeFilter}
        onFilterBtnClick={(idx) => setActiveFilter(idx)}
      />
      <main>
        <h1>Buscador de vuelos</h1>
        <FlightSearch
          activeFilter={activeFilter}
          handleSearch={
            activeFilter === 0
              ? handleSearchByDatesClick
              : handleUnimplementedSearch
          }
        />
        <Table flights={flights} />
      </main>
    </div>
  );
}

export default App;
