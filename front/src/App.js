import { useState } from "react";
import "./App.css";
import { FlightSearch } from "./FlightSearch";
import { Table } from "./components/Table";

function App() {
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

  return (
    <div>
      <FlightSearch handleSearch={handleSearchByDatesClick} />
      <Table flights={flights} />
    </div>
  );
}

export default App;
