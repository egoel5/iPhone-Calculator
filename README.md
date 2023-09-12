# iPhone Style Calculator

This project consists of an iPhone-style calculator. It has the same buttons and overall feel and the same functionality as the iPhone calculator, except that it is an Android app rather than an iOS app. It has all 10 number buttons, as well as buttons for clearing the screen, flipping the sign of the current number, getting the percent value of the current number, division, multiplication, subtraction, and addition. 

## Functionality 

The following **required** functionality is completed:

* [✅] User sees all 15 buttons that are required for the basic calculator layout
* [✅] User can utilize all 15 buttons and receive accurate, formatted answers

## Video Walkthrough

![Walkthrough](https://github.com/egoel5/C323_Project1/blob/master/Running%20Devices%20-%20C323_Project1%202023-09-04%2022-18-24.gif)

## Notes

One of the main challenges I had when I created my app was that it would crash whenever I opened it. The cause of this error was that I was initializing my references to the layout before onCreate, which resulted in a NullPointerException. I simply set every reference to a lateinit and then initialized them inside my onCreate function, which fixed the issue.

## License

    Copyright [2023] [Eshan Goel]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
