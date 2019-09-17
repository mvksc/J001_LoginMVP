<div align="center">
    <img src="/screenshots/img001.png" width="300px"</img> 
    <img src="/screenshots/img002.png" width="300px"</img> 
</div>

<div>
<br>*** MVP เป็น Design Pattern หรือ รูปแบบการเขียนโปรแกรมที่ได้รับความนิยมชนิดหนึ่ง<br>

*** MVP ย่อมาจาก Model-View-Presenter แต่ละส่วนทำหน้าที่ดังนี้<br>
    1.Model คือ POJO class นั่นแหละ หรือโครงสร้างข้อมูล (Data) ที่เกี่ยวข้องกับการทำงานของระบบนั่นเอง เช่น Model<br>
    2.View คือ ส่วนที่ใช้ในการแสดงผล จะไม่ทำการคำนวณที่ซับซ้อน เช่น Activity , Fragment<br>
    3.Presenter คือ Class ที่เอาไว้จัดการการทำงานของแอพและพวก Business Logic ต่างๆ 
    และเป็นตัวกลางระหว่าง View กับ Model โดยที่ Presenter จะรับข้อมูลจาก Model แล้วส่งให้ View แสดงผล<br>

*** MVP จำเป็นที่จะต้องมี Interface ของ View และ Presenter เพื่อให้ View ตัวนั้นสามารถสั่งให้ Presenter ที่ถืออยู่ทำอะไรเมื่อเกิด Event ขึ้น 
หรือ Presenter ตัวนั้นส่งค่าอะไรไปให้ View ตัวที่ถืออยู่แสดงผล
</dive>
