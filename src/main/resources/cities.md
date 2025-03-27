FInd total cities count and total population of cities from the USA and Canada. Display only countries which have more
than one city.

### SQL

Cities table

| ID | COUNTRY | CITY        | POPULATION | AREA  |
|----|---------|-------------|------------|-------|
| 1  | USA     | New York    | 8336817    | 468.9 |
| 2  | USA     | Los Angeles | 3979576    | 502.7 |
| 3  | Canada  | Toronto     | 2794356    | 243.3 |
| 4  | Mexico  | Mexico City | 9209944    | 573.0 |
| 5  | Mexico  | Guadalajara | 1385629    | 146.7 |

### MONGO

Cities collection

```mongodb-json
[
    {
        _id: 1,
        Country: 'USA',
        City: 'New York',
        Population: 8336817,
        Area: 468.9
    },
    {
        _id: 2,
        Country: 'USA',
        City: 'Los Angeles',
        Population: 3979576,
        Area: 502.7
    },
    {
        _id: 3,
        Country: 'Canada',
        City: 'Toronto',
        Population: 2794356,
        Area: 243.3
    },
    {
        _id: 4,
        Country: 'Mexico',
        City: 'Mexico City',
        Population: 9209944,
        Area: 573.0
    },
    {
        _id: 5,
        Country: 'Mexico',
        City: 'Guadalajara',
        Population: 1385629,
        Area: 146.7
    }
]
```
