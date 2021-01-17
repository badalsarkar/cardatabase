import React, { Component } from "react";
import { SERVER_URL } from "../Constants";
import BasicTable from "./Table";

class CarList extends Component {
  constructor(props) {
    super(props);
    this.state = { cars: [] };
  }

  fetchCars = () => {
    fetch(SERVER_URL + "api/cars")
      .then((res) => res.json())
      .then((resData) => {
        this.setState({
          cars: resData._embedded.cars,
        });
      })
      .catch((err) => console.error(err));
  };

  deleteCar = (id) => {};

  componentDidMount() {
    this.fetchCars();
  }

  render() {
    //console.log(this.state.cars);
    const columns = ["Brand", "Model", "Color", "Year", "Price $"];
    const data = this.state.cars.map((c) => [
      c.brand,
      c.model,
      c.color,
      c.year,
      c.price,
      c._links,
    ]);
    //console.log(data);

    return (
      <div className="App">
        <BasicTable data={data} columns={columns} />
      </div>
    );
  }
}

export default CarList;
