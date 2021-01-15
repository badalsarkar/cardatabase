import React, { Component } from "react";

class CarList extends Component {
  constructor(props) {
    super(props);
    this.state = { cars: [] };
  }

  componentDidMount() {
    fetch("http://localhost:8080/api/cars")
      .then((res) => res.json())
      .then((resData) => {
        this.setState({
          cars: resData._embedded.cars,
        });
      })
      .catch((err) => console.error(err));
  }

  render() {
    const tableRows = this.state.cars.map((car, index) => {
      return (
        <tr key={index}>
          <td>{car.brand}</td>
          <td>{car.model}</td>
          <td>{car.color}</td>
          <td>{car.year}</td>
          <td>{car.price}</td>
        </tr>
      );
    });

    return (
      <div className="App">
        <table>
          <tbody>{tableRows}</tbody>
        </table>
      </div>
    );
  }
}

export default CarList;