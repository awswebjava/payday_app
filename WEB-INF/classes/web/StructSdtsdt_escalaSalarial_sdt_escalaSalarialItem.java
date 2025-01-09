package web ;
import com.genexus.*;

public final  class StructSdtsdt_escalaSalarial_sdt_escalaSalarialItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_escalaSalarial_sdt_escalaSalarialItem( )
   {
      this( -1, new ModelContext( StructSdtsdt_escalaSalarial_sdt_escalaSalarialItem.class ));
   }

   public StructSdtsdt_escalaSalarial_sdt_escalaSalarialItem( int remoteHandle ,
                                                              ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Cliconvenio = "" ;
      gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catcodigo = "" ;
      gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catvigencia = cal.getTime() ;
      gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Escbasico = new java.math.BigDecimal(0) ;
      gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Escadicional = new java.math.BigDecimal(0) ;
      gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catvigencia_N = (byte)(1) ;
   }

   public Object clone()
   {
      Object cloned = null;
      try
      {
         cloned = super.clone();
      }catch (CloneNotSupportedException e){ ; }
      return cloned;
   }

   public String getCliconvenio( )
   {
      return gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Cliconvenio ;
   }

   public void setCliconvenio( String value )
   {
      gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_N = (byte)(0) ;
      gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Cliconvenio = value ;
   }

   public String getCatcodigo( )
   {
      return gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catcodigo ;
   }

   public void setCatcodigo( String value )
   {
      gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_N = (byte)(0) ;
      gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catcodigo = value ;
   }

   public java.util.Date getCatvigencia( )
   {
      return gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catvigencia ;
   }

   public void setCatvigencia( java.util.Date value )
   {
      gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catvigencia_N = (byte)(0) ;
      gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_N = (byte)(0) ;
      gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catvigencia = value ;
   }

   public short getClipaiconve( )
   {
      return gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Clipaiconve ;
   }

   public void setClipaiconve( short value )
   {
      gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_N = (byte)(0) ;
      gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Clipaiconve = value ;
   }

   public java.math.BigDecimal getEscbasico( )
   {
      return gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Escbasico ;
   }

   public void setEscbasico( java.math.BigDecimal value )
   {
      gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_N = (byte)(0) ;
      gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Escbasico = value ;
   }

   public java.math.BigDecimal getEscadicional( )
   {
      return gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Escadicional ;
   }

   public void setEscadicional( java.math.BigDecimal value )
   {
      gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_N = (byte)(0) ;
      gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Escadicional = value ;
   }

   protected byte gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catvigencia_N ;
   protected byte gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_N ;
   protected short gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Clipaiconve ;
   protected String gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Cliconvenio ;
   protected String gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catcodigo ;
   protected java.util.Date gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catvigencia ;
   protected java.math.BigDecimal gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Escbasico ;
   protected java.math.BigDecimal gxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Escadicional ;
}

