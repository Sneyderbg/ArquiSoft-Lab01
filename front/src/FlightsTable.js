import React from "react";

function FlightsTable({ flights }) {
  return (
    <div className="flightsTable">
      <table>
        <thead>
          <tr>
            <th>Id</th>
            <th>Origen</th>
            <th>Destino</th>
            <th>Salida</th>
            <th>Llegada</th>
            <th>Aerolinea</th>
            <th>Precio</th>
          </tr>
        </thead>
        <tbody>
          {flights.map((flight, idx) => {
            return (
              <tr key={flight.id}>
                <td>{flight.id}</td>
                <td>{flight.origin}</td>
                <td>{flight.destination}</td>
                <td>{flight.departureDate}</td>
                <td>{flight.arrivalDate}</td>
                <td>{flight.airline}</td>
                <td>${flight.price}</td>
              </tr>
            );
          })}
        </tbody>
      </table>
    </div>
  );
}

export { FlightsTable };
