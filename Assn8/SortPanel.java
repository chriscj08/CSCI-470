/* Class: SortPanel
 * 
 * Use: This class sets up and contains
 * the drawings we will be using on those panels
 * 
 */ 
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.util.Random;

public class SortPanel extends JPanel
{
  //Data members
  private boolean threadPaused;
  private int speed;
  private SortAnimationPanel animation;
  private String[] sortNames;
  private JComboBox<String> sortType;
  private int[] numbers;
  
  public SortPanel()
  {
    speed = 0;
    
    sortNames = new String[]{"Selection Sort", "Shell Sort", "Merge Sort"};
    
    animation = new SortAnimationPanel();
    sortType = new JComboBox<String>(sortNames);
    
    setLayout(new BorderLayout());
    setBorder(BorderFactory.createLineBorder(Color.black));
    
    add(animation, BorderLayout.CENTER);
    add(sortType, BorderLayout.SOUTH);
    
  }
  
  public void setSpeed(String speed)
  {
    if (speed == "Slow")
      this.speed = 100;
    else if (speed == "Medium")
      this.speed = 50;
    else if (speed == "Fast")
      this.speed = 25;
  }
  public SortAnimationPanel getAnimation()
  {
    return this.animation;
  }
  
  //set method for threadPaused
  public void setThreadPaused(boolean threadPaused)
  {
    this.threadPaused = threadPaused;
  }
  
  public void setNumbers(int[] numbers)
  {
    this.numbers = numbers;
  }
  
  public void populate()
  {   
    setThreadPaused(false);
    animation.repaint();   
  }
  
  public void sort(JButton populateBtn)
  {   
    animation.sort(populateBtn);     
  }
  
  public synchronized void pauseSort()
  {
    setThreadPaused(true);
  }
  
  public synchronized void resumeSort()
  {
    setThreadPaused(false);
    animation.resumeSort();    
  }
  
  public class SortAnimationPanel extends JPanel implements Runnable
  {
    volatile Thread thread;
    JButton populateBtn;
    
    public void sort(JButton populateBtn)
    {
      this.populateBtn = populateBtn;
      thread = new Thread(this);
      thread.start();
    }
    
    public synchronized void resumeSort()
    {
      notify();
    }
    
    @Override
    protected void paintComponent(Graphics g)
    {
      super.paintComponent(g);
      
      Dimension size = new Dimension();
      size = getSize();
      
      if (numbers != null)
      {
        for (int i = 0; i < numbers.length; i++)
        {
          g.drawLine(i, size.height, i, numbers[i]);
        }
      }
    }
    
    @Override
    public void run()
    {
      Thread thisThread = Thread.currentThread();
      
      if (sortType.getSelectedItem() == "Selection Sort")
      {
        if (numbers != null)
          selectionSort(numbers);
        
        populateBtn.setEnabled(true);
      }
      else if (sortType.getSelectedItem() == "Merge Sort")
      {
        if (numbers != null)
          mergeSort(numbers, 0, numbers.length - 1); 
        
        populateBtn.setEnabled(true);
      }
      else if (sortType.getSelectedItem() == "Shell Sort")
      {
        if (numbers != null)
         shellSort(numbers);
       
        populateBtn.setEnabled(true);
      }                     
    
    }
    
    public void selectionSort(int[] numbers)
    {
       int i, j, min_idx; 
  
        // One by one move boundary of unsorted subarray 
        for (i = 0; i < numbers.length - 1; i++) 
        { 
          // Find the minimum element in unsorted array 
          min_idx = i; 
          for (j = i+1; j < numbers.length; j++) 
            if (numbers[j] > numbers[min_idx]) 
              min_idx = j; 
  
          // Swap the found minimum element with the first element  
          int temp = numbers[min_idx]; 
          numbers[min_idx] = numbers[i]; 
          numbers[i] = temp;         
        
          try
          {
            Thread.sleep(speed);
            repaint();
            
            synchronized(this)
            {
              while (threadPaused)
              wait();
            }
          }
          catch(InterruptedException e)
          {  
          }
        }
    }
    

/* function to sort arr using shellSort */
    public void shellSort(int array[]) 
    { 
        int gap = array.length / 2; 
  
        while (gap > 0) {

        for (int i = 0; i < array.length - gap; i++) { //modified insertion sort

          int j = i + gap;

          int tmp = array[j];

          while (j >= gap && tmp > array[j - gap]) {

          array[j] = array[j - gap];
           try
             {
               Thread.sleep(speed);
               repaint();
               
               
               synchronized(this)
               {
                 while (threadPaused)
                 wait();
               }
             }
             catch(InterruptedException e)
             {  
             }  

          j -= gap;
          }

          array[j] = tmp;

          }

         if (gap == 2) { //change the gap size

         gap = 1;

         } else {

         gap /= 2;

}

}


        
    } 
  
   public void merge(int arr[], int l, int m, int r) 
    { 
      int i, j, k; 
      int n1 = m - l + 1; 
      int n2 =  r - m; 
  
      /* create temp arrays */
      int[] L = new int[n1];
      int[] R = new int[n2]; 
  
      /* Copy data to temp arrays L[] and R[] */
      for (i = 0; i < n1; i++) 
        L[i] = arr[l + i]; 
      for (j = 0; j < n2; j++) 
        R[j] = arr[m + 1+ j]; 
  
      /* Merge the temp arrays back into arr[l..r]*/
      i = 0; // Initial index of first subarray 
      j = 0; // Initial index of second subarray 
      k = l; // Initial index of merged subarray 
      while (i < n1 && j < n2) 
      { 
        if (L[i] >= R[j]) 
        { 
          arr[k] = L[i]; 
          i++; 
        } 
        else
        { 
          arr[k] = R[j]; 
          j++; 
        } 
        k++; 
      } 
  
      /* Copy the remaining elements of L[], if there 
         are any */
      while (i < n1) 
      { 
        arr[k] = L[i]; 
        i++; 
        k++; 
      } 
  
      /* Copy the remaining elements of R[], if there 
       are any */
      while (j < n2) 
      { 
        arr[k] = R[j]; 
        j++; 
        k++; 
      } 
      
      try
      {
        Thread.sleep(speed);
        repaint();
        
        synchronized(this)
        {
           while (threadPaused)
           wait();
        }
      }
      catch (InterruptedException e)
      {
      }
    } 
    
    //Recursive sorting algorithm
    public void mergeSort(int arr[], int l, int r) 
    { 
      if (l < r) 
      { 
        // Same as (l+r)/2, but avoids overflow for 
        // large l and h 
        int m = l+(r-l)/2; 
  
        // Sort first and second halves 
        mergeSort(arr, l, m); 
        mergeSort(arr, m+1, r); 
  
        merge(arr, l, m, r); 
      } 
    } 
  }
}