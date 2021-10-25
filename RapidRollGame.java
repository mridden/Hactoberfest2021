import java.awt.*;                     //CHANGE THE scrollSpeed value 


import java.awt.event.*;                //to run the thread with more

import java.util.*;
import java.io.*;

class HighSc
{

  int hsc;
  BufferedReader br;
  FileInputStream fis;
  String sths;
  public String getHighScore()  throws IOException
  {
     fis = new FileInputStream("highscore.txt");
     br = new BufferedReader(new InputStreamReader(fis));

     sths = br.readLine();

     fis.close();
     return sths;
     }

 }


class GameFrame extends Frame implements  Runnable, KeyListener
,ActionListener
{


   MenuBar mb;
   Menu m1;
   MenuItem mi1,mi2,mi3,mi4,mi5,mi6;

    Button b1,b2,b3;
    Button ball;
    Button oneUp;

    final int TOPLINE = 50;
    final int BOTTOMLINE = 350;
    final int LEFTLINE = 20;
    final int RIGHTLINE = 350 ;

    int scrollSpeed = 25;

    int x=50, y=300;
    int x2=125,y2=200;
    int x3 = 90,y3=100;
    int bx = 80;
    int by = 239;
    int ox = 0;
    int oy = 0;
    int score = 0;
    int oneUpCount = 1;

    int  t1,t2,t3;

    int chances=3;
    int a,b,c;
    int diff = 65;
    String msg = "";
    String chns = "";
    String st = "";


    char ch;
    int kcode;
    boolean flagLKey = true;
    boolean flagRKey = true;
    boolean flagTop1 = false;
    boolean flagTop2 = false;
    boolean flagTop3 = false;
    boolean flagDrop = true;
    boolean flagMove = true;
    boolean flagBetween = true;
    boolean flagOnx = true;
    boolean flagOnx2 = false;
    boolean flagOnx3 = false;
    boolean flagJump = true;
    boolean flagNew1 = false;
    boolean flagOneUp = false;

    Thread t;

    GameFrame()
    {


     mb = new MenuBar();
     m1  = new Menu("File");
     mi1 = new MenuItem("New Game");
     mi2 = new MenuItem("HighScores");
     mi3 = new MenuItem("Exit");

     setMenuBar(mb);
     mb.add(m1);

     m1.add(mi1);
     m1.add(mi2);
     m1.add(mi3);



        setTitle("simple frame");
        setSize(400,350);

        setLayout(null);
        b1 = new Button("");
        b2 = new Button("");
        b3 = new Button("");
        ball = new Button("o");
        oneUp = new Button("0");
        add(ball);
        add(b1);
        add(b2);
        add(b3);
        add(oneUp);
        b1.setBounds(x,y,70,20);
        b2.setBounds(x2,y2,70,20);
        b3.setBounds(x3,y3,70,20);

        ball.setBounds(bx,by,10,10);
        oneUp.setBounds(bx-5,by,5,5);

        setBackground(Color.blue);
        setForeground(Color.white);
        ball.addKeyListener(this);

        mi1.addActionListener(this);
        mi2.addActionListener(this);
	mi3.addActionListener(this);

         addWindowListener(new WindowAdapter()
         {
             public void windowClosing(WindowEvent we)
             {
                  closeAll();
                }
            });

          t = new Thread(this,"game");
          t.start();

      }  //end of constructor

      public void actionPerformed(ActionEvent ae)
      {
          st = ae.getActionCommand();
          if(st.equals("New Game"))
          {

              stop();this.setVisible(false);
              Frame ng = new GameFrame();
              ng.setVisible(true);

             }
          else if(st.equals("HighScores"))
          {

	     HighSc hs = new HighSc();
             try
             {
               msg = "";
               msg  =  hs.getHighScore(); repaint();
               }
             catch(IOException ie)
             {
		System.out.println(ie);
               }
	    }
          else if(st.equals("Exit"))
          {
              closeAll();
	     }

        }

      public void closeAll()
      {

        stop();
        t = null;
         System.exit(0);

        }

      public void keyPressed(KeyEvent ke)
      {
            kcode = ke.getKeyCode();




             switch(kcode)
             {

                case KeyEvent.VK_LEFT:
                                       if(flagDrop)
                                          bx -= 4;





if(ox<=bx+2&&ox>=bx&&(oy>=by&&oy<=by+6))
                                       {
					 chances++;ox = 0;oy = 0;
					  repaint(); flagOneUp = false;
					 }

		     while(flagLKey)
                     {
 			 if(((bx>=x&&bx<=x+70)&&(by<y&&by>=y-11))
		           ||((bx>=x2&&bx<=x2+70)&&(by<y2&&by>=y2-11))
			   ||((bx>=x3&&bx<=x3+70)&&(by<y3&&by>=y3-11)))

	   		 {
             	             flagBetween = true;
                             bx  -= 2; flagDrop = false;
                           }
                        else
			{
			    flagDrop = true;
             		    flagBetween = false;
                            if(flagOnx)
                               flagOnx = false;
                            else if(flagOnx2)
                               flagOnx2 = false;
                            else if(flagOnx3)
                               flagOnx3 = false;

				 break;
			  }

                         repaint();  break;
 			}


                                            break;

                case KeyEvent.VK_RIGHT:
         if(flagDrop)
		bx +=4;


if(ox<=bx+2&&ox>=bx&&(oy>=by&&oy<=by+6))
					{
					   chances++;	ox = 0; oy = 0;
					   repaint();	flagOneUp = false;
					  }

while(flagRKey)
                      {

			if(((bx>=x&&bx<=x+70)&&(by<y&&by>=y-11))
		           ||((bx>=x2&&bx<=x2+70)&&(by<y2&&by>=y2-11))
			   ||((bx>=x3&&bx<=x3+70)&&(by<y3&&by>=y3-11)))

			{
	                    bx  += 2;
                            flagBetween = true;
			    flagDrop = false;
                            repaint(); break;
			   }
                        else
 			 {
                            flagBetween = false;
                            flagDrop = true;

  			    if(flagOnx)
                               flagOnx = false;
                            else if(flagOnx2)
                               flagOnx2 = false;
                            else if(flagOnx3)
                               flagOnx3 = false;

			    break;
			    }
                    	}
                       break;
                 }

          }
     public void keyReleased(KeyEvent ke)
      {
           if(bx<LEFTLINE)
            {
               flagLKey = false;
               flagRKey = true;
              }
           else if(bx>BOTTOMLINE)
           {
               flagRKey = false;
               flagLKey = true;
             }
           else
           {
               flagLKey = true;
               flagRKey = true;
              }


          }

      public void keyTyped(KeyEvent ke)
      {

          }

     public void flagDropFun()
     {


            while(flagDrop)
            {
	       by += 1;

              if(((bx>=x&&bx<=x+70)&&(by<y&&by>=y-11))
	 	           ||((bx>=x2&&bx<=x2+70)&&(by<y2&&by>=y2-11))
			   ||((bx>=x3&&bx<=x3+70)&&(by<y3&&by>=y3-11)))
               {

                 flagDrop = false;
		 flagBetween = true;


if(!flagOnx2&&!flagOnx3&&(bx>=x&&bx<=x+70)&&(by<y&&by>=y-11))
		 {
		     flagOnx = true;	flagJump = true;score +=5;
		     flagOnx2 = false;
		     flagOnx3 = false;
		   }
		 else 
if(!flagOnx&&!flagOnx3&&(bx>=x2&&bx<=x2+70)&&(by<y2&&by>=y2-11))
		 {

		     flagOnx2 = true; 	flagJump = true; score += 5;
                     flagOnx  = false;
		     flagOnx3 = false;
                   }
                 else
if(!flagOnx&&!flagOnx2&&(bx>=x3&&bx<=x3+70)&&(by<y3&&by>=y3-11))
                 {
		     flagOnx3 = true;   flagJump = true; score +=5;
                     flagOnx  = false;
                     flagOnx2 = false;
                   }
                 else
                  {
                     flagOnx = false;
                     flagOnx2 = false;
                     flagOnx3 = false;

                    }

                 }

               repaint(); break;
             }

       }


       public void run()
       {
            try
            {

             while(flagMove)
             {

               while(flagDrop)
	       {
		  flagDropFun();break;
		 }


              a = (int)(Math.random()*100);
	      b = (int)(Math.random()*100);
	      c = (int)(Math.random()*10);


              if(y<TOPLINE||y2<TOPLINE||y3<TOPLINE)
              {
		oneUpCount++;
		if(oy<TOPLINE)
		{
		     ox=0; oy =0;     flagOneUp = false;
	          }
                }

                if(y<TOPLINE)
                 {
	                     x = a+b+c;
                             y = y2+100;


	            if(by<TOPLINE-11||flagNew1)
                     {
                         bx = x+30;
			 by = y-11;
			 flagNew1 = false;
			 flagOnx = true;
                         flagBetween = true;

			}


		     }

                  else if(y2<TOPLINE)
                  {

                             x2 = a+b+c;
                             y2 = y3+100;



                    if(by<39||flagNew1)
                     {
                         bx = x2+30;
			 by = y2-11;
		         flagNew1 = false;
                         flagOnx2 = true;
			 flagBetween = true;

			}

                     }

                  else if(y3<TOPLINE)
                   {
                             x3 = a+b+c;
                             y3 = y+100;



                    if(by<39||flagNew1)
                     {
                         bx = x3+30;
			 by = y3-11;
			 flagOnx3 = true;
			 flagNew1 = false;
  			 flagOnx3 = true;
			 flagBetween = true;
			}

                     }
                      y -= 1;
                      y2 -=1;
                      y3 -= 1;

                   if(flagOneUp)
		   {
		      if(t2==1)
                      {
			ox = x+t2+t3;
			oy = y-5;
			}

		      else if(t2==2)
                     {
			ox = x2+t2+t3;
			oy = y2-5;

			}
		      else if(t2==3)
                      {
			ox = x3+t2+t3;
			oy = y3-5;

			}

		      }

		    if(oneUpCount==7)
                    {
			t1 =(int)(Math.random()*10);
			t3 = (int)(Math.random()*10);
			t2 = (int)(t1/3)+1;
			flagOneUp = true;
			oneUpCount = 1;
	              }

                    if(by<TOPLINE)
                    {

                           if(by<TOPLINE-10)
                           {
                             t.sleep(100);
			     chances--;
                             }
                           if(chances==0)
			   {
                              msg = "Game Over"; repaint();
                              stop();
			     }
                     }



                if((flagOnx&&flagBetween))
                {

                  if(!flagLKey&&!flagRKey)
                  {
                     bx = x+30;
                    }
                   by = y-11;
                   flagJump = false;

                  }

                else if((flagOnx2&&flagBetween))
                {
                 if(!flagLKey&&!flagRKey)
		    bx = x2+30;
                  by = y2-11;
                  flagJump = false;

                  }
                else if(flagOnx3&&flagBetween)
                {
		  if(!flagLKey&&!flagRKey)
	             bx = x3+30;
                  by = y3-11;
                  flagJump = false;

                  }

               while(flagDrop)
                {
                    by += 1;
		    if(by>BOTTOMLINE)
                    {
                        chances--;
			flagNew1 = true;
			flagDrop = false;
                        t.sleep(100);
			if(chances == 0)
			{
                          msg = "Game Over"; repaint();
                              stop();
                          }

                       }
		    repaint(); break;
                  }

       /*             if(score%50==0)
		    {
			scrollSpeed -= 3; score += 5;
                      }	     */

	            repaint();

                    Thread.sleep(scrollSpeed);

                 } //end of while flagMove

               }
              catch(InterruptedException ie)
              {
                   System.out.println(ie);
                 }

           }
          public void stop()
          {
                flagMove = false;
                t = null;
              }

       public void paint(Graphics g)
        {
             b1.setBounds(x,y,70,20);
             b2.setBounds(x2,y2,70,20);
             b3.setBounds(x3,y3,70,20);
             ball.setBounds(bx,by,10,10);
             oneUp.setBounds(ox,oy,5,5);
	     g.drawString("Score :"+score,280,65);
	     g.drawString("Chances :"+chances,280,75);

             g.drawString(msg,100,100);

           }

 } // end of  BFrame

public class RapidRollGame
{
    public static void main(String []args)
     {
        Frame f1 = new GameFrame();
        f1.setVisible(true);

        }

  }
