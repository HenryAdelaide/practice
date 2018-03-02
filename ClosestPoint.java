package com.adelaide.henry.bruceforce;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

//The Class that is used to find the points
public class ClosestPoint {
    private class Point implements Comparable<Point>{
        private double x;
        private double y;
        Point(double x,double y){
            this.x = x;
            this.y = y;
        }
        public void setX(double x){
            this.x = x;
        }
        public double getX() {
            return x;
        }
        public double getY() {
            return y;
        }
        public void setY(double y) {
            this.y = y;
        }
        @Override
        public int compareTo(@NotNull Point o) {
            if(this.distance() > o.distance()){
                return 1;
            }else if(this.distance() < o.distance()){
                return -1;
            }else{
                return 0;
            }
        }
        public double distance(){
            return this.getX()*this.getX() + this.getY()*this.getY();
        }
    }
    private class Heap{
        private Point[] array;
        private int i = 0;
        Heap(int k){
            array = new Point[k];
        }
        /*
        public void add(Point point){
            if(i == array.length){
                //sort();
                Arrays.sort(array);
                if(point.distance() < array[i-1].distance()){
                    array[i-1] = point;
                    //sort();
                }
            }else{
                array[i++] = point;
            }
        }
        */
        public void add(Point point){
            if(i == array.length){
                sort();
                if(point.distance() < array[i-1].distance()) {
                    array[i - 1] = point;
                }
            }else{
                array[i++] = point;
            }
        }
        public Point[] getArray(){
            return array;
        }
        /*
        public void sort(){
            for(int i = 0;i < array.length;i++){
                for(int j = i+1;j < array.length;j++){
                    if(array[i].distance() > array[j].distance()){
                        Point p = array[i];
                        array[i] = array[j];
                        array[j] = p;
                    }
                }
            }
        }
        */
        private void maxHeapify(int index,int heapSize){
            int iMax = index, iLeft = 2 * index + 1,
                    iRight = 2 * (index + 1);
            if(iLeft < heapSize && array[index].distance() < array[iLeft].distance()){
                iMax = iLeft;
            }
            if(iRight < heapSize && array[index].distance() < array[iLeft].distance()){
                iMax = iRight;
            }
            if(iMax != index){
                swap(iMax,index);
                maxHeapify(iMax,heapSize);
            }
        }
        private void swap(int i,int j){
            Point temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        private void buildMaxHeap(Point[] array){
            int iParent = (int)Math.floor((array.length-1)/2);
            for(int i = iParent;i >= 0;i--){
                maxHeapify(i,array.length);
            }

        }
        public void sort(){
            //initialize the Heap that every sub-heap is heap
            buildMaxHeap(array);
            for(int i = array.length-1;i > 0;i--){
                swap(0,i);
                maxHeapify(0,i);
            }
        }
    }
    public ClosestPoint(){

    }
    public static void findClosestPoints(Point[] Points,int k){
        //double[] array = new double[k];
        ClosestPoint cp = new ClosestPoint();
        //Heap heap = cp.new Heap(k);
        Heap heap = cp.new Heap(k);
        for(int i = 0;i < Points.length;i++){
             heap.add(Points[i]);
        }
        //Point[] p1 = heap.getArray();
        heap.sort();
        for(Point p : heap.getArray()){
            System.out.print(p.getX() + " " + p.getY());
            System.out.println();
        }
    }
    public static void main(String[] args){
        ClosestPoint cp = new ClosestPoint();
        Point p1 = cp.new Point(3.0,2.0);
        Point p2 = cp.new Point(0.2,0.5);
        Point p3 = cp.new Point(1.0,1.5);
        Point p4 = cp.new Point(3.6,3.5);
        Point p5 = cp.new Point(0.8,1.5);
        Point[] array = {p1,p2,p3,p4,p5};
        findClosestPoints(array,3);
    }
}
