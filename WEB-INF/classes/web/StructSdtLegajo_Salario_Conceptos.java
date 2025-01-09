package web ;
import com.genexus.*;

public final  class StructSdtLegajo_Salario_Conceptos implements Cloneable, java.io.Serializable
{
   public StructSdtLegajo_Salario_Conceptos( )
   {
      this( -1, new ModelContext( StructSdtLegajo_Salario_Conceptos.class ));
   }

   public StructSdtLegajo_Salario_Conceptos( int remoteHandle ,
                                             ModelContext context )
   {
      gxTv_SdtLegajo_Salario_Conceptos_Legsuelconcepto = "" ;
      gxTv_SdtLegajo_Salario_Conceptos_Mode = "" ;
      gxTv_SdtLegajo_Salario_Conceptos_Legsuelconcepto_Z = "" ;
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

   public String getLegsuelconcepto( )
   {
      return gxTv_SdtLegajo_Salario_Conceptos_Legsuelconcepto ;
   }

   public void setLegsuelconcepto( String value )
   {
      gxTv_SdtLegajo_Salario_Conceptos_N = (byte)(0) ;
      gxTv_SdtLegajo_Salario_Conceptos_Legsuelconcepto = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtLegajo_Salario_Conceptos_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtLegajo_Salario_Conceptos_N = (byte)(0) ;
      gxTv_SdtLegajo_Salario_Conceptos_Mode = value ;
   }

   public short getModified( )
   {
      return gxTv_SdtLegajo_Salario_Conceptos_Modified ;
   }

   public void setModified( short value )
   {
      gxTv_SdtLegajo_Salario_Conceptos_N = (byte)(0) ;
      gxTv_SdtLegajo_Salario_Conceptos_Modified = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtLegajo_Salario_Conceptos_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtLegajo_Salario_Conceptos_N = (byte)(0) ;
      gxTv_SdtLegajo_Salario_Conceptos_Initialized = value ;
   }

   public String getLegsuelconcepto_Z( )
   {
      return gxTv_SdtLegajo_Salario_Conceptos_Legsuelconcepto_Z ;
   }

   public void setLegsuelconcepto_Z( String value )
   {
      gxTv_SdtLegajo_Salario_Conceptos_N = (byte)(0) ;
      gxTv_SdtLegajo_Salario_Conceptos_Legsuelconcepto_Z = value ;
   }

   private byte gxTv_SdtLegajo_Salario_Conceptos_N ;
   protected short gxTv_SdtLegajo_Salario_Conceptos_Modified ;
   protected short gxTv_SdtLegajo_Salario_Conceptos_Initialized ;
   protected String gxTv_SdtLegajo_Salario_Conceptos_Legsuelconcepto ;
   protected String gxTv_SdtLegajo_Salario_Conceptos_Mode ;
   protected String gxTv_SdtLegajo_Salario_Conceptos_Legsuelconcepto_Z ;
}

