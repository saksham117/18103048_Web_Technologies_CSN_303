var text = "";

var n = prompt("Enter the height of the tree(should be greater than equal to 2): " );

// i indicates the height
// j is for leaving spaces
// k is for entering the zeros

for(let i=1;i<=n;i++){
  // text is what we want to print
  text = "";
  for(let j=i;j<n;j++){
    text += " ";
  }
  // if the height == 1, print a star
  if(i == 1)
    {
      text += "*";
    }
  else
    {
       for(let k=0;k<(i*2)-1;k++)
       {
    			text += "0";
  		 }
    }
 
  console.log(text);
}