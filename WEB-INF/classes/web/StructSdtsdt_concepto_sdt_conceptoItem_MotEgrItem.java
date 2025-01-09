package web ;
import com.genexus.*;

public final  class StructSdtsdt_concepto_sdt_conceptoItem_MotEgrItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_concepto_sdt_conceptoItem_MotEgrItem( )
   {
      this( -1, new ModelContext( StructSdtsdt_concepto_sdt_conceptoItem_MotEgrItem.class ));
   }

   public StructSdtsdt_concepto_sdt_conceptoItem_MotEgrItem( int remoteHandle ,
                                                             ModelContext context )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Megcodigo = "" ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Megpreatipo = "" ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegdura = "" ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegpropor = new java.math.BigDecimal(0) ;
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

   public String getMegcodigo( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Megcodigo ;
   }

   public void setMegcodigo( String value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Megcodigo = value ;
   }

   public String getMegpreatipo( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Megpreatipo ;
   }

   public void setMegpreatipo( String value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Megpreatipo = value ;
   }

   public byte getConmegmeses( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegmeses ;
   }

   public void setConmegmeses( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegmeses = value ;
   }

   public String getConmegdura( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegdura ;
   }

   public void setConmegdura( String value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegdura = value ;
   }

   public java.math.BigDecimal getConmegpropor( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegpropor ;
   }

   public void setConmegpropor( java.math.BigDecimal value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegpropor = value ;
   }

   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegmeses ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_N ;
   protected String gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Megcodigo ;
   protected String gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Megpreatipo ;
   protected String gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegdura ;
   protected java.math.BigDecimal gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegpropor ;
}

