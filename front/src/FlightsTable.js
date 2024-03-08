import React, { useState } from "react";

function FlightsTable({ flights }) {
  const [sortBy, setSortBy] = useState("none");
  const [sortOrd, setSortOrd] = useState("asc");

  const attributes = [
    ["Id", "id"],
    ["Origen", "origin"],
    ["Destino", "destination"],
    ["Salida", "departureDate"],
    ["Llegada", "arrivalDate"],
    ["Aerolinea", "airline"],
    ["Precio", "price"],
  ];

  const changeSort = ({ target }) => {
    if (sortBy === target.id) {
      setSortOrd(sortOrd === "asc" ? "des" : "asc");
    } else {
      setSortBy(target.id);
      setSortOrd("asc");
    }
  };

  return (
    <div className="flightsTable">
      <table id="flightsTable">
        <thead>
          <tr>
            {attributes.map((attr, idx) => {
              return (
                <th id={attr[1]} key={idx} onClick={changeSort}>
                  {attr[0]}
                  {sortBy === attr[1]
                    ? sortOrd === "des"
                      ? "\u25B4"
                      : "\u25BE"
                    : ""}
                </th>
              );
            })}
          </tr>
        </thead>
        <tbody>
          {flights
            .sort((fa, fb) => {
              if (sortBy === "none") return 0;
              if (sortOrd === "asc") {
                return fa[sortBy] < fb[sortBy] ? -1 : 1;
              } else if (sortOrd === "des") {
                return fa[sortBy] > fb[sortBy] ? -1 : 1;
              } else {
                return 0;
              }
            })
            .map((flight, idx) => {
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
