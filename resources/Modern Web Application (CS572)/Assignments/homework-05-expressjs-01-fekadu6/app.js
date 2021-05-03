const express = require("express");
const axios = require("axios");
const { from } = require("rxjs");
const { map } = require("rxjs/operators");

//const parse = require("parse-link-header");

const app = express();
app.enable("trust proxy");
app.set("x-powered-by", false);
app.enable("case sensitive routing");
app.enable("strict routing", true);

const port = 3000;
const url = "https://randomuser.me/api/?results=10";

app.get("/user", (req, res) => {
  const users = getUser();

  res.links({
    next: "https://randomuser.me/api/?results=10&page=2",
    last: "https://randomuser.me/api/?results=10&page=10"
  });

  //   const totalUsers = users.length;
  //   const lastPage = Math.floor(totalUsers / 10); //10 users per page...

  //   const parsed = parse(
  //     '<https://randomuser.me/api/?page=2&results=10>; rel="next", ' +
  //       "<https://randomuser.me/api/?page=" +
  //       (lastPage || 0) +
  //       '&results=10>; rel="last"'
  //   );

  //console.log(parsed.next.url);

  from(users)
    .pipe(
      map(user => {
        return user.data.results.map(u => {
          return {
            first: u.name.first,
            last: u.name.last
          };
        });
      })
    )
    .subscribe(data => {
      //res.send("<a href=" + parsed.next.url + ">Next</a>");
      res.send(data);
    });
});

//fetch the user data using axios
async function getUser(page) {
  try {
    const response = await axios.get(url.concat("&", page));

    return response;
  } catch (error) {
    console.log(error);
  }
}

app.listen(port, _ => console.log(`Listening to port ${port}`));
