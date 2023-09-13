# iPhone Calculator v.2

This project is an extension of the previous iPhone calculator. It has all the basic operands such as +, -, /, and *, but also now can do some trigonometric operations such as sin, cos, tan, as well as log10, and ln. These 5 buttons can be accessed when the user changes the orientation of the app into landscape mode. The app also saves data between orientation changes.

## Functionality 

The following **required** functionality is completed:

* [✅] User sees the initial buttons from the previous versions
* [✅] User sees 5 additional buttons when app switched to landscape mode
* [✅] User can continue operations from portrait mode to landscape mode and vice versa
* [✅] User can do over 10 operations on any number

The following **extensions** are implemented:

* N/A

## Video Walkthrough

Here's a walkthrough of implemented user stories:

![]()

GIF created with [Adobe Express](https://www.adobe.com/express/).

## Notes

One challenge I had during this project was that my TextView value wouldn't save when I switched orientations, even though I had created my onSaveInstanceState and onRestoreInstanceState functions. What was happening was that they were not being called at all when I logged them because they had the wrong parameters in the method signature. Once I fixed that issue, the methods worked as intended and my TextView value stayed in between orientation switches.

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
