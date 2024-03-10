import { useState } from "react";
import "./App.css";
import { FlightSearch } from "./FlightSearch";
import { Table } from "./components/Table";
import { NavBar } from "./components/NavBar";

function App() {
  const [activeFilter, setActiveFilter] = useState(0);

  const [flights, setFlights] = useState([]);
  const handleSearchByDatesClick = () => {
    //Búsqueda por el rango de fechas seleccionado
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

  const handleSearchByAirlineClick = () => {
    //Búsqueda por el nombre de aerolinea del vuelo
    const nameAirline = document.getElementById("airline").value;

    const flightByAirlineHeaders = new Headers({ method: "GET" });
    const flightByAirlineRequest = new Request(
      `http://localhost:8080/flights/searchByName?nameAirline=${nameAirline}`,
      flightByAirlineHeaders
    );
    fetch(flightByAirlineRequest)
      .then((response) => response.json())
      .then((data) => setFlights(data))
      .catch((error) => alert("Error en el servidor", error.status));
  };

  const handleSearchByOriginClick = () => {
    //Búsqueda por la ciudad de origen del vuelo
    const cityOfOrigin = document.getElementById("origin").value;

    const flightOriginHeaders = new Headers({ method: "GET" });
    const flightOriginRequest = new Request(
      `http://localhost:8080/flights/searchByOrigin?cityOfOrigin=${cityOfOrigin}`,
      flightOriginHeaders
    );

    fetch(flightOriginRequest)
      .then((response) => response.json())
      .then((data) => setFlights(data))
      .catch((error) => alert("Error en el servidor", error.status));
  };

  const handleSearchByDestinationClick = () => {
    const cityOfDestination = document.getElementById("destination").value;

    const flightDestinationHeaders = new Headers({ method: "GET" });
    const flightDestinationRequest = new Request(
      `http://localhost:8080/flights/searchByDestination?cityOfDestination=${cityOfDestination}`,
      flightDestinationHeaders
    );

    fetch(flightDestinationRequest)
      .then((response) => response.json())
      .then((data) => setFlights(data))
      .catch((error) => alert("Error en el servidor", error.status));
  };

  const handleSearchByPriceClick = () => {
    const inicialPrice = document.getElementById("fromPrice").value;
    const finalPrice = document.getElementById("toPrice").value;

    const flightByPriceHeaders = new Headers({ method: "GET" });
    const flightByPriceRequest = new Request(
      `http://localhost:8080/flights/searchByPrice?inicialPrice=${inicialPrice}&finalPrice=${finalPrice}`,
      flightByPriceHeaders
    );

    fetch(flightByPriceRequest)
      .then((response) => response.json())
      .then((data) => setFlights(data))
      .catch((error) => alert("Error en el servidor", error.status));
  };

  const handleUnimplementedSearch = (e) => {
    //Para los casos en los que no hay una función de búsqueda implementada aún
    console.error(
      "there is no function to filter by",
      ["dates", "airline", "origin", "destination", "price"][activeFilter],
      "in App.js"
    );
    alert("unimplemented filter (see console)");
  };

  const selectHandleSearch = () => {
    //Selecciona cual función de búsqueda de vuelos pasar al componente de búsqueda
    if (activeFilter === 0) {
      return handleSearchByDatesClick;
    } else if (activeFilter === 1) {
      return handleSearchByAirlineClick;
    } else if (activeFilter === 2) {
      return handleSearchByOriginClick;
    } else if (activeFilter === 3) {
      return handleSearchByDestinationClick;
    } else if (activeFilter === 4) {
      return handleSearchByPriceClick;
    } else {
      return handleUnimplementedSearch;
    }
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
          handleSearch={selectHandleSearch()}
        />
        <Table flights={flights} />
      </main>
    </div>
  );
}

export default App;
