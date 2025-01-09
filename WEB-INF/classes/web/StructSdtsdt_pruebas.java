package web ;
import com.genexus.*;

public final  class StructSdtsdt_pruebas implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_pruebas( )
   {
      this( -1, new ModelContext( StructSdtsdt_pruebas.class ));
   }

   public StructSdtsdt_pruebas( int remoteHandle ,
                                ModelContext context )
   {
      gxTv_Sdtsdt_pruebas_Nombre = "" ;
      gxTv_Sdtsdt_pruebas_Descripcion = "" ;
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

   public String getNombre( )
   {
      return gxTv_Sdtsdt_pruebas_Nombre ;
   }

   public void setNombre( String value )
   {
      gxTv_Sdtsdt_pruebas_N = (byte)(0) ;
      gxTv_Sdtsdt_pruebas_Nombre = value ;
   }

   public String getDescripcion( )
   {
      return gxTv_Sdtsdt_pruebas_Descripcion ;
   }

   public void setDescripcion( String value )
   {
      gxTv_Sdtsdt_pruebas_N = (byte)(0) ;
      gxTv_Sdtsdt_pruebas_Descripcion = value ;
   }

   public short getNro( )
   {
      return gxTv_Sdtsdt_pruebas_Nro ;
   }

   public void setNro( short value )
   {
      gxTv_Sdtsdt_pruebas_N = (byte)(0) ;
      gxTv_Sdtsdt_pruebas_Nro = value ;
   }

   public int getTestlegnumero1( )
   {
      return gxTv_Sdtsdt_pruebas_Testlegnumero1 ;
   }

   public void setTestlegnumero1( int value )
   {
      gxTv_Sdtsdt_pruebas_N = (byte)(0) ;
      gxTv_Sdtsdt_pruebas_Testlegnumero1 = value ;
   }

   public int getTestlegnumero2( )
   {
      return gxTv_Sdtsdt_pruebas_Testlegnumero2 ;
   }

   public void setTestlegnumero2( int value )
   {
      gxTv_Sdtsdt_pruebas_N = (byte)(0) ;
      gxTv_Sdtsdt_pruebas_Testlegnumero2 = value ;
   }

   public short getTestnro2( )
   {
      return gxTv_Sdtsdt_pruebas_Testnro2 ;
   }

   public void setTestnro2( short value )
   {
      gxTv_Sdtsdt_pruebas_N = (byte)(0) ;
      gxTv_Sdtsdt_pruebas_Testnro2 = value ;
   }

   public boolean getTestprobartodos( )
   {
      return gxTv_Sdtsdt_pruebas_Testprobartodos ;
   }

   public void setTestprobartodos( boolean value )
   {
      gxTv_Sdtsdt_pruebas_N = (byte)(0) ;
      gxTv_Sdtsdt_pruebas_Testprobartodos = value ;
   }

   public boolean getTestbono( )
   {
      return gxTv_Sdtsdt_pruebas_Testbono ;
   }

   public void setTestbono( boolean value )
   {
      gxTv_Sdtsdt_pruebas_N = (byte)(0) ;
      gxTv_Sdtsdt_pruebas_Testbono = value ;
   }

   public boolean getIigg( )
   {
      return gxTv_Sdtsdt_pruebas_Iigg ;
   }

   public void setIigg( boolean value )
   {
      gxTv_Sdtsdt_pruebas_N = (byte)(0) ;
      gxTv_Sdtsdt_pruebas_Iigg = value ;
   }

   protected byte gxTv_Sdtsdt_pruebas_N ;
   protected short gxTv_Sdtsdt_pruebas_Nro ;
   protected short gxTv_Sdtsdt_pruebas_Testnro2 ;
   protected int gxTv_Sdtsdt_pruebas_Testlegnumero1 ;
   protected int gxTv_Sdtsdt_pruebas_Testlegnumero2 ;
   protected String gxTv_Sdtsdt_pruebas_Nombre ;
   protected boolean gxTv_Sdtsdt_pruebas_Testprobartodos ;
   protected boolean gxTv_Sdtsdt_pruebas_Testbono ;
   protected boolean gxTv_Sdtsdt_pruebas_Iigg ;
   protected String gxTv_Sdtsdt_pruebas_Descripcion ;
}

