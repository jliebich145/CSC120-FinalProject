# CSC120-FinalProject

## Deliverables:
 - Your final codebase
 - Your revised annotated architecture diagram
 - Design justification (including a brief discussion of at least one alternative you considered)
 - A map of your game's layout (if applicable)
 - `cheatsheet.md`
 - Completed `rubric.md`
  
## Additional Reflection Questions
 - What was your **overall approach** to tackling this project?
 I started by making all of the classes I knew I needed and then figured out what the first step would be in making things work. Once I had a short term goal, I worked backwards implementing the code I would need. I'm not sure this was the best approach in terms of testing for bugs, but it worked really well in making sure I didn't miss steps in the middle. It did mean that I couldn't test for my goal until everything was finished.
 - What **new thing(s)** did you learn / figure out in completing this project?
 I learned a lot about working with graphs and how to iterate through them. I also worked a lot more with using random than I had in the past. I did a lot of experimenting with how to pass information between classes and while what I have works (which is generally just always passing around the instance for the player character), I'm definitely curious if there was a better way to do that. I also got a lot more experience with overloading in subclasses and how important that can be. 
 - Is there anything that you wish you had **implemented differently**?
 I'm not very confident with how I implemented combat. I think the system itself is fine (although is completely unbalanced later in the game) but in terms of code I wish I had made a different class that I could call methods from instead of containing it all within a single method. 
 - If you had **unlimited time**, what additional features would you implement?
 I think it would have been really cool to get into the mythology of the constellations and stars and involve that in making them feel more unique. I'd also like to have them work more like a story and run in a specific order so that they could get more challenging and I could account better for power growth because I'd have an idea of how many items players would have. I think adding graphics that at least bring up the map for the constellation would be great, even though I made it available during the in-class expo. 
 - What was the most helpful **piece of feedback** you received while working on your project? Who gave it to you?
 I honestly didn't get much feedback from others, but what Jordan said in the discord about not using multiple scanners definitely helped me out! I hadn't gotten around to implementing multiple yet because I did have some concerns about how that would work, so I was able to adjust what I was doing and I think ultimately ended up with something that is much more concise than whatever workaround I would have figured out without that info.
 - If you could go back in time and give your past self some **advice** about this project, what hints would you give?
 It's not really related to programming, but I'd mostly just remind myself that this is something I'm capable of. I knew that this game was probably more ambitious than what was required for the project and I definitely wanted to challenge myself, but I think I held back because I was worried it was out of the realm of what I could do. If I'd been more confident, I probably could have implemented even more! Regardless, I'm really proud of what I have done here
 - _If you worked with a team:_ please comment on how your **team dynamics** influenced your experience working on this project.
 NA

 Design Justification:
 My primary goal was to make the foundation for a semi-educational game based on the constellations. I knew I wanted to include the names of the stars, the type of star, and their connections to eachother as a basis. I also wanted to have some variety in the game which is why I used the star types as subclasses where each star type does something slightly different. I did consider doing a scavenger-hunt inspired game where you traveled only between constellations and found items based on their mythology, but that wouldn't have included information about the stars or what the constellations look like. 

