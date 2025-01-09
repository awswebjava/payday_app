package web ;
import com.genexus.*;

public final  class StructSdtSDTOperandosFormula implements Cloneable, java.io.Serializable
{
   public StructSdtSDTOperandosFormula( )
   {
      this( -1, new ModelContext( StructSdtSDTOperandosFormula.class ));
   }

   public StructSdtSDTOperandosFormula( int remoteHandle ,
                                        ModelContext context )
   {
      gxTv_SdtSDTOperandosFormula_Operandooriginal = "" ;
      gxTv_SdtSDTOperandosFormula_Operandocambiado = "" ;
      gxTv_SdtSDTOperandosFormula_Quees = "" ;
      gxTv_SdtSDTOperandosFormula_Descripcion = "" ;
      gxTv_SdtSDTOperandosFormula_Operandocambiado2 = "" ;
      gxTv_SdtSDTOperandosFormula_Nombre = "" ;
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

   public String getOperandooriginal( )
   {
      return gxTv_SdtSDTOperandosFormula_Operandooriginal ;
   }

   public void setOperandooriginal( String value )
   {
      gxTv_SdtSDTOperandosFormula_N = (byte)(0) ;
      gxTv_SdtSDTOperandosFormula_Operandooriginal = value ;
   }

   public String getOperandocambiado( )
   {
      return gxTv_SdtSDTOperandosFormula_Operandocambiado ;
   }

   public void setOperandocambiado( String value )
   {
      gxTv_SdtSDTOperandosFormula_N = (byte)(0) ;
      gxTv_SdtSDTOperandosFormula_Operandocambiado = value ;
   }

   public String getQuees( )
   {
      return gxTv_SdtSDTOperandosFormula_Quees ;
   }

   public void setQuees( String value )
   {
      gxTv_SdtSDTOperandosFormula_N = (byte)(0) ;
      gxTv_SdtSDTOperandosFormula_Quees = value ;
   }

   public short getI( )
   {
      return gxTv_SdtSDTOperandosFormula_I ;
   }

   public void setI( short value )
   {
      gxTv_SdtSDTOperandosFormula_N = (byte)(0) ;
      gxTv_SdtSDTOperandosFormula_I = value ;
   }

   public short getLength( )
   {
      return gxTv_SdtSDTOperandosFormula_Length ;
   }

   public void setLength( short value )
   {
      gxTv_SdtSDTOperandosFormula_N = (byte)(0) ;
      gxTv_SdtSDTOperandosFormula_Length = value ;
   }

   public String getDescripcion( )
   {
      return gxTv_SdtSDTOperandosFormula_Descripcion ;
   }

   public void setDescripcion( String value )
   {
      gxTv_SdtSDTOperandosFormula_N = (byte)(0) ;
      gxTv_SdtSDTOperandosFormula_Descripcion = value ;
   }

   public String getOperandocambiado2( )
   {
      return gxTv_SdtSDTOperandosFormula_Operandocambiado2 ;
   }

   public void setOperandocambiado2( String value )
   {
      gxTv_SdtSDTOperandosFormula_N = (byte)(0) ;
      gxTv_SdtSDTOperandosFormula_Operandocambiado2 = value ;
   }

   public String getNombre( )
   {
      return gxTv_SdtSDTOperandosFormula_Nombre ;
   }

   public void setNombre( String value )
   {
      gxTv_SdtSDTOperandosFormula_N = (byte)(0) ;
      gxTv_SdtSDTOperandosFormula_Nombre = value ;
   }

   protected byte gxTv_SdtSDTOperandosFormula_N ;
   protected short gxTv_SdtSDTOperandosFormula_I ;
   protected short gxTv_SdtSDTOperandosFormula_Length ;
   protected String gxTv_SdtSDTOperandosFormula_Quees ;
   protected String gxTv_SdtSDTOperandosFormula_Nombre ;
   protected String gxTv_SdtSDTOperandosFormula_Operandooriginal ;
   protected String gxTv_SdtSDTOperandosFormula_Operandocambiado ;
   protected String gxTv_SdtSDTOperandosFormula_Descripcion ;
   protected String gxTv_SdtSDTOperandosFormula_Operandocambiado2 ;
}

